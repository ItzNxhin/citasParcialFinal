package citas.Controller;

import citas.Model.Database.PersonasDAO;

public class CalCitas {
    PersonasDAO bd;

    public CalCitas(){
        bd = new PersonasDAO();
    }    

    /**
     * Este metodo retorna la calificacion segun los criterios del admin.
     * @return
     */
    private String calP(String calB, String calP){
        if(calB.equals(calP)){
            return calP;
        }
        else if(calB.equals("no_conexion") || calP.equals("no_conexion")){
            return "no_conexion";
        }
        else{
            return "amigos";
        }
        
    }

    public void calificar(){
        
    }
}
