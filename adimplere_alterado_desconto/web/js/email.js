jQuery(function($)  
{
    $(".confirmation").submit(function()
    {
        var email = $("#email").val(); // get email field value
        $.ajax(
        {
            type: "POST",
            url: "https://mandrillapp.com/api/1.0/messages/send.json",
            data: {
                'key': 'lRyXtu1gNKhr-QrIBMY-BQ',
                'message': {
                    'from_email': 'contato@adimplere.com.br',
                    'from_name': 'Andre',
                    'headers': {
                        'Reply-To': 'contato@adimplere.com.br'
                    },
                    'subject': 'Mais informações',
                    'text': email,
                    'to': [
                    {
                        'email': 'andre@adimplere.com.br',
                        'name': 'Andre',
                        'type': 'to'
                    }]
                }
            }
        })
        .done(function(response) {
            alert('Entraremos em contato em breve ;)'); // 
            
            $("#email").val(''); // reset field after successful submission
            
        })
        .fail(function(response) {
            alert('Error sending message.');
        });
        return false; // prevent page refresh
    });
});