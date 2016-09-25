<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.mundipagg.service.CreateOrderRequest"%>
<%@page import="spwork.Boleto003"%>
<%@page import="br.com.mundipagg.service.BoletoTransactionResult"%>
<%@page import="br.com.mundipagg.service.CreateOrderResponse"%>
<%@page import="br.com.mundipagg.service.EmailUpdateToBuyerEnum"%>
<%@page import="br.com.mundipagg.service.CurrencyIsoEnum"%>
<%@page import="java.util.Random"%>
<%@page import="br.com.mundipagg.service.Buyer"%>
<%@page import="br.com.mundipagg.service.BoletoTransaction"%>
<%@page import="br.com.mundipagg.client.MundiPaggClient"%>
<%@page import="spwork.Client001"%>
<%@page import="spwork.User_Helper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="spwork.User002"%>



<head>
            <tr><td><%@include file='header_pages.jsp'%></td></tr>
            <script>
            mixpanel.track('Page View',{'Page name':'pagamento_boleto'});
        </script>
</head>

<%
                Calendar now = Calendar.getInstance();
                /* Variáveis do HTML */
                String cpf = request.getSession().getAttribute("cpf").toString();
                String name = request.getSession().getAttribute("name").toString();
                String url_primeiro_boleto="",url="";
                String transactionkey="",transactionkey_primeiro_boleto="";
                String debt_total_string=request.getSession().getAttribute("debt_total").toString();;
                String parcela_boleto_string = request.getParameter("parcela_boleto");
                String total_string=request.getSession().getAttribute("total").toString();;
                
                double valor_parcelas;
                double valor_parcelas_aux;
                double debt_total = Double.parseDouble(debt_total_string);
                double total = Double.parseDouble(total_string);
                int parcelas = Integer.parseInt(parcela_boleto_string);
                Long debt_long; //Enviado à MundiPagg que quer o valor em centavos
                
                DecimalFormat df = new DecimalFormat("0.00"); //formatar com 2 casas decimais 
               
                /* Variáveis Banco de Dados */
                List <User002> user_list = new ArrayList(); //Usuário
                User_Helper user_helper_cpf = new User_Helper();
                user_list = user_helper_cpf.List_User_From_CPF(cpf,true); //Busco Usuário pelo CPF
                Client001 cliente=new Client001(); //Cliente, exemplo ESTACIO CEUT
                User_Helper user_helper_client = new User_Helper(); 
                cliente = user_helper_client.Search_Client_From_Cod_Client(user_list.get(0).getCodInstcClint002());
                Long cod_instc_user_long = (user_list.get(0).getCodInstc002()); //cod_instc_usr
              
                /*Contas do Desconto e do valor das parcelas*/
                if(parcelas==1)
                    {
                    valor_parcelas =  (total*1/parcelas);
                    total = total*0.1;
                    }
                else {
                    
                    if (parcelas <= 6) {
                        valor_parcelas =  (total*1/parcelas);
                        total = total*0.75;
                        }
                    
                    else {
                        valor_parcelas=(total*1.0/parcelas);
                        total = total*1;
                        }
                        
                    }
                    valor_parcelas = valor_parcelas * 100;
                    debt_long= (long) valor_parcelas;        
                    valor_parcelas_aux = valor_parcelas / 100;
                       

            
                   /*Conexão com a MundiPagg */
            
                    for(int i=1;i<=parcelas;i++){
                        MundiPaggClient client = new MundiPaggClient();
                        BoletoTransaction boletoTransaction = new BoletoTransaction();

                        /*Informações Boleto*/
                        boletoTransaction.setAmountInCents(debt_long);
                        boletoTransaction.setBankNumber("237"); //Bradesco
                        boletoTransaction.setNossoNumero("");
                        boletoTransaction.setDaysToAddInBoletoExpirationDate(4+(i-1)*30);
                        
                        
                        
                        
                       //Instruções do boleto
                        String quebraLinha = System.lineSeparator(); 

                        String instructions = "Curso: "+user_list.get(0).getSubProd002()+quebraLinha;
                        instructions+="Parcelas:"+ Integer.toString(i)+"/"+Integer.toString(parcelas)+quebraLinha;
                        instructions+="Contato: contato@adimplere.com.br"+quebraLinha;
                        instructions+="Telefone: (21)3512-5075";



                        boletoTransaction.setInstructions(instructions);


                    /*Informações Comprador*/
                    Buyer buyer = new Buyer();
                    buyer.setName(name);
                    buyer.setTaxDocumentNumber(cpf);
               
                

         
                /*Criação do Pedido à Mundipagg*/
                    CreateOrderRequest Request = new CreateOrderRequest();

                    Request.setAmountInCents(debt_long);
                    //Cria um numero aleatorio
                    Random generator = new Random();
                    Integer randomNumber = generator.nextInt(1000);
                    Request.setCurrencyIsoEnum(CurrencyIsoEnum.BRL);
                    Request.setEmailUpdateToBuyerEnum(EmailUpdateToBuyerEnum.No);
                    // Chave da Loja
                    Request.setMerchantKey("bdc974fc-b056-421d-b278-5a3b4df1cfa9");
                    Request.setBuyer(buyer);
		
		
                    //Criando uma cole??o de transa??es
                    BoletoTransaction[] BoletoTransactionCollection = new BoletoTransaction[1];

                
                    BoletoTransactionCollection[0] = boletoTransaction;
                    Request.setBoletoTransactionCollection(BoletoTransactionCollection);
		
                    Request.setOrderReference( randomNumber.toString());
                    CreateOrderResponse Response =  client.createOrder(Request);
		
		boolean sucess = false;
                try{
                        sucess = Response.getSuccess(); //Resposta da Mundipagg
                   }
                catch(Exception e){       
                   //Erro de conexão
                }


                    if(sucess==true){

                        /*Valores de resposta --xml enviado na hora*/
                        BoletoTransactionResult[] BoletoTransactionCollectionResult = new BoletoTransactionResult[1];
                        BoletoTransactionCollectionResult = Response.getBoletoTransactionResultCollection(); //Todo xml de resposta está aqui




                        /*Peguei a url*/
                        url = BoletoTransactionCollectionResult[0].getBoletoUrl();
                        if(i==1){
                            url_primeiro_boleto = BoletoTransactionCollectionResult[0].getBoletoUrl();
                            transactionkey_primeiro_boleto = BoletoTransactionCollectionResult[0].getTransactionKey();
                        }
                        
                        transactionkey = BoletoTransactionCollectionResult[0].getTransactionKey();
                        String AmountInCents = Long.toString(BoletoTransactionCollectionResult[0].getAmountInCents());
                        String TransactionReference = BoletoTransactionCollectionResult[0].getTransactionReference();
                        url = BoletoTransactionCollectionResult[0].getBoletoUrl();
                        if(i==1)
                            now.add(Calendar.DATE,4);
                        else
                            now.add(Calendar.DATE,30);   
                        
                        
                        
                        


                        /*Objeto boleto para ser add no bd */
                        Boleto003 boleto = new Boleto003();


                        boleto.setCodInstcUser003(cod_instc_user_long);
                        boleto.setCodInstcClint003(user_list.get(0).getCodInstcClint002());
                        boleto.setDatVnc003(new java.sql.Date(now.getTimeInMillis()));

                        boleto.setAmountInCents003(AmountInCents);                     
                        boleto.setTransactionReference003(TransactionReference);
                        boleto.setTransactionKey003(transactionkey);
                        boleto.setBoletoTransactionStatus003("Não Pago");
                        boleto.setUrl003(url);
                        boleto.setCodInstcBuy003(transactionkey_primeiro_boleto);


                        User_Helper user_add_boleto = new User_Helper();

                        user_add_boleto.AddBoleto(boleto);
                        

                    
                        if(i==1){
                        
                   %>
                   <div class="breadcrumb-section breadcrumb-style-3" style="background-image: url('images/breadcrumb/shop-breadcrumb-bg.jpg');">

                <!-- main-section -->
                <div class="main-section">
                    <!-- section-container -->
                    <div class="section-container">


                        <!-- container -->
                        <div class="container">
                            <!-- row -->
                            <div class="row">


                                <!-- col-md-12 -->
                                <div class="col-md-12">


                                    <!-- breadcrumb-head -->
                                    <div class="breadcrumb-head">
                                        <div class="breadcrumb-title">
                                            <h1>Envio de Informações de Pagamento</h1>
                                        </div><!-- /breadcrumb-title -->

                                    </div><!-- /breadcrumb-head -->


                                    <!-- breadcrumb -->
                                    <ol class="breadcrumb">
                                        <li><a href="index.jsp" title="Home">Home</a></li>
                                        <li><a href="pesquisar_pendencias.jsp" title="Shop">pesquisa de pendencias</a></li>
                                        <li class="active">checkout</li>
                                    </ol><!-- /breadcrumb -->


                                </div><!-- /col-md-12 -->


                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /breadcrumb-section -->


<div class="light-section">

                <!-- main-section -->
                <div class="main-section">
                    <!-- section-container -->
                    <div class="section-container">


                        <!-- container -->
                        <div class="container">
                            <!-- row -->
                            <div class="row">

                                

                                <!-- col-md-9 main-content -->
                                <div class="col-md-12 main-content">



                                    <!-- row -->
                                    <div class="row">
                                        <!-- col-md-12 -->
                                        <div class="col-md-12">

                                            <!-- small-section-title -->
                                            <div class="small-section-title">
                                                <h4>Inserir email</h4>
                                            </div><!-- /small-section-title -->

                                        </div><!-- /col-md-12 -->
                                    </div><!-- /row -->


                                    <!-- row -->
                                    <div class="row">
                                        <!-- billing-form -->
                                      
                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- First Name -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Digite o email para envio das informações de pagamento" name="email_conf1" id="email_conf1">
                                                </div><!-- /First Name -->
                                            </div><!-- /col-md-6 -->


                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Digite novamente o email" name="email_conf2" id="email_conf2">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->

                                            <br><br>
                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                <button type="submit" class="btn btn-nesto" onclick="validate_SendEmail_Redirect('<%=url_primeiro_boleto%>','<%=user_list.get(0).getName002()%>','<%=cliente.getDesc001()%>','<%=df.format(valor_parcelas_aux)%>','Boleto Bancário','<%=transactionkey%>','<%=user_list.get(0).getCpf002()%>');">Visualizar e Enviar por email</button>
                                            </div><!-- /col-md-12 -->


                                        
                                    </div><!-- /row -->


                                </div><!-- /col-md-9 main-content -->

                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->

 <%
                                            }
                    }
                    }
                    
	
      %>
                   
