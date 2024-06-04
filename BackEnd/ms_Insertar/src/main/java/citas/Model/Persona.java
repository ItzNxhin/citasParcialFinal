package citas.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor@ToString
public class Persona {
    protected String cedula;
    protected String name;
    protected String lastname;
    protected int age;
    protected float height;
    protected String job;
    protected String physique;
    protected String c_status;
    protected String gender;
    protected String email;
    protected String phone;
    protected boolean pago;
}
