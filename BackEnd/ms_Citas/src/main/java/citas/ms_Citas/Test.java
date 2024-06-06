package citas.ms_Citas;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.util.http.ConcurrentDateFormat;

import citas.Model.Citas;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;
import java.util.Date;
public class Test {
    static void h() {

        Citas s =  new Citas();
        PersonasDAO a = new PersonasDAO();
        s.setId(3);
        s.setCal_Buscador("amigos");
        s.setCal_Postulante("amigos");
        s.setCal_Cita("amigos");

        Calendar calendar = Calendar.getInstance();
        
        // Establecer el año actual
        int year = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR, year);
        
        // Encontrar el próximo viernes
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        // Verificar si el día actual es posterior al viernes de esta semana
        // Si es así, mover al siguiente viernes
        if (calendar.getTime().before(new Date())) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        }

        s.setFecha(calendar.getTime());
        
        try {
            a.crearCita(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s.toString());
        

    }

    public static void main(String[] args) {
        h();
    }
}
