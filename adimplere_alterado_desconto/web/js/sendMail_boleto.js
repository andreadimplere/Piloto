function sendMail_boleto(url, nome, cliente, email, valorpago, metodopag, transactionkey) {
  
    
    $.ajax(
             {
            type: "POST",
            url: "https://mandrillapp.com/api/1.0/messages/send-template.json",
            data: {
                "key": "lRyXtu1gNKhr-QrIBMY-BQ",
                "template_name": "enviaboleto",
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
                    "subject": cliente + " - Boleto bancário",
                    "text": "email",
                    "merge_language": "handlebars",
                    "global_merge_vars": [
                    {
                        "name": "nome",
                        "content": nome
                    },
                     {
                        "name": "url1",
                        "content": url
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
            return false;
        }); 
        return true;
}
    
    
    
