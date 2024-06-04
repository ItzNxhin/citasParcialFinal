
/*document.addEventListener('DOMContentLoaded', async () => {
    try {
        const response = await fetch('http://localhost:8003/FrontEnd/XD', {
            method: 'GET',
            headers: {
                'Accept': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Error al realizar la solicitud HTTP');
        }

        const persona = await response.json();
        const html = `
            <p><strong>Nombre:</strong> ${persona.name}</p>
            <p><strong>Cédula:</strong> ${persona.cedula}</p>
            <p><strong>Apellido:</strong> ${persona.lastname}</p>
        `;
        document.getElementById('personaInfo').innerHTML = html;
    } catch (error) {
        console.error('Error:', error);
    }
});*/

document.addEventListener("DOMContentLoaded", () => {
    let boton = document.getElementById("registrarBuscador");

    boton.addEventListener("click", evento => {
        evento.preventDefault();  // Previene el comportamiento por defecto del formulario
        registrarPersona();
    });

    async function registrarPersona() {
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
        try {
            const peticion = await fetch("http://localhost:8002/FrontEnd/insertar", {
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
});