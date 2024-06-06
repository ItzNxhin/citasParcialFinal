$(document).ready(function() {
    // Fetch citas from backend
    $.getJSON('http://localhost:8008/FrontEnd/citas', function(data) {
        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            events: data.map(cita => {
                console.log('Raw date from backend:', cita.fecha);
                
                return {
                    title: `Cita ${cita.id}`,
                    start: new Date(cita.fecha),
                    end: new Date(new Date(cita.fecha).getTime() + 10 * 60000), // Add 10 minutes
                    id: cita.id,
                    cedulaBuscador: cita.c_buscador,
                    cedulaPostulante: cita.c_postulante
                };
            }),
            eventClick: function(event) {
                $('#citaId').val(event.id);
                $('#cedulaBuscador').val(event.cedulaBuscador);
                $('#cedulaPostulante').val(event.cedulaPostulante);
            }
        });
    });

    // Handle form submission
    $('#calificacionForm').on('submit', function(event) {
        event.preventDefault();
        
        const citaId = $('#citaId').val();
        const cedulaBuscador = $('#cedulaBuscador').val();
        const cedulaPostulante = $('#cedulaPostulante').val();
        const calificacionBuscador = $('#calificacionBuscador').val();
        const calificacionPostulante = $('#calificacionPostulante').val();
        
        const calificacionData = {
            id: citaId,
            c_buscador: cedulaBuscador,
            c_postulante: cedulaPostulante,
            cal_Buscador: calificacionBuscador,
            cal_Postulante: calificacionPostulante
        };

        $.ajax({
            url: 'http://localhost:8008/FrontEnd/calificarCita',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(calificacionData),
            success: function() {
                alert('Calificación enviada');
                $('#calificacionForm')[0].reset();
            },
            error: function() {
                alert('Error al enviar la calificación');
            }
        });
    });
});

$(document).ready(function() {
    // Función para abrir el formulario de calificación y prellenarlo con los detalles de la cita seleccionada
    function abrirFormularioCalificacion(event) {
        $('#citaId').val(event.id);
        $('#cedulaBuscador').val(event.cedulaBuscador);
        $('#cedulaPostulante').val(event.cedulaPostulante);
        $('#calificacionBuscador').val(event.calificacionBuscador || '');
        $('#calificacionPostulante').val(event.calificacionPostulante || '');
        
        // Aquí puedes mostrar el formulario de calificación o cualquier otra acción que necesites
        // Por ejemplo, mostrar un modal o abrir un diálogo
        $('#calificacionModal').modal('show');
    }

    // Fetch citas from backend
    $.getJSON('http://localhost:8008/FrontEnd/citas', function(data) {
        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            events: data.map(cita => {
                console.log('Raw date from backend:', cita.fecha);
                
                return {
                    title: `Cita ${cita.id}`,
                    start: new Date(cita.fecha),
                    end: new Date(new Date(cita.fecha).getTime() + 10 * 60000), // Add 10 minutes
                    id: cita.id,
                    cedulaBuscador: cita.c_buscador,
                    cedulaPostulante: cita.c_postulante,
                    calificacionBuscador: cita.cal_Buscador,
                    calificacionPostulante: cita.cal_Postulante
                };
            }),
            eventClick: function(event) {
                abrirFormularioCalificacion(event);
            }
        });
    });

    // Handle form submission
    $('#calificacionForm').on('submit', function(event) {
        event.preventDefault();
        
        const citaId = $('#citaId').val();
        const cedulaBuscador = $('#cedulaBuscador').val();
        const cedulaPostulante = $('#cedulaPostulante').val();
        const calificacionBuscador = $('#calificacionBuscador').val();
        const calificacionPostulante = $('#calificacionPostulante').val();
        
        const calificacionData = {
            id: citaId,
            c_buscador: cedulaBuscador,
            c_postulante: cedulaPostulante,
            cal_Buscador: calificacionBuscador,
            cal_Postulante: calificacionPostulante
        };

        $.ajax({
            url: 'http://localhost:8008/FrontEnd/calificarCita',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(calificacionData),
            success: function() {
                alert('Calificación enviada');
                $('#calificacionForm')[0].reset();
                $('#calificacionModal').modal('hide');
            },
            error: function() {
                alert('Error al enviar la calificación');
            }
        });
    });
});