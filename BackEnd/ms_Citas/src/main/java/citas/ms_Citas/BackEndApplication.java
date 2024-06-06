package citas.ms_Citas;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import citas.Model.Citas;
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
        return a.citas();
    }

    @PostMapping("/FrontEnd/calificarCita")
    public void calificarCita(@RequestBody Citas cita) throws SQLException {
        PersonasDAO a = new PersonasDAO();
        a.calificarCita(cita);
    }
}
