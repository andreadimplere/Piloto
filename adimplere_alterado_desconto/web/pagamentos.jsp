<%@page import="java.util.List"%>
<%@page import="spwork.CreditCard004"%>
<%@page import="java.util.ArrayList"%>
<%@page import="spwork.User002"%>
<%@page import="spwork.Client001"%>
<%@page import="spwork.User_Helper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <tr><td><%@include file='header_pages.jsp'%></td></tr>
        <script>
            mixpanel.track('Page View',{'Page name':'pagamentos'});
        </script>
    </head>
    
    
    <%
        
        String transaction_key =request.getParameter("transaction_key");
          
            Long cod_instc_user;
            
            boolean has_transaction = false;
            CreditCard004 cc = new CreditCard004();
            List <User002> user_list =  new ArrayList ();
            User002 user = new User002();
            Client001 client = new Client001();
            if(transaction_key.length()>0 ){
                
                    
                User_Helper user_helper_test_transaction = new User_Helper(); 
                        
                has_transaction = user_helper_test_transaction.Test_Credit_Card_Transaction(transaction_key);
                if(has_transaction==true){

                     User_Helper user_helper_search_transaction = new User_Helper();
                     cc = user_helper_search_transaction.Search_Credit_Card_Transaction(transaction_key);
                     User_Helper user_helper_search_user = new User_Helper();
                     user_list=user_helper_search_user.Search_User_From_Cod_User(cc.getCodInstcUser004().toString());
                     User_Helper user_helper_search_client = new User_Helper();
                     client=user_helper_search_client.Search_Client_From_Cod_Client(cc.getCodInstcClint004());
                     //user_list.add(user);

                     
                    

                }
            }
            
             
             
            

             if(has_transaction==true)
             {      
                
                
        %>
    
    
    
    
    
    
    
    
    %>
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
                                            <h1>Consulta de Pagamentos Efetuados</h1>
                                        </div>
                                    </div>
                                    <ol class="breadcrumb">
                                        <li><a href="index.jsp" title="Home">Home</a></li>
                                        <li><a href="pesquisar-pendencias.html" title="Pesquisar Pendências">Pesquisar Pendências</a></li>
                                        <li class="active">Consulta de Pagamentos Efetuados</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
                                                    <li style="padding: 10px 0; font-size: 16px"><strong>Nome: </strong> <%=user_list.get(0).getName002()%></li>
                                                    <li style="padding: 10px 0; font-size: 16px"><strong>CPF: </strong> <%=user_list.get(0).getCpf002()%></li>
                                                    <li style="padding: 10px 0; font-size: 16px"><strong>Empresa: </strong><%=client.getDescAbvd001()%></li>
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

                                            <!-- info-box cart -->
                                            <div class="info-box cart">

                                                <!-- panel panel-nesto -->
                                                <div class="panel panel-nesto">

                                                    <!-- table-responsive -->
                                                    <div class="table-responsive">
                                                        <!-- table table-hover -->
                                                        <table class="table table-hover">

                                                            <tr>
                                                 
                                                                <th>Valor do Pagamento</th>
                                                                <th>Forma de Pagamento</th>
                                                                <th>Código da Transação</th>
                                                                
                                                            </tr>

                                                            <tr>
                                                               
                                                                <td><%=Double.parseDouble(cc.getAmountInCents004())/100%></td>
                                                                <td>Cartão de Crédito</td>
                                                                <td><%=cc.getCreditCardTransactionStatus004()%></td>
                                                            </tr>
                                                            
                                                            
                                                        </table><!-- /table table-hover -->
                                                    </div>
                                                    

                                                </div><!-- /panel panel-nesto -->

                                            </div><!-- /info-box cart -->

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
                                                <h4 style="text-align: center">Não constam pagamentos referentes à esse código.</h4>
                                                
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

    <body>
                
                <tr><td><%@include file='footer.jsp'%></td></tr>
                
    </body>
</html>
