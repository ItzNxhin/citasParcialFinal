package citas.Model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor 
public class Citas {
    private int id;
    private String c_buscador;
    private String c_postulante;
    private String cal_Buscador;
    private String cal_Postulante;
    private String cal_Cita;
    private Date fecha;
    
}
