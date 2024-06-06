$(document).ready(function () {
    function fetchCitas() {
        $.ajax({
            url: "http://localhost:8080/FrontEnd/citas",
            method: "GET",
            success: function (data) {
                renderCalendar(data);
            },
            error: function (error) {
                console.error("Error fetching citas:", error);
            }
        });
    }

    function renderCalendar(citas) {
        $('#calendar').fullCalendar({
            events: citas.map(cita => ({
                title: `Cita ${cita.id} - Buscador: ${cita.c_buscador} - Postulante: ${cita.c_postulante}`,
                start: cita.fecha,
                id: cita.id
            })),
            eventClick: function (event) {
                $('#calificarCitaForm').show();
                $('#citaId').val(event.id);
            }
        });
    }

    $('#formCalificarCita').on('submit', function (e) {
        e.preventDefault();
        const citaId = $('#citaId').val();
        const calificacionBuscador = $('#calificacionBuscador').val();
        const calificacionPostulante = $('#calificacionPostulante').val();

        const calificacionData = {
            id: citaId,
            cal_Buscador: calificacionBuscador,
            cal_Postulante: calificacionPostulante
        };

        $.ajax({
            url: "http://localhost:8080/FrontEnd/calificarCita",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(calificacionData),
            success: function () {
                alert("Cita calificada exitosamente.");
                $('#calificarCitaForm').hide();
                $('#formCalificarCita')[0].reset();
                $('#calendar').fullCalendar('refetchEvents');
            },
            error: function (error) {
                console.error("Error califying cita:", error);
            }
        });
    });

    fetchCitas();
});
