


function validate_SendEmail_Redirect(url,nome, cliente, valorpago, metodopag, transactionkey,cpf)
{
    var ok = validateEmail(); 
    var email = document.getElementById('email_conf1').value;
    var ok2 = false;
    
    if(ok==true)
    {
        
        ok2 = sendMail_boleto(url, nome, cliente,email, valorpago, metodopag, transactionkey);

    
    
        if(ok2==true){
            
                        $.ajax({

                           type: "POST",
                           url: "update_email.jsp",
                           data: { email: email, cpf:cpf }
                            }).fail(function(response) {
                                console.log(response);
                                return false;

           }); 
        setTimeout(function(){redirectUrl(url);},2000);
    }
        
    }
    else
    {
        return false;
    }
}

