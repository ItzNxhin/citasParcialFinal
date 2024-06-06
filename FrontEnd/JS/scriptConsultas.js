window.onload = function(){
    var div = document.getElementById("contenedor");
    div.style.display="none"
    traerCedulasBuscadores()
}
let boton = document.getElementById("realizarConsulta");

boton.addEventListener("click", evento => {
    evento.preventDefault();
    document.getElementById("realizarConsulta").style.display = "none";
    document.getElementById("contenedor").style.display = "flex";
    consultarBuscador();
});
async function traerCedulasBuscadores(){
    try{
        var response = await fetch('http://localhost:8003/FrontEnd/traerCedulasBuscadores', {
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
            <select  class="campo" id="cedula">`
                for(var i=0; i<cedulas.length; i++){
                    html+=`<option value="${cedulas[i]}">${cedulas[i]}</option>`
                }
            html+=`</select>`
        ;
        document.getElementById('divCedulas').innerHTML = html;
    }
    catch (error) {
        console.error("Error:", error);
    }
    
}
async function consultarBuscador(){

    try { 
        var cedula = document.getElementById("cedula").value;
        var response = await fetch('http://localhost:8003/FrontEnd/consultarBuscador/'+cedula, {
            method: "GET",
            headers: {
                Accept: "application/json",
            }
        });
    
        if (!response.ok) {
            throw new Error("Error al realizar la solicitud HTTP");
        }
    
        var campos = await response.json();
        document.getElementById("cedulaBuscador").value = campos.cedula
        document.getElementById("nombreBuscador").value = campos.name
        document.getElementById("apellidoBuscador").value = campos.lastname
        document.getElementById("edadBuscador").value = campos.age
        document.getElementById("estaturaBuscador").value = campos.height
        document.getElementById("profesionBuscador").value = campos.job
        document.getElementById("contexturaBuscador").value = campos.physique
        document.getElementById("estadoCivilBuscador").value = campos.c_status
        document.getElementById("generoBuscador").value = campos.gender
        document.getElementById("correoBuscador").value = campos.email
        document.getElementById("telefonoBuscador").value = campos.phone
        if(campos.pago = true){
            document.getElementById("pagoBuscador").value == 'si'
        }
        else{
            document.getElementById("pagoBuscador").value == 'no'
        }
        document.getElementById("interesIdealBuscador").value = campos.g_Interes
        document.getElementById("contexturaIdealBuscador").value = campos.g_contextura
        document.getElementById("estaturaIdealBuscador").value = campos.g_estatura
        document.getElementById("generoGustoBuscador").value = campos.g_Identidad
        document.getElementById("edadIdealBuscador").value = campos.g_Edad
    } catch (error) {
        console.error("Error:", error);
    }
}