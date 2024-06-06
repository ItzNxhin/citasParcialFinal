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

    @GetMapping("/FrontEnd/citas")
    public ArrayList<Citas> obtenerCitas() throws SQLException {
        PersonasDAO a = new PersonasDAO();
        return a.obtenerCitas();
    }

    @PostMapping("/FrontEnd/calificarCita")
    public void calificarCita(@RequestBody Citas cita) throws SQLException {
        PersonasDAO a = new PersonasDAO();
        a.calificarCita(cita);
    }
}
