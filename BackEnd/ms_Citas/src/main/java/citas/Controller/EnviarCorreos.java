package citas.Controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase para enviar un correo a la persona que se registre en el aplicativo
 * @author Pilar
 * @author Sara
 * @author Alejandro
 * @version 1.0
 */
public class EnviarCorreos {
	
	/**
	 * Correo desde el cual se envia el mensaje con usuario y contraseña
	 */
	private static String emailFrom = "hideseekudistrital@gmail.com";
    /**
     * Contraseña generada por Google para anclar el correo a java
     */
    private static String passwordFrom = "hsao fdjo fqtk dbbc";
    /**
     * Email al que se le va a enviar el correo correspondiente
     */
    private String emailTo;
    /**
     * Asunto del correo
     */
    private String subject;
    /**
     * Contenido del correo que incluye el usuario y la contraseña
     */
    private String content;

    /**
     * Propiedades del correo
     */
    private Properties mProperties;
    /**
     * Sesion para enviar el correo
     */
    private Session mSession;
    /**
     * Estilo del mensaje a enviar
     */
    private MimeMessage mCorreo;

    /**
     * Constructor de la clase
     */
    public EnviarCorreos() {
        mProperties = new Properties();
    }

   	/**
   	 * Metodo para crear el correo a enviar
   	 * @param nombre Nombre del usuario registrado
   	 * @param correo Correo de la persona
   	 * @param usuario Usuario asignado automaticamente
   	 * @param contraseña Contraseña generada para el ingreso
   	 */
   	public void crearMensaje(String correo, String mensaje) {
        emailTo = correo;
        subject = "Tuviste un match";
        content = mensaje;
        
         // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
      
       mCorreo = new MimeMessage(mSession);
       try {
		mCorreo.setFrom(new InternetAddress(emailFrom));
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		mCorreo.setSubject(subject);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		mCorreo.setText(content, "ISO-8859-1", "html");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
                     
    }

    /**
     * Metodo para enviar el mensaje anteriormente creado
     * @throws MessagingException Problemas generales con el envio y recepcion de correos
     */
    public void EnviarMensaje() throws MessagingException {
    	Transport mTransport;
		try {
			mTransport = mSession.getTransport("smtp");
			mTransport.connect(emailFrom, passwordFrom);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
