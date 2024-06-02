package citas.Model;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor 
public class Citas {
    private String id;
    private Date tmp;
    private String ced_buscador;
    private String ced_postulantel;
    private String calf_buscador;
    private String calf_postulante;
    private String calf_cita;  
}
