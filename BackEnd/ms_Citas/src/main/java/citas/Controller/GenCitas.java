package citas.Controller;

import java.util.Date;  
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import citas.Model.Buscadores;
import citas.Model.Citas;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

public class GenCitas {
    PersonasDAO bd;

    public GenCitas() {
        bd = new PersonasDAO();
    }

    /**
     * Metodo para obtener en una lista las caracteristicas que busca el buscador
     * 
     * @param Buscador
     * @return
     */
    private ArrayList<String> cBuscador(Buscadores buscador) {
        ArrayList<String> c = new ArrayList<>();
        c.add(buscador.getG_contextura());
        c.add(buscador.getG_Interes());
        c.add(buscador.getG_estatura());
        c.add(buscador.getG_Identidad());
        c.add(buscador.getG_Edad());
        return c;
    }

    private ArrayList<String> cPostulante(Postulantes postulantes) {
        ArrayList<String> c = new ArrayList<>();
        c.add(postulantes.getPhysique());
        c.add(postulantes.getInteres());
        c.add(String.valueOf(postulantes.getHeight()));
        c.add(postulantes.getGender());
        c.add(String.valueOf(postulantes.getAge()));
        return c;
    }

    public Date getAdjustedDate(Date lastDate) {

        // Convertir java.util.Date a LocalDateTime
        LocalDateTime lastDateTime = lastDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // Agregar 10 minutos
        LocalDateTime newDateTime = lastDateTime.plusMinutes(10);

        // Ajustar la fecha y hora si está fuera del rango permitido
        newDateTime = adjustToWorkingHours(newDateTime);

        // Convertir de vuelta a java.util.Date
        Date adjustedDate = Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return adjustedDate;
    }

    private LocalDateTime adjustToWorkingHours(LocalDateTime dateTime) {
        // Horarios de trabajo: 8 AM a 10 PM
        LocalTime startWorkTime = LocalTime.of(8, 0);
        LocalTime endWorkTime = LocalTime.of(22, 0);

        // Días de la semana permitidos (Lunes a Viernes)
        DayOfWeek startOfWeek = DayOfWeek.MONDAY;
        DayOfWeek endOfWeek = DayOfWeek.FRIDAY;

        // Si es fin de semana, mover a lunes a las 8 AM
        if (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dateTime = dateTime.with(TemporalAdjusters.next(startOfWeek)).with(startWorkTime);
        }

        // Si la hora es después de las 10 PM, mover al día siguiente a las 8 AM
        if (dateTime.toLocalTime().isAfter(endWorkTime) || dateTime.toLocalTime().equals(endWorkTime)) {
            dateTime = dateTime.plusDays(1).with(startWorkTime);
        }

        // Si la hora es antes de las 8 AM, mover a las 8 AM del mismo día
        if (dateTime.toLocalTime().isBefore(startWorkTime)) {
            dateTime = dateTime.with(startWorkTime);
        }

        // Si cae en fin de semana después de los ajustes, mover al lunes siguiente a las 8 AM
        if (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dateTime = dateTime.with(TemporalAdjusters.next(startOfWeek)).with(startWorkTime);
        }

        // Si cae fuera de los días de semana (después de mover al siguiente día), ajustar al próximo día hábil
        while (dateTime.getDayOfWeek().getValue() < startOfWeek.getValue() || dateTime.getDayOfWeek().getValue() > endOfWeek.getValue()) {
            dateTime = dateTime.plusDays(1).with(startWorkTime);
        }

        return dateTime;
    }

    /**
     * Metodo para generar citas
     */
    public void genCitas() {
        ArrayList<String> c_buscadores = new ArrayList<>();
        try {
            c_buscadores = new ArrayList<>(bd.cedulaDeBuscadores());
        } catch (Exception e) {
        }
        ArrayList<String> c_postulantes = new ArrayList<>();
            try {
                c_postulantes = new ArrayList<>(bd.cedulaDePostulantes());
            } catch (Exception e) {
            }

        for (String i : c_buscadores) {
            Buscadores b = bd.consultarBuscadore(i);
            ArrayList<String> cb = new ArrayList<>(cBuscador(b));
            
            for(String j : c_postulantes){
                int count = 0;
                ArrayList<String> cp = new ArrayList<>(cPostulante(bd.consultarPostulante(j)));
                for(String k : cb){
                    if(cp.contains(k)) count++;
                }
                if(count>=3){
                    try {
                        bd.crearCita(new Citas(bd.ultimoID()+1, i, j, null, null, null, getAdjustedDate(bd.ultimaFecha())));
                    } catch (SQLException e) {
                        
                    }
                }
                    
            }

        }
    }

}
