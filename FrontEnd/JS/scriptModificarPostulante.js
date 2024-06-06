let boton1 = document.getElementById("registrarBuscador");

boton1.addEventListener("click", evento => {
    evento.preventDefault();
    editarPostulante();
    var div = document.getElementById("contenedor");
    div.style.display="none"
    alert("Datos modificados con exito")
    window.location.href("index.html")
});

async function editarPostulante() {
    let campos = {};

    campos.cedula = document.getElementById("cedulaPostulante").value;
    campos.name = document.getElementById("nombrePostulante").value;
    campos.lastname = document.getElementById("apellidoPostulante").value;
    campos.age = document.getElementById("edadPostulante").value;
    campos.height = document.getElementById("estaturaPostulante").value;
    campos.job = document.getElementById("profesionPostulante").value;
    campos.physique = document.getElementById("contexturaPostulante").value;
    campos.c_status = document.getElementById("estadoCivilPostulante").value;
    campos.gender = document.getElementById("generoPostulante").value;
    campos.email = document.getElementById("correoPostulante").value;
    campos.phone = document.getElementById("telefonoPostulante").value;
    if(document.getElementById("pagoPostulante").value == "si"){
        campos.pago = true;
    }
    else{
        campos.pago = false;
    }
    campos.interes = document.getElementById("interesPrincipalPostulante").value;
    campos.disponibilidad = document.getElementById("disponibilidadPostulante").value;
    
    // Validar edad
    if (campos.age < 25 || campos.age > 35) {
        alert("No cumples con el requisito de edad de la convocatoria.");
        return;
    }

    // Validar campos vacíos
    for (let key in campos) {
        if (campos[key] === "") {
            alert("Por favor completa todos los campos.");
            return;
        }
    }
    
    try {
        const peticion = await fetch("http://localhost:8001/FrontEnd/editarPostulante", {
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