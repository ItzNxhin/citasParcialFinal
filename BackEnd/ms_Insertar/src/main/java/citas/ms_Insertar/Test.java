package citas.ms_Insertar;

import java.sql.SQLException;
import java.util.ArrayList;

import citas.Model.Buscadores;
import citas.Model.Persona;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

@SuppressWarnings("unused")
public class Test {
    static void h() {
        
          Postulantes a = new Postulantes();
          a.setName("Sujeto");
          a.setLastname("De prueba");
          a.setAge(19);
          a.setHeight(Float.parseFloat("1.75"));
          a.setJob("Trabajo generico");
          a.setPhysique("Flaco");
          a.setC_status("Soltero");
          a.setGender("Hombre");
          a.setEmail("correo@gmail.com");
          a.setPhone("3003003000");
          a.setDisponibilidad("si");
          a.setInteres("juegos");
          a.setCedula("12345");
         

          PersonasDAO p = new PersonasDAO();
          try {
            p.agregarPostulantes(a);
          } catch (Exception e) {
            // TODO: handle exception
          }

        
    }

    public static void main(String[] args) {
        h();
    }
}
