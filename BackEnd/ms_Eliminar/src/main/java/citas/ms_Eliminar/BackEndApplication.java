package citas.ms_Eliminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import citas.Model.Database.PersonasDAO;

@RestController
@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@PostMapping("/FrontEnd/eliminarPostulante")
	public void eliminarPostulante(@RequestBody String cedula){
		PersonasDAO a = new PersonasDAO();
		try {
			//a.eliminarPostulante(cedula);
		} catch (Exception e) {

		}
		System.out.println(cedula);
	}
}
