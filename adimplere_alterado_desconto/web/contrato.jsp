<%-- 
    Document   : contrato
    Created on : 03/12/2015, 11:59:42
    Author     : vinic
--%>

<%@page import="spwork.Math_Auxiliar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
        String cpf = request.getParameter("cpf");
        String name = request.getParameter("name");
        String debt_total_atualizado = request.getParameter("debt_total_atualizado");
        Double debt_total_atualizado_double = Double.parseDouble(debt_total_atualizado);
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        Math_Auxiliar math = new Math_Auxiliar();
        
        
        

    %>
    <p>INSTRUMENTO PARTICULAR DE NOVA&Ccedil;&Atilde;O E CONFISS&Atilde;O DE D&Iacute;VIDA  IDENTIFICA&Ccedil;&Atilde;O DAS PARTES CONTRATANTES  CREDOR: SOCIEDADE DE ENSINO SUPERIOR EST&Aacute;CIO DE S&Aacute; LTDA, INSCRITA DO CNPJ N&ordm; 34.075.739/0001-84 E CEUT CENTRO DE ENSINO UNIFICADO DE TERESINA LTDA, INSCRITA NO CNPJ 34.982.124/0001-31, com sede na Avenida dos Expedicion&aacute;rios N&ordm; 790, Teresina, Piau&iacute; &ndash; PI. DEVEDOR: <%=name%>, inscrita no CPF no. <%=cpf%>.</p>

<p>As partes acima identificadas t&ecirc;m, entre si, justas e acertadas o presente Contrato de Nova&ccedil;&atilde;o e Confiss&atilde;o de D&iacute;vida, que se reger&aacute; pelas cl&aacute;usulas seguintes e pelas condi&ccedil;&otilde;es descritas no presente.</p>

<p> DO OBJETO DO CONTRATO   Cl&aacute;usula 1&ordf;. O presente instrumento tem como OBJETO a nova&ccedil;&atilde;o da d&iacute;vida contra&iacute;da pelo DEVEDOR em face do CREDOR acima qualificado, conforme titulo (s) e mensalidades descriminadas em anexo.   DAS DISPOSI&Ccedil;&Otilde;ES GERAIS   Cl&aacute;usula 2&ordf;. O DEVEDOR confessa dever ao CREDOR a quantia de R$ <%=debt_total_atualizado%> (<%=math.valorPorExtenso(debt_total_atualizado_double)%>) decorrente da presta&ccedil;&atilde;o de servi&ccedil;os educacionais referentes(s) o (a) aluno (a) acima identificado (a). Confessa e reconhece ser devedor da SOCIEDADE DE ENSINO SUPERIOR EST&Aacute;CIO DE S&Aacute; LTDA, doravante denominada CREDORA, no total da d&iacute;vida discriminada anexo, parte integrante deste Instrumento Particular de Confiss&atilde;o e Nova&ccedil;&atilde;o de D&iacute;vida, que ser&aacute; quitada na forma e condi&ccedil;&otilde;es aqui estabelecidas, obrigando os herdeiros e sucessores dentro dos limites fixados em Lei. Comprometendo-se a pagar tal valor da maneira acordada no presente instrumento. </p>

<p>Cl&aacute;usula 3&ordf;. A presente transa&ccedil;&atilde;o &eacute; celebrada em car&aacute;ter irrevog&aacute;vel e irretrat&aacute;vel, n&atilde;o comportando, por isso, o arrependimento de nenhuma das partes a nenhum t&iacute;tulo.   DO PAGAMENTO DA D&Iacute;VIDA    Cl&aacute;usula 4&ordf;. A d&iacute;vida ser&aacute; paga ao CREDOR conforme tabela de &ldquo;condi&ccedil;&otilde;es do acordo&rdquo; (anexo) nas datas e valores previstos;   Cl&aacute;usula 5&ordf;. O n&atilde;o pagamento das parcelas referidas neste instrumento importar&aacute; vencimento antecipado das demais parcelas, com plena exigibilidade, incidindo sobre o montante do d&eacute;bito, a contar do inadimplemento, os seguintes encargos:     a) Juros legais de 1% ao m&ecirc;s e corre&ccedil;&atilde;o monet&aacute;ria;    b) Multa de 2,0% sobre o valor total atualizado do d&eacute;bito;</p>

<p> c) Honor&aacute;rios advocat&iacute;cios de 10% sobre o valor total do d&eacute;bito, (Principal + juros + multa).</p>

<p> Cl&aacute;usula 6&ordf;. O pagamento da entrada caracterizar&aacute; &agrave; plena aceita&ccedil;&atilde;o das cl&aacute;usulas dessa confiss&atilde;o.</p>

<p>Cl&aacute;usula 7&ordf;. O descumprimento dessa confiss&atilde;o d&aacute; o direito ao CREDOR a inclus&atilde;o no nome do DEVEDOR nos &oacute;rg&atilde;os de prote&ccedil;&atilde;o ao cr&eacute;dito como tamb&eacute;m ao protesto do presente instrumento.   DO FORO    Cl&aacute;usula 8&ordf;. Para dirimir quaisquer controv&eacute;rsias oriundas do CONTRATO, as partes elegem o foro da comarca do Rio de Janeiro RJ.    Por estarem assim justos e contratados, firmam o presente instrumento, em duas vias de igual teor.</p>

<p>Rio de janeiro RJ,<%=Integer.toString(dayOfMonth)+"/"+Integer.toString(month)+"/"+Integer.toString(year)%>  ANEXO I &ndash; CONDI&Ccedil;&Otilde;ES DO ACORDO </p>
</html>
