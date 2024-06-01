package citas.BackEnd;

import java.sql.SQLException;

import citas.Model.Buscadores;
import citas.Model.Persona;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

public class Test {
    static void h(){
        Buscadores a = new Buscadores();
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
        a.setG_contextura("flaco");
        a.setG_Interes("juegos");
        a.setG_estatura("1.50");
        a.setG_Identidad("mujer");
        a.setG_Edad("15");
        a.setCedula("123456789");

        PersonasDAO consulta = new PersonasDAO();
        try {
            consulta.agregarBuscadores(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    public static void main(String[] args) {
        h();
    }
}
