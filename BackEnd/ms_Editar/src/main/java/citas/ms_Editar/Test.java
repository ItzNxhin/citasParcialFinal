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

        Postulantes a = new Postulantes();
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
<<<<<<< HEAD
        a.setCedula("123");
=======
        a.setCedula("9738463921");
>>>>>>> fd339c4d6da34fffa950d1d3633f9ff29dd02980
        a.setPago(true);

        PersonasDAO n = new PersonasDAO();

        try {
<<<<<<< HEAD
            n.modificarPostulante(a);
=======
            n.modificarBuscador(a);
>>>>>>> fd339c4d6da34fffa950d1d3633f9ff29dd02980
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    public static void main(String[] args) {
        h();
    }
}
