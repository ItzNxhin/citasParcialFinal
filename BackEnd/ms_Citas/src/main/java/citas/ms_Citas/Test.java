package citas.ms_Citas;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.util.http.ConcurrentDateFormat;

import citas.Controller.GenCitas;
import citas.Model.Citas;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;
import java.util.Date;

@SuppressWarnings("unused")
public class Test {
    static void h() {

        
        PersonasDAO a = new PersonasDAO();
        GenCitas s = new GenCitas();
        // Verificar si el día actual es posterior al viernes de esta semana
        // Si es así, mover al siguiente viernes
        
        
        try {
            s.genCitas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s.toString());
        

    }

    public static void main(String[] args) {
        h();
    }
}
