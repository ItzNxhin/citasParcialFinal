window.onload = function () {
    var div = document.getElementById("contenedor");
    div.style.display = "none"
    traerCedulasPostulados()
}
let boton = document.getElementById("realizarConsulta");

boton.addEventListener("click", evento => {
    evento.preventDefault();
    document.getElementById("realizarConsulta").style.display = "none";
    document.getElementById("contenedor").style.display = "flex";
    consultarPostulado();
});
async function traerCedulasPostulados() {
    try {
        var response = await fetch('http://localhost:8003/FrontEnd/traerCedulasPostulados', {
            method: "GET",
            headers: {
                Accept: "application/json",
            }
        });

        if (!response.ok) {
            throw new Error("Error al realizar la solicitud HTTP");
        }
        var cedulas = await response.json();
        var html = `
            <select  class="camposelect" id="cedula">`
        html += `<option value="" disabled selected>Seleccione la cedula a consultar</option>`
        for (var i = 0; i < cedulas.length; i++) {
            html += `<option value="${cedulas[i]}">${cedulas[i]}</option>`
        }
        html += `</select>`
            ;
        document.getElementById('divCedulas').innerHTML = html;
    }
    catch (error) {
        console.error("Error:", error);
    }

}

async function consultarPostulado() {

    try {
        var cedula = document.getElementById("cedula").value;
        var response = await fetch('http://localhost:8003/FrontEnd/consultarPostulado/' + cedula, {
            method: "GET",
            headers: {
                Accept: "application/json",
            }
        });
    }
    catch (error) {
        console.error("Error:", error);
    }

    var campos = await response.json();
    console.log(campos)
    document.getElementById("cedulaPostulante").value = campos.cedula
    document.getElementById("nombrePostulante").value = campos.name
    document.getElementById("apellidoPostulante").value = campos.lastname
    document.getElementById("edadPostulante").value = campos.age
    document.getElementById("estaturaPostulante").value = campos.height
    document.getElementById("profesionPostulante").value = campos.job 
    document.getElementById("contexturaPostulante").value = campos.physique
    document.getElementById("estadoCivilPostulante").value = campos.c_status
    document.getElementById("generoPostulante").value = campos.gender
    document.getElementById("correoPostulante").value = campos.email
    document.getElementById("telefonoPostulante").value = campos.phone
    if (campos.pago == true) {
        document.getElementById("pagoPostulante").value = "si"
    }
    else {
        document.getElementById("pagoPostulante").value = "no"
    }
    document.getElementById("interesPrincipalPostulante").value = campos.interes
    document.getElementById("disponibilidadPostulante").value = campos.disponibilidad
}