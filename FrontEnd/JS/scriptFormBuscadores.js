let boton = document.getElementById("registrarBuscador");

boton.addEventListener("click", evento => {
    evento.preventDefault();
    registrarPersona();
});
async function registrarPersona() {
    let campos = {};

    campos.cedula = document.getElementById("cedulaBuscador").value;
    campos.name = document.getElementById("nombreBuscador").value;
    campos.lastname = document.getElementById("apellidoBuscador").value;
    campos.age = document.getElementById("edadBuscador").value;
    campos.height = document.getElementById("estaturaBuscador").value;
    campos.job = document.getElementById("profesionBuscador").value;
    campos.physique = document.getElementById("contexturaBuscador").value;
    campos.c_status = document.getElementById("estadoCivilBuscador").value;
    campos.gender = document.getElementById("generoBuscador").value;
    campos.email = document.getElementById("correoBuscador").value;
    campos.phone = document.getElementById("telefonoBuscador").value;
    if(document.getElementById("pagoBuscador").value == "si"){
        campos.pago = true;
    }
    else{
        campos.pago = false;
    }
    campos.g_Interes = document.getElementById("interesIdealBuscador").value;
    campos.g_contextura = document.getElementById("contexturaIdealBuscador").value;
    campos.g_estatura = document.getElementById("estaturaIdealBuscador").value;
    campos.g_Identidad = document.getElementById("generoGustoBuscador").value;
    campos.g_Edad = document.getElementById("edadIdealBuscador").value;
    try {
        const peticion = await fetch("http://localhost:8002/FrontEnd/insertarBuscador", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });
        console.log("Datos enviados");
    } catch (error) {
        console.log('Error:', error);
    }
}