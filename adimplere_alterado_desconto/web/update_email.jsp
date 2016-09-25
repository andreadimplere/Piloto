<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="spwork.User002"%>
<%@page import="spwork.Boleto003"%>
<%@page import="spwork.User_Helper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        
        User_Helper search_user = new User_Helper();
        List <User002> user_list = new ArrayList();
        User002 user = new User002();
        try{
             user_list = search_user.List_User_From_CPF(cpf,true);
             
             for(int i=0;i<user_list.size();i++)
             {
                 user_list.get(i).setEmailConf002(email);
                 
             }
               for(int i=0;i<user_list.size();i++)
             {
                  User_Helper update_user = new User_Helper();
                  update_user.Update_User(user_list.get(i));
                 
             }
             
             
            
             
                }
        catch(Exception e)
                {
                    //ver tratamento
                }
    
    
%>
