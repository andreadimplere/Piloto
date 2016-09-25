<%@page import="br.com.mundipagg.service.Buyer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="spwork.User002"%>
<%@page import="spwork.User_Helper"%>
<%@page import="spwork.CreditCard004"%>
<%@page import="br.com.mundipagg.service.CreditCardTransactionResult"%>
<%@page import="br.com.mundipagg.service.CreateOrderResponse"%>
<%@page import="br.com.mundipagg.service.CreditCardBrandEnum"%>
<%@page import="br.com.mundipagg.service.CreditCardTransaction"%>
<%@page import="br.com.mundipagg.service.EmailUpdateToBuyerEnum"%>
<%@page import="br.com.mundipagg.service.CurrencyIsoEnum"%>
<%@page import="java.util.Random"%>
<%@page import="br.com.mundipagg.service.CreateOrderRequest"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="br.com.mundipagg.client.MundiPaggClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 
<head>
            <tr><td><%@include file='header_pages.jsp'%></td></tr>
            <script>
            mixpanel.track('Page View',{'Page name':'pagamento_credit_card'});
        </script>
</head>

<html>
     <body>
    
    <%
            //Variáveis da página anterior
            String cpf = request.getSession().getAttribute("cpf").toString();
            String cliente = request.getSession().getAttribute("cliente").toString();
            Double debt_total =Double.parseDouble(request.getSession().getAttribute("debt_total").toString());
            Double total = Double.parseDouble(request.getSession().getAttribute("total").toString());
            String debt_total_atualizado =request.getSession().getAttribute("debt_total_atualizado").toString();
            String debt_total_aux = request.getSession().getAttribute("debt_total").toString(); //Manterá o valor sem o desconto. Caso a cielo não autorize dados, terei que saber o valor antigo sem desconto para remostrar ao usuário
            String total_aux = request.getSession().getAttribute("total").toString(); // valor com juros e multa
            String name = request.getSession().getAttribute("name").toString();
            String date = request.getParameter("date_valid");
            String cod_seg = request.getParameter("cod_seg_credit_card");
            String nr_credit_card = request.getParameter("nr_credit_card");
            String flag_credit_card = request.getParameter("flag_credit_card");
            int parcelas=0;
            
            
            //Verifica se existe usuário com esse CPF ativo e validar campos null
            User_Helper user_helper_test = new User_Helper();
            boolean has_user = user_helper_test.Test_User_From_CPF(cpf,true);
            boolean data_null = true;
            if(flag_credit_card==null|| nr_credit_card==null || cod_seg==null || date==null || name==null || debt_total_aux==null|| cliente==null || cpf==null){
                data_null=false;        
            }
            
            try{
                parcelas = Integer.parseInt(request.getParameter("parcela_credit_card"));
            }
            catch(Exception e)
            {
                data_null=false;
            }
            //Variáveis de Controle
            String msg="";
            String msg_status="",status="";
            String transactionkey = null;
            boolean ok=true,ok2=true,ok3=true,sucess=false;
            int ind_sit=0;
           
            DecimalFormat df = new DecimalFormat("0.00"); //formatar com 2 casas decimais 
            Double valor_parcelas;
            
            //Cálculo do debt_total com desconto e do númnero de parcelas
            if(parcelas<=3)
            {
                valor_parcelas =  (1.0/parcelas);
                total = total*1;
                
            }
            else{
                valor_parcelas =  (total*1/parcelas);
                 total = total*1;
            }
            
            //esse valor que será realmente enviado a mudnipagg, deve ser long e em centavos
            long debt_cents = (long) (total*100); 
            
            //VALIDACAO DE DATA
            if(date.length()!=5 && date.length()!=7){
                ok=false;
                msg="Data Inválida; "+"\n";
            }
            else{
                if(date.charAt(2)!='/' ){
                    ok=false;
                    msg="Data Inválida; "+"\n";
                }
                if(!Character.isDigit(date.charAt(0)) || !Character.isDigit(date.charAt(1)) || !Character.isDigit(date.charAt(3))|| !Character.isDigit(date.charAt(4))){
                    ok=false;  
                    msg="Data Inválida; "+"\n";
                }
                 else{
                       if(date.length()==7){
                          if(!Character.isDigit(date.charAt(5)) || !Character.isDigit(date.charAt(6))){
                               ok=false;  
                               msg="Data Inválida; "+"\n";  
                          }

                      }

                     if(Integer.parseInt(date.substring(0,2))>12)
                     ok=false;
                     if(date.length()==5){
                         if(Integer.parseInt(date.substring(3,5))<15)
                             ok=false;
                     }
                     if(date.length()==7){
                         if(Integer.parseInt(date.substring(3,7))<2015)
                             ok=false;
                     }
                     if(ok==false)
                         msg="Data Inválida; "+"\n";
                }
            }               

            
            //VALIDAÇÂO DO CODIGO DE SEGURANCA
            if((cod_seg).length()!=3 && (cod_seg).length()!=4 ){
                ok=false;
                msg+="Código de Segurança deve conter 3 ou 4 dígitos; "+"\n";

            }
            else{
                for(int i=0;i<cod_seg.length();i++)
                {
                    if(!Character.isDigit(cod_seg.charAt(i))){
                        ok=false;
                        ok2=false;

                    }

                }
                if(ok2==false)
                   msg+="Código de Segurança deve conter somente dígitos; "+"\n";
        
            }
            //VALIDACAO DO NUMERO DO CARTÂO DE CREDITO
            for(int i=0;i<nr_credit_card.length();i++){
                    if(!Character.isDigit(nr_credit_card.charAt(i))){
                        ok=false; 
                        ok3=false;
                    }

            }
            if(ok3==false)
                     msg+="Número do cartão de crédito deve conter somente dígitos; "+"\n";

    
            if(ok==true && has_user==true && data_null==true){ //Se os dados estiverem validados corretamente, prossegue
                int month = Integer.parseInt(date.substring(0,2));
                int year = 0;
                if(date.length()==5)
                    year = Integer.parseInt(date.substring(3,5));
                else
                    year= Integer.parseInt(date.substring(5,7));
                
                //CONEXAO COM MUNDIPAGG
                MundiPaggClient client = new MundiPaggClient();
                CreateOrderRequest Request = new CreateOrderRequest();
                Request.setAmountInCents(debt_cents);
                //Cria um numero aleatorio
                Random generator = new Random();
                Integer randomNumber = generator.nextInt(1000);
                Request.setCurrencyIsoEnum(CurrencyIsoEnum.BRL);
                Request.setEmailUpdateToBuyerEnum(EmailUpdateToBuyerEnum.No);
                // Chave da Loja
                Request.setMerchantKey("bdc974fc-b056-421d-b278-5a3b4df1cfa9");
                /*Informações Comprador*/
                    Buyer buyer = new Buyer();
                    buyer.setName(name);
                    buyer.setTaxDocumentNumber(cpf);
                    
                //Criando uma cole??o de transa??es
                CreditCardTransaction[] creditCardTransactionCollection = new CreditCardTransaction[1];
                CreditCardTransaction creditCardTransaction = new CreditCardTransaction();
                creditCardTransaction.setAmountInCents(Request.getAmountInCents());
                creditCardTransaction.setCreditCardBrandEnum(CreditCardBrandEnum.fromString(flag_credit_card));
                creditCardTransaction.setCreditCardNumber(request.getParameter("nr_credit_card"));
                creditCardTransaction.setSecurityCode(request.getParameter("cod_seg_credit_card"));
                creditCardTransaction.setInstallmentCount(parcelas);
                creditCardTransaction.setHolderName(request.getParameter("name_credit_card"));
                creditCardTransaction.setExpMonth(month);
                creditCardTransaction.setExpYear(year);

                //PaymentMethodCode 1 para Teste
                creditCardTransaction.setPaymentMethodCode(1);
                creditCardTransactionCollection[0] = creditCardTransaction;
                Request.setCreditCardTransactionCollection(creditCardTransactionCollection);
                Request.setBuyer(buyer);

                Request.setOrderReference( randomNumber.toString());
                CreateOrderResponse Response =  client.createOrder(Request);

                
                try{
                        sucess = Response.getSuccess();    
                   }
                catch(Exception e){       
                   //Erro de conexão
                }
                
                if(sucess==true){ //Se a Cielo validou os dados enviados
                   
                    CreditCardTransactionResult[] CreditCardTransactionCollectionResult = new CreditCardTransactionResult[1];
                    CreditCardTransactionCollectionResult = Response.getCreditCardTransactionResultCollection();
                    transactionkey = CreditCardTransactionCollectionResult[0].getTransactionKey();
                    status= CreditCardTransactionCollectionResult[0].getCreditCardTransactionStatusEnum().toString();
                    
                    //Dependendo do Status, ind_sit varia e a mensagem tb
                    if(status.equals("Captured")){
                        msg_status = "Seu pagamento foi realizado! Dados do pagamento serão enviados para o e-mail informado abaixo. Você pode consultar o status de seu pagamento na aba de consultas pagamentos";
                        ind_sit=4;
                    }
                    else if(status.equals("NotAuthorized")){
                        msg_status = "Seu pagamento não foi autorizado pela operadora do cartão.";
                    }
                    else if(status.equals("AuthorizedPendingCaptured")){
                        msg_status = "Seu pagamento está pra ser aprovado pela operadora do cartão. Aguarde nosso e-mail de confirmação. Você pode consultar o status de seu pagamento na aba de consultas pagamentos";
                        ind_sit=3;
                    }
                    else if(status.equals("WithError")){
                        msg_status = "Houve o erro de conexão com a operadora do cartão durante o pagamento. Por favor, tentar novamente.";
                    }
                    
                   

                    //Somente se for capturado ou Pendente de Autorização que eu insiro no banco de dados    
                    if(status.equals("Captured")||status.equals("AuthorizedPendingCaptured"))
                    {
                        CreditCard004 cc = new CreditCard004(); //Dados do Credit Card

                        User_Helper user_helper_search_cpf = new User_Helper();

                        List <User002> user_list = new ArrayList();
                        user_list= user_helper_search_cpf.List_User_From_CPF(cpf,true); //Procuro as dividas do usuário pleo cpf
                        Long cod_instc_user_long = (user_list.get(0).getCodInstc002()); //Código de Instancia do usuario para setar na tarnsação
                        cc.setCodInstcUser004(cod_instc_user_long); //No cartão de crédito já seto esse valor
                        cc.setCodInstcClint004(user_list.get(0).getCodInstcClint002()); //seto o cliente
                        cc.setIndSit004(ind_sit); //seto o ind_sit

                        //Inserção dos valores de resposta da própria mundipágg
                        String TransactionIdentifier = CreditCardTransactionCollectionResult[0].getTransactionIdentifier();
                        String AmountInCents = Long.toString(CreditCardTransactionCollectionResult[0].getAmountInCents());
                        String TransactionReference = CreditCardTransactionCollectionResult[0].getTransactionReference();
                        
                        cc.setAmountInCents004(AmountInCents);
                        cc.setCreditCardBrand004(flag_credit_card);      
                        cc.setTransactionReference004(TransactionReference);
                        cc.setTransactionKey004(transactionkey);
                        cc.setTransactionIdentifier004(TransactionIdentifier);
                        cc.setCreditCardTransactionStatus004(status);

                        //ADICAO NO BD
                        User_Helper add_cc = new User_Helper();
                        add_cc.AddCreditCard(cc);
                        
                        //O USUARIO SERÁ SETADO COM O IND_SIT TAMBÈM EM TODAS AS LINHAS DE DÍVIDA
                        for(int i=0;i<user_list.size();i++){
                            User_Helper update_user = new User_Helper();
                            user_list.get(i).setIndSit002(ind_sit);
                            update_user.Update_User(user_list.get(i));                 
                        }%>
                        
                        
                        
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
                                            <h1>Confirmação</h1>
                                        </div><!-- /breadcrumb-title -->

                                    </div><!-- /breadcrumb-head -->


                                    <!-- breadcrumb -->
                                    <ol class="breadcrumb">
                                        <li><a href="index.jsp" title="Home">Home</a></li>
                                        <li><a href="pesquisar_pendencias.jsp" title="Shop">pesquisa de pendencias</a></li>
                                        <li class="active">Confirmação</li>
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
                                                <h4 style="text-align: center"><%=msg_status%></h4>
                                                <h2 style="text-align: center"><%=transactionkey%></h2>
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
                                                    <input type="text" class="form-control" placeholder="Digite o email para envio das informações de pagamento" name="email_conf1" id="email_conf1" onblur="validacaoEmail()">
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
                                                <button type="submit" class="btn btn-nesto" onclick="sendMail2('<%=user_list.get(0).getName002()%>','<%=cliente%>','<%=df.format(total)%>','Cartão de crédito','<%=transactionkey%>','<%=user_list.get(0).getCpf002()%>');">Enviar email de Confirmação</button>
                                            </div><!-- /col-md-12 -->
                                    
                                    
                                    </div> <!--row-->



                                            
                                    </div><!-- /col-md-9 main-content -->

                                </div><!-- /row -->
                            </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

</div><!-- /light-section -->

            <%}//fim do if capturadp/pendente
                }//fim do if sucess=true
                    }// fim do if ok = true
                if((sucess==false || ok==false)&& has_user==true && data_null==true){
                    
                          
                           //Essas variáveis devem ser setadas para serem pegas na próxima página     
                           request.getSession().setAttribute("name", name);
                           request.getSession().setAttribute("cpf", cpf);
                           request.getSession().setAttribute("cliente", cliente);
                           request.getSession().setAttribute("debt_total", debt_total_aux);
                           request.getSession().setAttribute("debt_total_atualizado", debt_total_atualizado);
                           request.getSession().setAttribute("total", total_aux);

                            msg_status ="Transação não autorizada. Entre em contato com a operadora do seu cartão de crédito ou tente novamente.";
                            
                            if(ok==false)
                                msg_status = msg;   
                            if(status.equals("NotAuthorized")){
                                msg_status = "Seu pagamento não foi autorizado pela operadora do cartão.";
                            }
                            else if(status.equals("AuthorizedPendingCaptured")){
                               msg_status = "Seu pagamento está pra ser aprovado pela operadora do cartão. Aguarde nosso e-mail de confirmação. Você pode consultar o status de seu pagamento na aba de consultas pagamentos";

                            }
                            else if(status.equals("WithError")){
                               msg_status = "Houve o erro de conexão com a operadora do cartão durante o pagamento. Por favor, tentar novamente.";
                           }
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
                                            <h1>Confirmação</h1>
                                        </div><!-- /breadcrumb-title -->

                                    </div><!-- /breadcrumb-head -->


                                    <!-- breadcrumb -->
                                    <ol class="breadcrumb">
                                        <li><a href="index.jsp" title="Home">Home</a></li>
                                        <li><a href="pesquisar_pendencias.jsp" title="Shop">pesquisa de pendencias</a></li>
                                        <li class="active">Confirmação</li>
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
                                                <h4 style="text-align: center"><%=msg_status%></h4>
                           
                                            </div><!-- /small-section-title -->

                                        </div><!-- /col-md-12 -->
                                    </div><!-- /row --> 




                                </div><!-- /col-md-9 main-content -->

                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->

<div class="light-section">

                <!-- main-section -->
                <div class="main-section">
                    <!-- section-container -->
                    <div class="section-container">


                        <!-- container -->
                        <div class="container">
                            <!-- row -->
                            <div class="row">

                                <div class="col-md-3 sidebar">


                                    <!-- widget -->
                                    <div class="widget">


                                        <!-- widget-title -->
                                        <div class="widget-title">
                                            <h4>Informações</h4>
                                        </div><!-- /widget-title -->


                                        <!-- widget-navigation -->
                                        <div class="widget-navigation">

                                            <nav>
                                                <ul>
                                                    <li style="padding: 10px 0; font-size: 16px"><strong>Nome: </strong> <%=name%></li>
                                                    <li style="padding: 10px 0; font-size: 16px"><strong>CPF: </strong> <%=cpf%></li>
                                                    <li style="padding: 10px 0; font-size: 16px"><strong>Empresa: </strong> <%=cliente%></li>
                                                </ul>
                                            </nav>

                                        </div><!-- /widget-navigation -->


                                    </div><!-- /widget -->
                                </div><!-- /col-md-3 sidebar -->

                                <!-- col-md-9 main-content -->
                                <div class="col-md-9 main-content">



                                    <!-- row -->
                                    <div class="row">
                                        <!-- col-md-12 -->
                                        <div class="col-md-12">

                                            <!-- small-section-title -->
                                            <div class="small-section-title">
                                                <h4>Pagar com cartão de crédito</h4>
                                            </div><!-- /small-section-title -->

                                        </div><!-- /col-md-12 -->
                                    </div><!-- /row -->


                                    <!-- row -->
                                    <div class="row">
                                        <!-- billing-form -->
                                        <form role="form" action="pagamento_credit_card.jsp" class="billing-form">

                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- First Name -->
                                                <div class="form-group">
                                                    <input type="text" readonly="" class="form-control" placeholder="Nome: <%=name%>" name="">
                                                </div><!-- /First Name -->
                                            </div><!-- /col-md-6 -->


                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" readonly="" class="form-control" placeholder="Total: <%=df.format(Double.parseDouble(total_aux))%>" name="">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->


                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                <!-- Company Name -->
                                                <div class="form-group">
                                                    <label>Escolha o Parcelamento</label><br>
                                                    <select class="select-input" style="border: 1px solid #ccc; padding: 10px 0; border-radius: 5px" name="parcela_credit_card" id="parcela_credit_card">
                                                           <%
                                                        for(int i=1;i<=12;i++)
                                                        {
                                                            
                                                            if(i<=3){
                                                                if(Double.parseDouble(total_aux)*1/i>=150 ||i==1)
                                                                {%>
                                                                    <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(total_aux)*1/i)%></option>
                                                                <%}
                                                            }
                                                            if(i>=4){
                                                                if(Double.parseDouble(total_aux)*1/i>=150)
                                                                {%>
                                                                    <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(total_aux)*1/i)%></option>
                                                                <%}
                                                            }
                                                              
                                                            
                                                        }%>
                                                    </select>
                                                </div><!-- /Company Name -->
                                            </div><!-- /col-md-12 -->
                                            
                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                <!-- Company Name -->
                                                <div class="form-group">
                                                    <label>Bandeira do Cartão</label><br>
                                                    <select class="select-input" style="border: 1px solid #ccc; padding: 10px 0; border-radius: 5px" name="flag_credit_card" id="flag_credit_card">
                                                        <option value="Visa">Visa</option>
							  <option value="Mastercard">MasterCard</option>
                                                          <option value="Hipercard">Hipercard</option>
							  <option value="Amex">Amex</option>
                                                          <option value="Diners">Diners</option>
							  <option value="Elo">Elo</option>
                                                          <option value="Aura">Aura</option>
							  <option value="Mastercard">MasterCard</option>
                                                          <option value="Discover">Discover</option>
							  <option value="CasaShow">CasaShow</option>
                                                           <option value="Havan">Havan</option>
                                                    </select>
                                                </div><!-- /Company Name -->
                                            </div><!-- /col-md-12 -->

                                            
                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Nome no Cartão" name="name_credit_card" id="name_credit_card">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->
                                            
                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Número do Cartão" name="nr_credit_card" id="nr_credit_card" onkeypress="return Onlynumbers(event)">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->
                                                
                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Data de Validade (MM/AA)" name="date_valid" id="date_valid" onkeypress="return Onlynumbers(event)">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->
                                                
                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Código de Segurança" name="cod_seg_credit_card" id="cod_seg_credit_card" onkeypress="return Onlynumbers(event)">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->
                                                
                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                <button type="submit" class="btn btn-nesto">Realizar Pagamento</button>
                                            </div><!-- /col-md-12 -->


                                        </form><!-- /billing-form -->
                                    </div><!-- /row -->


                                </div><!-- /col-md-9 main-content -->

                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->


                                    
           
<%}
%>
     </body>
     
    <tr><td><%@include file='footer.jsp'%></td></tr>
</html>
