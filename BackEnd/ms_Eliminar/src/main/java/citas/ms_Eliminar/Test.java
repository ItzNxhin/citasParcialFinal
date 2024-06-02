package citas.ms_Eliminar;


import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

@SuppressWarnings("unused")
public class Test {
    static void h() {

        PersonasDAO a = new PersonasDAO();
        try {
            a.eliminarPostulante("1234568");
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    public static void main(String[] args) {
        h();
    }
}
