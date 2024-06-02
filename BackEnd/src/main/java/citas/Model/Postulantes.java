package citas.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=false) @ToString(callSuper = true) @NoArgsConstructor
public class Postulantes extends Persona {
    private String interes;
    private String disponibilidad;
}
