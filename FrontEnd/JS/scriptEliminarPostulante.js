window.onload = function () {
    traerCedulasPostulados()
}

let boton2 = document.getElementById("realizarConsulta");

boton2.addEventListener("click", evento => {
    evento.preventDefault();
    eliminarPostulante();
    alert("Persona eliminada con exito")
    window.location.href("index.html")
});

async function eliminarPostulante(){
var cedula = document.getElementById("cedula").value
try{
    await fetch("http://localhost:8004/FrontEnd/eliminarPostulante", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cedula)
    });
    console.log("Datos enviados");
} catch (error) {
    console.log('Error:', error);
}
}

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
        document.getElementById('divCedulas').innerHTML = html;
    }
    catch (error) {
        console.error("Error:", error);
    }

}