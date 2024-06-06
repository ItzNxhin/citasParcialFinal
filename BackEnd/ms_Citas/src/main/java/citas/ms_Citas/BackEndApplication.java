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
        // Método principal que inicia la aplicación Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }
 // Configuración CORS para permitir solicitudes desde un origen específico
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Permite solicitudes de cualquier ruta (/**) desde el origen http://127.0.0.1:5501
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5501") // Origen permitido
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                        .allowedHeaders("*")
                        .allowCredentials(true); // Permite el uso de credenciales (cookies, etc.)
            }
        };
    }
// Define un endpoint que responde a solicitudes GET en /FrontEnd/citas
    @GetMapping("/FrontEnd/citas")
    public ArrayList<Citas> obtenerCitas() throws SQLException {
       // Crea una instancia de PersonasDAO y llama al método citas para obtener la lista de citas
        PersonasDAO a = new PersonasDAO();
        return a.citas();
    }
// Define un endpoint que responde a solicitudes POST en /FrontEnd/calificarCita
    @PostMapping("/FrontEnd/calificarCita")
    public void calificarCita(@RequestBody Citas cita) throws SQLException {
        // Crea una instancia de PersonasDAO y llama al método calificarCita para calificar la cita recibida
        PersonasDAO a = new PersonasDAO();
        a.calificarCita(cita);
    }
}
