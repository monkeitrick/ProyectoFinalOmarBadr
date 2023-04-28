window.onload
{
    Array.from(document.getElementsByTagName('input')).forEach(function(element) {element.addEventListener('blur', comprobar)});
}
function comprobar(){
    let id = this.id;
    let value = this.value;
    if(value == "")
        return;
    let nombre = new RegExp(/^[a-zA-Z ]{0,100}$/);
    let apellidos = new RegExp(/^[a-zA-Z \d]{1,40}$/);
    let email = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    switch (id) {
        case 'usuario':
            if (!apellidos.test(value)){
                alert("Apellidos Incorrecto");
                document.getElementById(id).value = "";
            }
            break;
        case 'nombre':
            if (!nombre.test(value)){
                alert("Nombre Incorrecto");
                document.getElementById(id).value = "";
            }
            break;
        case 'email':
            if (!email.test(value)){
                alert("Email Incorrecto");
                document.getElementById(id).value = "";
            }
            break;
        case 'pass2':
            let pass1 = document.getElementById('pass1').value;
            if (pass1 != value){
                alert("Las contraseñas no coincide");
                document.getElementById(id).value = "";
            }
            break;
    }
}