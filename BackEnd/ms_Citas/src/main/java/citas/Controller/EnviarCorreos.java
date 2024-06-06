package citas.Controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EnviarCorreos {
    public  void enviarCorreo(String correo, String mensaje) {
        // Información del servidor SMTP y credenciales
        String host = "smtp.gmail.com";
        String username = "correosnahin@gmail.com";
        String password = "N123456789!";

        // Propiedades de la sesión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Autenticación del usuario
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Crear un objeto MimeMessage
            Message message = new MimeMessage(session);

            // Establecer el remitente
            message.setFrom(new InternetAddress(username));

            // Agregar destinatario(s)
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));

            // Asunto del correo
            message.setSubject("Speed Dating");

            // Contenido del correo
            message.setText(mensaje);

            // Enviar el correo
            Transport.send(message);

            

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

