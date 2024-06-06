package citas.ms_Insertar;

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

    @PostMapping("/FrontEnd/insertarPostulante")
    public void insertarPostulante(@RequestBody Postulantes persona) {
        PersonasDAO p = new PersonasDAO();
        try{
            p.agregarPostulantes(persona);
        }
        catch(Exception e){
            
        }
    }

    @PostMapping("/FrontEnd/insertarBuscador")
    public void insertarBuscador(@RequestBody Buscadores persona) {
        PersonasDAO p = new PersonasDAO();
        try{
            p.agregarBuscadores(persona);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
