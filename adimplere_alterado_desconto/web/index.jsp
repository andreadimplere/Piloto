    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <tr><td><%@include file='header_index.jsp'%></td></tr>
        <script>
            mixpanel.track('Page View',{'Page name':'index'});
        </script>
    </head>
    <body>
        
        <div id="to-top">
            <a href="#" title="To Top"><i class="fa fa-angle-up"></i></a>
        </div>
        <div id="main-wrapper">
            
            <div id="slider-section" >
                <div class="tp-banner-container">
                    <div class="tp-banner" >
                        <ul>
                            <li data-transition="random" data-slotamount="7" data-masterspeed="1000" data-thumb="images/slider/general/001.jpg"  data-saveperformance="off"  data-title="Slide">

                                <!--Slide 1-->
                                <!-- Background Image -->
                                <img src="images/slider/general/001.jpg"
                                     alt="Slidebg1"
                                     data-bgfit="cover"
                                     data-bgrepeat="no-repeat"
                                     data-bgposition="center top" />

                                <!-- Layer 1 -->
                                <div class="tp-caption rs-parallaxlevel-7 sfl"
                                     data-x="right"
                                     data-y="bottom"
                                     data-hoffset="-260"
                                     data-voffset="30"
                                     data-speed="1000"
                                     data-start="1500"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    <img src="images/slider/general/001-1.png" alt="Image">
                                </div><!-- /Layer 1 -->

                                <!-- Layer 2 -->
                                <div class="tp-caption rs-parallaxlevel-5 sfr"
                                     data-x="right"
                                     data-y="bottom"
                                     data-hoffset="-15"
                                     data-voffset="30"
                                     data-speed="1000"
                                     data-start="2000"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    <img src="images/slider/general/001-2.png" alt="Image">
                                </div><!-- /Layer 2 -->

                                <!-- Layer 3 -->
                                <div class="tp-caption nesto-rs-title sft"
                                     data-x="left"
                                     data-y="center"
                                     data-hoffset="15"
                                     data-voffset="-70"
                                     data-speed="1000"
                                     data-start="2700"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    bem vindo à Adimplere
                                </div><!-- /Layer 3 -->

                                <!-- Layer 4 -->
                                <div class="tp-caption nesto-rs-sub-title randomrotate"
                                     data-x="left"
                                     data-y="center"
                                     data-hoffset="15"
                                     data-voffset="15"
                                     data-speed="1000"
                                     data-start="3400"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    Cobrança de inadimplentes
                                </div><!-- /Layer 4 -->

                                <!-- Layer 5 -->
                                <div class="tp-caption tp-resizeme nesto-rs-button sfb"
                                     data-x="left"
                                     data-y="center"
                                     data-hoffset="15"
                                     data-voffset="90"
                                     data-speed="1000"
                                     data-start="4100"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    <a href="#sobre" class="btn btn-nesto">Reinventada</a>
                                </div><!-- /Layer 5 -->

                            </li><!-- /Slide 1  -->

                                           
                            <!-- Slide 2  -->
                            <li data-transition="random" data-slotamount="7" data-masterspeed="1000" data-thumb="images/slider/general/003.jpg"  data-saveperformance="off"  data-title="Slide">

                                <!-- Background Image -->
                                <img src="images/slider/general/003.jpg"
                                     alt="Slidebg1"
                                     data-bgfit="cover"
                                     data-bgrepeat="no-repeat"
                                     data-bgposition="center top" />

                                <!-- Layer 1 -->
                                <!--
                                <div class="tp-caption rs-parallaxlevel-7 sfl"
                                     data-x="right"
                                     data-y="bottom"
                                     data-hoffset="-15"
                                     data-speed="1000"
                                     data-start="1500"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    <img src="images/slider/general/003-1.png" alt="Image">
                                
                                </div><!-- /Layer 1 -->
                                --!>

                                <!-- Layer 2 -->
                                <div class="tp-caption rs-parallaxlevel-5 sfr"
                                     data-x="right"
                                     data-y="bottom"
                                     data-hoffset="-250"
                                     data-speed="1000"
                                     data-start="2000"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    
                                </div><!-- /Layer 2 -->

                                <!-- Layer 3 -->
                                <div class="tp-caption nesto-rs-title sft"
                                     data-x="left"
                                     data-y="center"
                                     data-hoffset="15"
                                     data-voffset="-70"
                                     data-speed="1000"
                                     data-start="2700"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    Recuperação de créditos
                                </div><!-- /Layer 3 -->

                                <!-- Layer 4 -->
                                <div class="tp-caption nesto-rs-sub-title randomrotate"
                                     data-x="left"
                                     data-y="center"
                                     data-hoffset="15"
                                     data-voffset="15"
                                     data-speed="1000"
                                     data-start="3400"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    Consultoria - Reestruturação dos processos de cobrança
                                </div><!-- /Layer 4 -->

                                <!-- Layer 5 -->
                                <div class="tp-caption tp-resizeme nesto-rs-button sfb"
                                     data-x="left"
                                     data-y="center"
                                     data-hoffset="15"
                                     data-voffset="90"
                                     data-speed="1000"
                                     data-start="4100"
                                     data-endspeed="1000"
                                     data-easing="Back.easeOut"
                                     data-endeasing="Linear">
                                    <a href="#" class="btn btn-nesto">Prevenção da inadimplência</a>
                                </div><!-- /Layer 5 -->

                            </li><!-- /Slide 2  -->


                        </ul>


                        <div class="tp-bannertimer"></div>

                    </div><!-- /tp-banner -->
                </div><!-- /tp-banner-container -->


            </div><!-- /slider-section -->


            <div class="light-section" id="sobre">

                <!-- main-section -->
                <div class="main-section">
                    <!-- section-container -->
                    <div class="section-container">


                        <!-- container -->
                        <div class="container">
                            <!-- row -->
                            <div class="row">


                                <!-- col-md-6 -->
                                <div class="col-md-6">


                                    <!-- feature-block -->
                                    <div class="feature-block">
                                        <!-- owl-slider-wrapper -->
                                        <div class="owl-slider-wrapper">
                                            <!-- owl-slider -->
                                            <ul class="owl-slider">
                                                <li>
                                                    <img src="images/about/001.jpg" alt="Feature Image" />
                                                </li>
</ul><!-- /owl-slider -->
                                        </div><!-- /owl-slider-wrapper -->
                                    </div><!-- /feature-block -->


                                </div><!-- /col-md-6 -->


                                <!-- col-md-6 -->
                                <div class="col-md-6">

                                    <!-- section-title-wrapper section-title-style-3 -->
                                    <div class="section-title-wrapper section-title-style-3">

                                        <!-- section-title -->
                                        <div class="section-title">
                                            
                                            <h3>Proposta de Valor</h3>
                                        </div><!-- /section-title -->

                                    </div><!-- /section-title-wrapper section-title-style-3 -->

                                    <p>Trazer eficiência à atividade de recuperação de créditos inadimplentes a todos os players do mercado, através do uso intensivo de tecnologia.</p>

                                </div><!-- /col-md-6 -->


                            </div><!-- /row -->
                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /light-section -->

            <!-- grey-section -->
            <div class="grey-section" id="servicos">

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
                                    <!-- section-title-wrapper -->
                                    <div class="section-title-wrapper">

                                        <!-- section-title 
                                        <div class="section-title">
                                            <h3>Serviços</h3>
                                        </div><!-- /section-title -->

                                        <!-- section-desc 
                                        <div class="section-desc">
                                            <p>A enorme quantidade de informações geradas diariamente nas empresas e a falta de uma infraestrutura para gerenciar esses de dados, causam diversos problemas na tomada de decisão, além de grande perda de tempo e dinheiro.Qualquer tamanho de empresa ou área de negócio pode se beneficiar das vantagens oferecidas pelas soluções de BI&EMARKETING da Adimplere.</p>
                                        </div><!-- /section-desc -->

                                    </div><!-- /section-title-wrapper -->
                                </div><!-- /col-md-12 -->


                            </div><!-- /row -->


                            <!-- row -->
                            <div class="row">


                                <!-- col-md-3 member-block -->
                                <div class="col-md-4 member-block">
                                    <!-- member-item -->
                                    <div class="member-item">


                                        <!-- member-header -->
                                        <div class="member-header">
                                            <img src="images/about-1.jpg" alt="Member Image" />
                                        </div><!-- /member-header -->


                                        <!-- member-footer -->
                                        <div class="member-footer">

                                            <!-- member-name -->
                                            <div class="member-name">
                                                <h4>
                                                    Cobranças automatizadas
                                                </h4>
                                            </div><!-- /member-name -->

                                            
                                            <div class="member-desc">
                                                <p>Antes de passar pelo tradicional processo de recuperação, a Adimplere realiza campanhas automatizadas, gerando diminuição de custos e ganhos de escala.</p>
                                            </div><!-- /member-desc -->

                                            

                                        </div><!-- /member-footer -->


                                    </div><!-- /member-item -->
                                </div><!-- /col-md-3 member-block -->


                                <!-- col-md-3 member-block -->
                                <div class="col-md-4 member-block">
                                    <!-- member-item -->
                                    <div class="member-item">


                                        <!-- member-header -->
                                        <div class="member-header">
                                            <img src="images/about-2.jpg" alt="Member Image" />
                                        </div><!-- /member-header -->


                                        <!-- member-footer -->
                                        <div class="member-footer">

                                            <!-- member-name -->
                                            <div class="member-name">
                                                <h4>
                                                    Plataforma de negociação online
                                                    
                                                </h4>
                                            </div><!-- /member-name -->

                                            
                                            <!-- member-desc -->
                                            <div class="member-desc">
                                                <p>Os inadimplentes podem escolher as melhores condições para quitação de suas pendências sem interação humana.</p>
                                            </div><!-- /member-desc -->


                                        </div><!-- /member-footer -->


                                    </div><!-- /member-item -->
                                </div><!-- /col-md-3 member-block -->


                                <!-- col-md-3 member-block -->
                                <div class="col-md-4 member-block">
                                    <!-- member-item -->
                                    <div class="member-item">


                                        <!-- member-header -->
                                        <div class="member-header">
                                            <img src="images/about-3.jpg" alt="Member Image" />
                                        </div><!-- /member-header -->


                                        <!-- member-footer -->
                                        <div class="member-footer">

                                            <!-- member-name -->
                                            <div class="member-name">
                                                <h4>
                                                    Acompanhamento em tempo real
                                                </h4>
                                            </div><!-- /member-name -->

                                           
                                            <div class="member-desc">
                                                <p>A possibilidade de trabalhar com um sistema único e rápido gera ganhos de produtividade com acesso rápido à indicadores, acordos e relatórios.</p>
                                            </div><!-- /member-desc -->


                                        </div><!-- /member-footer -->

 
                                    </div><!-- /member-item -->
                                </div><!-- /col-md-3 member-block -->


                            </div><!-- /row -->


                        </div><!-- /container -->


                    </div><!-- /section-container -->
                </div><!-- /main-section -->

            </div><!-- /grey-section -->

            <body>
                
                <tr><td><%@include file='footer.jsp'%></td></tr>
                
            </body>

            




        </div><!-- /main-wrapper -->




        


    </body>

</html>
