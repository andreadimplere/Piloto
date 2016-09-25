<%-- 
    Document   : realizar_pagamento.jsp
    Created on : 25/11/2015, 00:50:48
    Author     : vinic
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="spwork.User_Helper"%>
<%@page import="spwork.Client001"%>
<%@page import="spwork.User002"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

   
    <head>
            <tr><td><%@include file='header_pages.jsp'%></td></tr>
    </head>
    <body>
        <%
            DecimalFormat df = new DecimalFormat("0.00");  //formatação
            boolean user_exist = false;
            
            //Pegar todas as variáveis do processa_cpf
            String cpf = request.getSession().getAttribute("cpf").toString();
            String cliente = request.getSession().getAttribute("cliente").toString();
            String debt_total =request.getSession().getAttribute("debt_total").toString();
            String debt_total_atualizado =request.getSession().getAttribute("debt_total_atualizado").toString();
            String name = request.getSession().getAttribute("name").toString();
            String total =request.getSession().getAttribute("total").toString();
            
            User002 user = new User002(); //usuário
            
            User_Helper user_helper_test_cpf = new User_Helper();
            user_exist = user_helper_test_cpf.Test_User_From_CPF(cpf,true);
            if(user_exist==true){



                List <User002> user_list= new ArrayList();  //listar todas as linhas                  
                Client001 client = new Client001(); //cliente
                User_Helper user_helper_search_user= new User_Helper(); //procurar usuário
                user_list = user_helper_search_user.List_User_From_CPF(cpf,true); //procura pelo cpf
                User_Helper user_helper_search_client= new User_Helper();   //procurar cliente
                client = user_helper_search_client.Search_Client_From_Cod_Client(user_list.get(0).getCodInstcClint002()); //procura pelo codigo do cliente
                user=user_list.get(0); //pega uma linha


                //seta novamente as variáveis para a próxima página
                request.getSession().setAttribute("name", name);
                request.getSession().setAttribute("cpf", cpf);
                request.getSession().setAttribute("cliente", cliente);
                request.getSession().setAttribute("debt_total", debt_total);
                request.getSession().setAttribute("debt_total_atualizado", debt_total_atualizado);

             //se for cartão de crédito
              if(request.getParameter("radios").equals("1")){%>
                  <script>
                    mixpanel.identify('<%=user_list.get(0).getCpf002()%>');  
                    mixpanel.track('Page View',{'Page name':'realizar_pagamento_credit_card'});
                  </script>
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
                                            <h1>checkout</h1>
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

                                    <form action="pagamento_credit_card.jsp" class="billing-form">
                                    <!-- row -->
                                    <div class="row">
                                        <!-- billing-form -->
                                        

                                                <!-- col-md-6 -->
                                                <div class="col-md-6">
                                                    <!-- First Name -->
                                                    <div class="form-group">
                                                        <input type="text" readonly="" class="form-control" placeholder="Nome: <%=name%>" name="name" id="name" readonly >
                                                    </div><!-- /First Name -->
                                                </div><!-- /col-md-6 -->


                                            <!-- col-md-6 -->
                                            <div class="col-md-6">
                                                <!-- Last Name -->
                                                <div class="form-group">
                                                    <input type="text" readonly="" class="form-control" placeholder="Total: R$ <%=df.format(Double.parseDouble(total))%> (com juros)" name="debt_total" id="debt_total" readonly>
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->


                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                <!-- Company Name -->
                                                <div class="form-group">
                                                    <label>Quitação:</label><br>
                                                    <select class="select-input" id="parcela_credit_card" name="parcela_credit_card" style="border: 1px solid #ccc; padding: 10px 0; border-radius: 5px">
                                                        <%
                                                        for(int i=1;i<=12;i++)
                                                        {
                                                            
                                                            if(i<=3){
                                                                if(Double.parseDouble(total)*1.0/i>=150 ||i==1)
                                                                {%>
                                                                    <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(total)*1/i)%></option>
                                                                <%}
                                                            }
                                                            if(i>=4){
                                                                if(Double.parseDouble(total)*1/i>=150)
                                                                {%>
                                                                    <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(debt_total)*0.7/i)%></option>
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
                                                    <select class="select-input" style="border: 1px solid #ccc; padding: 10px 0; border-radius: 5px" id="flag_credit_card" name="flag_credit_card">
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
                                                    <input type="text" class="form-control" placeholder="Número do Cartão" name="nr_credit_card" id="nr_credit_card" onkeypress="return Onlynumbers(event)" >
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


                                        
                                    </div><!-- /row -->
                                    


                                </div><!-- /col-md-9 main-content -->

                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->
            
            </form><!-- /billing-form -->


           



              <%}else{%>
                    <script>
                    mixpanel.identify('<%=user_list.get(0).getCpf002()%>');  
                    mixpanel.track('Page View',{'Page name':'realizar_pagamento_boleto'});
                  </script>
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
                                            <h1>checkout</h1>
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
                                                <h4>Pagar com boleto</h4>
                                            </div><!-- /small-section-title -->

                                        </div><!-- /col-md-12 -->
                                    </div><!-- /row -->


                                    <!-- row -->
                                    <div class="row">
                                        <!-- billing-form -->
                                        <form role="form" action="pagamento_boleto.jsp" class="billing-form">

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
                                                    <input type="text" readonly="" class="form-control" placeholder="Total: R$ <%=df.format(Double.parseDouble(total))%> (com juros)" name="">
                                                </div><!-- /Last Name -->
                                            </div><!-- /col-md-6 -->


                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                <!-- Company Name -->
                                                <div class="form-group">
                                                    <label>Quitação:</label><br>
                                                    <select class="select-input" style="border: 1px solid #ccc; padding: 10px 0; border-radius: 5px" id="parcela_boleto" name="parcela_boleto">
                                                        <%
                                                        for(int i=1;i<=1;i++) //boleto só à vista
                                                        {
                                                            if(i==1){%>
                                                                <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(total)*1/i)%></option>
                                                            <%}
                                                            
                                                            if(i>=2 && i<=6){
                                                                if(Double.parseDouble(total)*1/i>=100)
                                                                {%>
                                                                    <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(total)*1/i)%></option>
                                                                <%}
                                                            }
                                                            if(i>=7){
                                                                if(Double.parseDouble(total)*1/i>=100)
                                                                {%>
                                                                    <option value="<%=i%>"><%=i%>x de R$<%=df.format(Double.parseDouble(total)*0.85/i)%></option>
                                                                <%}
                                                            }
                                                              
                                                            
                                                        }%>
                                                     </select>
                                                </div><!-- /Company Name -->
                                            </div><!-- /col-md-12 -->
                                            <%--
                                            <br><br>
                                            <div class="col-md-12">
                                                <br>
                                                <input type="checkbox" name="term_agreement" id="term_agreement" value="1" required>Concordo com os <a href="contrato.jsp?cpf=<%=cpf%>&name=<%=name%>&debt_total_atualizado=<%=debt_total_atualizado%>" target="_blank">termos de quitação.</a>
                                                
                                                
                                                
                                            </div><!-- /col-md-12 -->--%>
                                            <!-- col-md-12 -->
                                            <div class="col-md-12">
                                                
                                                <button type="submit" class="btn btn-nesto">Gerar Boleto</button>
                                            </div><!-- /col-md-12 -->


                                        </form><!-- /billing-form -->
                                    </div><!-- /row -->


                                </div><!-- /col-md-9 main-content -->

                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->

          <%}}
          %>
            
            
    </body>
    <tr><td><%@include file='footer.jsp'%></td></tr>

