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
<<<<<<< HEAD
        a.setCedula("9533255");
=======
        a.setCedula("9738463921");
>>>>>>> 0b1e12dd1464bcf0f1b886f00f70d77b0a24eb3d
        a.setPago(true);

        PersonasDAO n = new PersonasDAO();

        try {
<<<<<<< HEAD
            n.modificarBuscador(a);
=======
            n.modificarPostulante(a);
>>>>>>> 0b1e12dd1464bcf0f1b886f00f70d77b0a24eb3d
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    public static void main(String[] args) {
        h();
    }
}
