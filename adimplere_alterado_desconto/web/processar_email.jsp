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
        <script>
            mixpanel.track('Page View',{'Page name':'processar_email'});
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
                    String email = request.getParameter("email");
            
                    List <User002> user_list = new ArrayList();
                    User002 user = new User002();
                    Client001 client = new Client001();
                    DecimalFormat df = new DecimalFormat("0.00");
                    
                    User_Helper user_helper_test_email= new User_Helper(); //Verificará se existe esse email no banco de dados
                    
             
                    if(user_helper_test_email.Test_User_From_Email(email,true)==true) //se existir
                    {      
                
                        User_Helper user_helper_search_user= new User_Helper();
                        user_list = user_helper_search_user.List_User_From_Email(email,true); //lista todas as linhas com o mesmo email
                        user=user_list.get(0); //pega as insformações da primeira
                        User_Helper user_helper_search_client= new User_Helper(); //buscará o cliente relacionado com o usuário  
                        client = user_helper_search_client.Search_Client_From_Cod_Client(user.getCodInstcClint002());

                    
			 request.getSession().setAttribute("name", user.getName002());
                         request.getSession().setAttribute("cpf", user.getCpf002());
                         request.getSession().setAttribute("cliente", client.getDescAbvd001());
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
                                                    <li style="padding: 10px 0; font-size: 16px" name="name" id="name" value="<%=user.getName002()%>"><strong>Nome: </strong> <%=user.getName002()%></li>
                                                    <li style="padding: 10px 0; font-size: 16px" name="email" id="email" value="<%=user.getCpf002()%>"><strong>CPF: </strong> <%=user.getCpf002()%></li>
                                                    <li style="padding: 10px 0; font-size: 16px" name="cliente" id="cliente" value="<%=client.getDescAbvd001()%>"><strong>Empresa: </strong> <%=client.getDescAbvd001()%></li>
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

                                                                        </tr>
                                                                         <%
                                                                                for(int i=0;i<user_list.size();i++){
                                                                                 divida_total+=user_list.get(i).getDebt002();
                                                                        %>
                                                                        <tr>
                                                                            <td><%=user_list.get(i).getMes002()+"/"+user_list.get(i).getAno002()%></td>
                                                                            <td><%=user_list.get(i).getSubProd002()%></td>
                                                                            <td><%=user_list.get(i).getDebt002().toString()%></td>
                                                                        </tr>
                                                                        <%}%>
                                                                        <tr>
                                                                            <td>Total :</td>
                                                                            <td name="debt_total" id="debt_total" value="<%=df.format(divida_total).replaceAll(",",".")%>"><%=df.format(divida_total).replaceAll(",",".")%></td>
                                                                            <%request.getSession().setAttribute("debt_total", divida_total);%>
                                                                        </tr>
                                                                    </table><!-- /table table-hover -->
                                                                </div>
                                                                    <div class="clearfix"></div>
                                                                    <div class="table-responsive">
                                                                    <!-- table table-hover -->
                                                                    <table class="table table-hover">
                                                                        <tr>
                                                                            <td>
                                                                                <p>No cartão de crédito, você tem 50% de desconto em até 3x (3x de R$<%=df.format(divida_total*0.5/3) %>). E 30% de desconto se pagar em até 12x (12x de R$<%=df.format(divida_total*0.7/12)%>) </p>
                                                                                <p>No boleto, você tem 50% de desconto se for a vista. Se for em até 6x, 25% de desconto (R$<%=df.format(divida_total*0.75/6)%>)). E 15% de desconto se pagar em até 12x (R$<%=df.format(divida_total*0.85/12)%>)) </p>
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
            <%}%>


            <tr><td><%@include file='footer.jsp'%></td></tr>
           </html>
