package citas.ms_Citas;


import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

public class Test {
    static void h() {

        Postulantes s =  new Postulantes();
        PersonasDAO a = new PersonasDAO();
        try {
            s=a.consultarPostulante("1234568");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s.toString());
        

    }

    public static void main(String[] args) {
        h();
    }
}
