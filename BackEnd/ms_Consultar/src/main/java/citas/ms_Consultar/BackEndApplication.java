package citas.ms_Consultar;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/FrontEnd/consultarBuscador/{cedula}")
	public Buscadores consultarBuscador(@PathVariable String cedula){
		Buscadores s = new Buscadores();
        PersonasDAO a = new PersonasDAO();
        try {
            s=a.consultarBuscadore(cedula);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return s;
	}

    @GetMapping("/FrontEnd/traerCedulasBuscadores")
	public ArrayList<String> traerCedulasBuscadores()throws Exception{
        PersonasDAO a = new PersonasDAO();
        return a.cedulaDeBuscadores();
	}

    @GetMapping("/FrontEnd/consultarPostulado/{cedula}")
	public Postulantes consultarPostulado(@PathVariable String cedula){
		Postulantes s = new Postulantes();
        PersonasDAO a = new PersonasDAO();
        try {
            s=a.consultarPostulante(cedula);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return s;
	}

    @GetMapping("/FrontEnd/traerCedulasPostulados")
	public ArrayList<String> traerCedulasPostulados()throws Exception{
        PersonasDAO a = new PersonasDAO();
        return a.cedulaDePostulantes();
	}
	
}
