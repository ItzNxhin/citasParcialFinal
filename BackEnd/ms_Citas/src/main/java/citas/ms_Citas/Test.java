package citas.ms_Citas;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        s.setId(2);
        s.setCal_Buscador("amigos");
        s.setCal_Postulante("amigos");
        s.setCal_Cita("amigos");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            a.calificarCita(s);;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(sdf.format(a.ultimaFecha()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(a.ultimoID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s.toString());
        

    }

    public static void main(String[] args) {
        h();
    }
}
