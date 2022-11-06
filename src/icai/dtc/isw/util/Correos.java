package icai.dtc.isw.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Clase para formatear los correos que se enviarán al usuario
 */
public class Correos {

    /**
     * Envía un correo con una nueva contraseña
     * @param destinatario Correo destino
     * @param nuevaPass Contraseña nueva
     * @return
     */
    public static boolean nuevaContrasena(String destinatario, String nuevaPass){

        final String user = "databall.notificaciones@gmail.com"; //Hay que crear un correo
        final String password = "gvjkcxgpmzpzgftq";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            message.setSubject("DataBall - Recuperar contraseña");
            message.setText("Tu nueva contraseña es: \n" + nuevaPass + "\n" + "Recuerda que puedes cambiarla en cualquier momento en la sección de perfil.");

            Transport.send(message);

            System.out.println("El correo se ha enviado correctamente");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo");
            return false;
        }
    }

}
