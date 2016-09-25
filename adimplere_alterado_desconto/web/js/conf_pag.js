function sendMail2(nome, cliente, valorpago, metodopag, transactionkey,cpf) {
    var ok = validateEmail(); 
    var email = document.getElementById('email_conf1').value;
    
    if(ok==true){
    $.ajax(
             {
            type: "POST",
            url: "https://mandrillapp.com/api/1.0/messages/send-template.json",
            data: {
                "key": "lRyXtu1gNKhr-QrIBMY-BQ",
                "template_name": "enviaconf",
                "template_content": [
                    {   
            "name": "example name",
            "content": "example content"
        }
                ],
                "message": {
                    "from_email": "contato@adimplere.com.br",
                    "from_name": "Equipe Adimplere",
                    "headers": {
                        "Reply-To": "contato@adimplere.com.br"
                    },
                    "subject": cliente + " - Pagamento Identificado",
                    "text": "email",
                    "merge_language": "handlebars",
                    "global_merge_vars": [
                    {
                        "name": "nome",
                        "content": nome
                    },
                     {
                        "name": "tranKey",
                        "content": transactionkey
                    },
                    {
                        "name": "valorpago",
                        "content": valorpago
                    }
                    
                ],
                "merge_vars": [
                    {
                        "rcpt": email,
                        "vars": [
                            {
                                
                            }
                        ]
                    }
                    
                ],
                    "to": [
                    {
                        "email": email,
                        "name": nome,
                        "type": "to"
                    }]
                }
            }
        }
        ).fail(function(response) {
            console.log(response);
        });
        
        $.ajax({

                           type: "POST",
                           url: "update_email.jsp",
                           data: { email: email, cpf:cpf }
                            }).fail(function(response) {
                                console.log(response);
                                return false;

           });
           setTimeout(function(){redirectUrl("cartao_credito_confirmacao_email.jsp");},1000);
}
}  
    
    
    
