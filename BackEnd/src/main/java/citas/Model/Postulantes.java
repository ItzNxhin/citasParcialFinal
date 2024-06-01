package citas.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class Postulantes extends Persona {
    private String interes;
    private String disponibilidad;
}
