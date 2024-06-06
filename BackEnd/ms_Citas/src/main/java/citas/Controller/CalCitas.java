package citas.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import citas.Model.Citas;
import citas.Model.Database.PersonasDAO;

public class CalCitas {
    PersonasDAO bd;
    EnviarCorreos cr;

    public CalCitas(){
        bd = new PersonasDAO();
        cr = new EnviarCorreos();
    }    

    /**
     * Este metodo retorna la calificacion segun los criterios del admin.
     * @return
     */
    private String calP(String calB, String calP){
        if(calB.equals(calP)){
            return calP;
        }
        else if(calB.equals("no interesado") || calP.equals("no interesado")){
            return "no interesado";
        }
        else{
            return "amistad";
        }
        
    }

    /**
     * Metodo encargado de calificar y mandar los correos
     */
    public void calificar(){
        try {
            ArrayList<Citas> citas = new ArrayList<>(bd.citas());
            for(Citas i : citas){
                System.out.println(i.toString());
                String calificacion = calP(i.getCal_Buscador(), i.getCal_Postulante());
                
                i.setCal_Cita(calificacion);
                bd.calificarCita(i);
                if(calificacion.equals("amistad")){
                    cr.enviarCorreo(bd.consultarBuscadore(i.getC_buscador()).getEmail(), "Contactate con tu cita para que sean amigos");
                    cr.enviarCorreo(bd.consultarPostulante(i.getC_postulante()).getEmail(), "Contactate con tu cita para que sean amigos");
                }
                else if(calificacion.equals("más que amistad")){
                    cr.enviarCorreo(bd.consultarBuscadore(i.getC_buscador()).getEmail(), "Contactate con tu cita para que salgan, HAY MATCH!!!");
                    cr.enviarCorreo(bd.consultarPostulante(i.getC_postulante()).getEmail(), "Contactate con tu cita para que salgan, HAY MATCH!!!");
                }
            }
        } catch (SQLException e) {
            
        } 
    }
}
