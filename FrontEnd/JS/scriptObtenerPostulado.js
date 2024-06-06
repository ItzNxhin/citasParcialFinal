
let boton = document.getElementById("realizarConsulta");

boton.addEventListener("click", evento => {
    evento.preventDefault();
    consultar();
});

async function consultar(){
    try { 
        var cedula = document.getElementById("campoConsultar").value;
        var response = await fetch('http://localhost:8003/FrontEnd/consultarBuscador/'+cedula, {
            method: "GET",
            headers: {
                Accept: "application/json",
            }
        });
    
        if (!response.ok) {
            throw new Error("Error al realizar la solicitud HTTP");
        }
    
        var persona = await response.json();
        document.getElementById("nombreBuscador").value = persona.name;
    } catch (error) {
        console.error("Error:", error);
    }
}
