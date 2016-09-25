<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <tr><td><%@include file='header_pages.jsp'%></td></tr>
        <script>
            mixpanel.track('Page View',{'Page name':'consulta_pagamentos'});
        </script>
    </head>
    
    <div class="breadcrumb-section breadcrumb-style-3" style="background-image: url('images/breadcrumb/contact-breadcrumb-bg.jpg');">

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
                                            <h1>Consulta de Pagamentos Efetuados</h1>
                                        </div><!-- /breadcrumb-title -->

                                    </div><!-- /breadcrumb-head -->


                                    <!-- breadcrumb -->
                                    <ol class="breadcrumb">
                                        <li><a href="index.jsp" title="Home">Home</a></li>
                                        <li class="active">Consultar Pagamentos</li>
                                    </ol><!-- /breadcrumb -->


                                </div><!-- /col-md-12 -->


                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /breadcrumb-section -->




            <!-- =========================================
            Light Section
            ========================================== -->
            <!-- light-section -->
            <div class="light-section">

                <!-- main-section -->
                <div class="main-section">
                    <!-- section-container -->
                    <div class="section-container">


                        <!-- container -->
                        <div class="container">


                            <!-- row -->
                            <div class="row">
                                <!-- col-md-12 -->
                                
                            </div><!-- /row -->


                            <!-- row -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="row">
                                        <form role="form" class="contactform_no_validation" action="pagamentos.jsp">
                                            


                                            <!-- col-md-6 -->
                                            <div class="col-md-12">

                                                <!-- contact-email -->
                                                <div class="form-group">
                                                    <input type="text" class="form-control" placeholder="Consulta pelo Código de Pagamento" name="transaction_key" id="transaction_key">
                                                </div><!-- /contact-email -->

                                            </div><!-- /col-md-6 -->
                                            <!-- col-md-12 -->
                                            <div class="col-md-12">

                                                <br>
                                                <!-- Submit Button --> 
                                                <div class="form-group">
                                                    <button type="submit" id="nesto-submit" class="btn btn-nesto">
                                                        Enviar
                                                    </button>
                                                </div><!-- /Submit Button -->

                                            </div><!-- /col-md-12 -->


                                            <!-- col-md-12 -->
                                            <div class="col-md-12">

                                                <!-- form-message -->
                                                <div class="form-message"></div>

                                            </div><!-- /col-md-12 -->


                                        </form><!-- /form -->

                                    </div><!-- /row -->
                                </div><!-- /col-md-8 -->



                            </div><!-- /row -->


                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->
    
    
    
    <body>
                
                <tr><td><%@include file='footer.jsp'%></td></tr>
                
    </body>
</html>
