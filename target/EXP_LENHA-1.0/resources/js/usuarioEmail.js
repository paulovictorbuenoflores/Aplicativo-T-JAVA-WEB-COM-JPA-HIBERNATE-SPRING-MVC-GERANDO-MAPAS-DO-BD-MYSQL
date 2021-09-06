

function emailUser(){
               
               var email = '#{request.remoteUser}';
                //var email =valor;
                document.getElementById('comentarios:email').value=(email);
          //alert(email);
    return email;

            }