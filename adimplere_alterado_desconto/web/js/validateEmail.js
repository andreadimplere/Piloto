/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateEmail() {
    var x =  document.getElementById('email_conf1').value;
    var y =  document.getElementById('email_conf2').value;
    var ok=true;
    if (x == null || x == "") {
        alert("E-mail deve ser preenchido");
        ok= false;
        return false;
    }
     if (y == null || y == "") {
         if(ok==true)
            alert("E-mail deve ser preenchido");
        ok = false;
        return false;
    }
    if (y != x) {
        if(ok==true)
            alert("E-mails devem ser iguais");
        ok = false;
        return false;
    }
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if(re.test(x)==false){
        alert("Favor verificar o e-mail informado.");
        return false;
    };
    return true;
               
}
    
    
    
    
    

