package citas.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=false) @ToString(callSuper = true) @NoArgsConstructor
public class Buscadores extends Persona {
    private String g_contextura;
    private String g_Interes;
    private String g_estatura;
    private String g_Identidad;
    private String g_Edad;
}
