<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="spwork.User_Helper"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="spwork.Client001"%>
<%@page import="spwork.User002"%>
<!DOCTYPE html>
<html lang="en">
<head>
        
        <tr><td><%@include file='header_pages.jsp'%></td></tr>
        <script type="text/javascript" src="js/getQueryParam.js"></script>
        <script>
            var id = getQueryParam("id");
            mixpanel.identify(id);
            mixpanel.track('Page View',{'Page name':'processar_cpf'});
        </script>
</head>
    <body>
            
            <div class="breadcrumb-section breadcrumb-style-3" style="background-image: url('images/breadcrumb/shop-breadcrumb-bg.jpg');">
               
                <div class="main-section">
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
                                            <h1>Consta Pendência de Pagamento</h1>
                                        </div>
                                    </div>
                                    <ol class="breadcrumb">
                                        <li><a href="index.jsp" title="Home">Home</a></li>
                                        <li><a href="pesquisar_pendencias.jsp" title="Pesquisar Pendências">Pesquisar Pendências</a></li>
                                        <li class="active">Resumo</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             <%
                    double divida_total=0;
                    Calendar now = Calendar.getInstance();
                    double divida_aux = 0;
                    double multa = 0; // multa em cima do principal
                    double total = 0; // principal com juros e multa
                    int year = now.get(Calendar.YEAR);
                    int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
                    int diff_year=0;
                    int diff_month=0;
                    int temp_years=0,temp_months=0,temp_total=0;
                    int tempo1,tempo2;
                    
                    String cpf = request.getParameter("cpf"); //valor inserido na página anterior
                    DecimalFormat df = new DecimalFormat("0.00"); //formatação de duas casas decimais
                   
            
                    List <User002> user_list = new ArrayList(); //lista que pegará todas as linhas de dívidas do banco de dados de um certo usuário
                    User002 user = new User002(); //usuário
                    Client001 client = new Client001(); //cliente
                     
                    
                    User_Helper user_helper_test_cpf= new User_Helper(); //Verificará se existe esse cpf no banco de dados
                    
                    
                    if(user_helper_test_cpf.Test_User_From_CPF(cpf,true)==true) //se existir
                    {      
                    
                        User_Helper user_helper_search_user= new User_Helper(); //buscará todas as linhas do usuário;
                        user_list = user_helper_search_user.List_User_From_CPF(cpf,true); //lista todas as linhas com o mesmo cpf;
                        user=user_list.get(0); //pega as insformações de uma linha. Todas essas linhas são de uma mesma pessoa --com um mesmo cpf;
                        User_Helper user_helper_search_client= new User_Helper(); //buscará o cliente relacionado com o usuário;  
                        client = user_helper_search_client.Search_Client_From_Cod_Client(user.getCodInstcClint002()); //Preciso de informações do Cliente;
                        
                        String name = user.getName002();
                        String cliente = client.getDescAbvd001();
                    
			 request.getSession().setAttribute("name", name);
                         request.getSession().setAttribute("cpf", cpf);
                         request.getSession().setAttribute("cliente", cliente);
                %>
                
                <div class="light-section">

                <div class="main-section">
                    <!-- section-container -->
                    <div class="section-container">


                        <!-- container -->
                        <div class="container">
                            <!-- row -->
                            <div class="row">
 <!-- col-md-3 sidebar -->
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
                                                    <li style="padding: 10px 0; font-size: 16px" name="name" id="name" value="<%=name%>"><strong>Nome: </strong> <%=name%></li>
                                                    <li style="padding: 10px 0; font-size: 16px" name="cpf" id="cpf" value="<%=cpf%>"><strong>CPF: </strong> <%=cpf%></li>
                                                    <li style="padding: 10px 0; font-size: 16px" name="cliente" id="cliente" value="<%=cliente%>"><strong>Empresa: </strong> <%=cliente%></li>
                                                </ul>
                                            </nav>

                                        </div><!-- /widget-navigation -->


                                    </div><!-- /widget -->
                                </div><!-- /col-md-3 sidebar -->

                                  <form  action="realizar_pagamento.jsp">

                                            <!-- col-md-9 main-content -->
                                            <div class="col-md-9 main-content">
                                                <!-- row -->
                                                <div class="row">
                                                    <!-- col-md-12 -->
                                                    <div class="col-md-12">

                                                        <!-- info-box cart -->
                                                        <div class="info-box cart">

                                                            <!-- panel panel-nesto -->
                                                            <div class="panel panel-nesto">

                                                                <!-- panel-heading -->
                                                                <div class="panel-heading">
                                                                    Detalhes
                                                                </div>

                                                                <!-- table-responsive -->
                                                                <div class="table-responsive">
                                                                    <!-- table table-hover -->
                                                                    <table class="table table-hover">

                                                                        <tr>
                                                                            <th>Data</th>
                                                                            <th>Especificação</th>
                                                                            <th>Valor</th>
                                                                            <th>Valor Atualizado</th>
                                                                            <th>Multa</th>
                                                                            <th>Total</th>

                                                                        </tr>
                                                                         <%
                                                                                for(int i=0;i<user_list.size();i++){
                                                                                    tempo1 = month+year*12;
                                                                                    tempo2 = Integer.parseInt(user_list.get(i).getMes002())+Integer.parseInt(user_list.get(i).getAno002())*12;
                                                                                  
                                                                                    temp_months=tempo1-tempo2;
                                                                                            
                                                                                    multa+=user_list.get(i).getDebt002() * 0.01;
                                                                                    divida_aux+=user_list.get(i).getDebt002()*(1+0.02*temp_months);
                                                                                    divida_total+=user_list.get(i).getDebt002();
                                                                                    total+=user_list.get(i).getDebt002() * 0.01 + user_list.get(i).getDebt002()*(1+0.02*temp_months);
                                                                                
                                                                        %>
                                                                        <tr>
                                                                            <td><%=user_list.get(i).getMes002()+"/"+user_list.get(i).getAno002()%></td>
                                                                            <td><%=user_list.get(i).getSubProd002()%></td>
                                                                            <td><%=user_list.get(i).getDebt002().toString()%></td>
                                                                            <td><%=df.format(user_list.get(i).getDebt002()*(1+0.02*temp_months))%></td>
                                                                            <td><%=df.format(user_list.get(i).getDebt002()*0.01)%></td:>
                                                                            <td><%=df.format(user_list.get(i).getDebt002()*(1+0.02*temp_months)+user_list.get(i).getDebt002()*0.01)%></td:>
                                                                        </tr>
                                                                        <%}
                                                                                
                                                                        %>
                                                                        <tr>
                                                                            <td>Total :</td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td name="debt_total" id="debt_total" value="<%=df.format(divida_aux).replaceAll(",",".")%>"><%=df.format(divida_aux).replaceAll(",",".")%></td>
                                                                            <td name="multa_total" id="multa_total" value="<%=df.format(multa).replaceAll(",",".")%>"><%=df.format(multa).replaceAll(",",".")%></td>
                                                                            <td name="total" id="total" value="<%=df.format(multa).replaceAll(",",".")%>"><%=df.format(total).replaceAll(",",".")%></td>
                                                                            <%request.getSession().setAttribute("debt_total", divida_total);%>
                                                                            <%request.getSession().setAttribute("debt_total_atualizado",divida_aux);%>
                                                                            <%request.getSession().setAttribute("multa", multa);%>
                                                                            <%request.getSession().setAttribute("total", total);%>
                                                                        </tr>
                                                                    </table><!-- /table table-hover -->
                                                                </div>
                                                                    <div class="clearfix"></div>
                                                                    <div class="table-responsive">
                                                                    <!-- table table-hover -->
                                                                    <table class="table table-hover">
                                                                        <tr>
                                                                            <td>
                                                                                <%
                                                                                    boolean pode_pagar_2_cartao=false,pode_pagar_2_boleto=false,pode_pagar_1_boleto=false;
                                                                                    int i_max1_cartao=1,i_max2_cartao=0,i_max1_boleto=0,i_max2_boleto=0;
                                                                                    for(int i=1;i<=12;i++)
                                                                                    {
                                                                                        if(i<=3){
                                                                                        if(divida_total*1.0/i>=150 ||i==1)
                                                                                        {
                                                                                            i_max1_cartao=i;
                                                                                            
                                                                                        }
                                                                                    }
                                                                                    if(i>=4 && i<=6){
                                                                                        if(divida_total*1.0/i>=150)
                                                                                        {
                                                                                             i_max2_cartao=i;
                                                                                             pode_pagar_2_cartao=true;
                                                                                        }
                                                                                    }

                                                                                    }
                                                                                    for(int i=1;i<=12;i++)
                                                                                    {


                                                                                        if(i>=12 && i<=6){ //boleto só à vista
                                                                                            if(divida_total*1.0/i>=100)
                                                                                            {
                                                                                                  i_max1_boleto=i;
                                                                                                  pode_pagar_1_boleto=true;                                                      
                                                                                            }
                                                                                        }
                                                                                       
                                                                                        }


                                                                                    
                                                                                %>
                                                                                
                                                                               
                                                                                    
                                                                            </td>
                                                                            <td colspan="3">
                                                                                <h4>Forma de Pagamento:</h4>
                                                                                <input type="radio" name="radios" id="radios" value="1">&nbsp;Cartão de Crédito<br>
                                                                               
                                                                                <input type="radio" name="radios" id="radios" value="2">&nbsp;Boleto Bancário<br>
                                                                            </td>
                                                                            <td colspan="6">
                                                                                
                                                                                <!-- Submit Button --> 
                                                                                <div class="form-group">
                                                                                    <button type="submit" id="nesto-submit" class="btn btn-nesto">
                                                                                        Prosseguir com o Pagamento
                                                                                    </button>
                                                                                </div><!-- /Submit Button -->
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div><!-- /table-responsive -->


                                                            </div><!-- /panel panel-nesto -->

                                                        </div><!-- /info-box cart -->

                                                    </div><!-- /col-md-12 -->
                                                </div><!-- /row -->
                                            </div><!-- /col-md-9 main-content -->
                                  </form>



                               



                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->
            <%}
                    else{
                    %>
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
                                                <h4 style="text-align: center">Não consta pendência referente ao cpf <%=cpf%>.</h4>
                                                
                                            </div><!-- /small-section-title -->

                                        </div><!-- /col-md-12 -->
                                    </div><!-- /row --> 
                                                                       



                                            
                                    </div><!-- /col-md-9 main-content -->

                                </div><!-- /row -->
                            </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

</div><!-- /light-section -->

                    <%};
            %>


            <tr><td><%@include file='footer.jsp'%></td></tr>
           </html>
