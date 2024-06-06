package citas.ms_Citas;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.util.http.ConcurrentDateFormat;

import citas.Controller.CalCitas;
import citas.Controller.GenCitas;
import citas.Model.Citas;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;
import java.util.Date;

@SuppressWarnings("unused")
public class Test {
    static void h() {

        
        PersonasDAO a = new PersonasDAO();
        CalCitas xd = new CalCitas();
        
        xd.calificar();
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

    }

    public static void main(String[] args) {
        h();
    }
}
