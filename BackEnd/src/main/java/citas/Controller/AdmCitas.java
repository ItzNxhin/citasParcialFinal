package citas.Controller;

import citas.Model.Citas;

public class AdmCitas {
    

    public AdmCitas(){}

    public Citas calfCita(Citas cita){
        if(cita.getCalf_buscador()=="mas que amistad" && cita.getCalf_postulante()=="mas que amistad"){
            cita.setCalf_cita("mas que amistad");
        }
        else if(cita.getCalf_buscador()=="amistad" && cita.getCalf_postulante()=="amistad"){
            cita.setCalf_cita("amistad");
        }
        else if(cita.getCalf_buscador()=="no conexion" || cita.getCalf_postulante()=="no conexion"){
            cita.setCalf_cita("no conexion");
        }
        else{
            cita.setCalf_cita("amistad");
        }
        return cita;
    }
}
