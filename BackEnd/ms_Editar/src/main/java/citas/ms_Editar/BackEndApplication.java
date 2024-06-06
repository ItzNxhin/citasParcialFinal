package citas.ms_Editar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import citas.Model.Buscadores;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

@SpringBootApplication
@RestController
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5501")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

	@PostMapping("/FrontEnd/editarPostulante")
    public void editarPostulante(@RequestBody Postulantes persona) {
        PersonasDAO p = new PersonasDAO();
        try{
            p.modificarPostulante(persona);
        }
        catch(Exception e){
            
        }
    }

	@PostMapping("/FrontEnd/editarBuscador")
    public void editarBuscador(@RequestBody Buscadores persona) {
        PersonasDAO p = new PersonasDAO();
        try{
        	p.modificarBuscador(persona);
			System.out.println("update exitoso");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @PostMapping("/FrontEnd/realizarConvocatoria")
    public void realizarConvocatoria(@RequestBody Object data) {
        // Implementar lógica para realizar convocatoria
        System.out.println("Convocatoria realizada");
    }

    // Nuevo método para calificar citas
    @PostMapping("/FrontEnd/calificarCitas")
    public void calificarCitas(@RequestBody Object data) {
        // Implementar lógica para calificar citas
        System.out.println("Citas calificadas");
    }
}