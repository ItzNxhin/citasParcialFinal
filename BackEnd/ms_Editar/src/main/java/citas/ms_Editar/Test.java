package citas.ms_Editar;

import java.sql.SQLException;
import java.util.ArrayList;

import citas.Model.Buscadores;
import citas.Model.Persona;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

@SuppressWarnings("unused")
public class Test {
    static void h() {

        Buscadores a = new Buscadores();
        a.setName("Nicolas");
        a.setLastname("De prueba");
        a.setAge(19);
        a.setHeight(Float.parseFloat("1.75"));
        a.setJob("Trabajo generico");
        a.setPhysique("Flaco");
        a.setC_status("Soltero");
        a.setGender("Hombre");
        a.setEmail("correo@gmail.com");
        a.setPhone("3003003000");
        a.setCedula("9738463921");
        a.setPago(true);

        PersonasDAO n = new PersonasDAO();

        try {
          //  n.modificarPostulante(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    public static void main(String[] args) {
        h();
    }
}
