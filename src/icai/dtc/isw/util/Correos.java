package icai.dtc.isw.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Clase para formatear los correos que se enviarán al usuario
 */
public class Correos {

    public static void nuevaContrasena(String destinatario, String nuevaPass){

        String host="mail.javatpoint.com";
        final String user = "databall@gmail.com"; //Hay que crear un correo
        final String password = "databall";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            message.setSubject("DataBall - Recuperar contraseña");
            message.setText("Tu nueva contraseña es: \n" + nuevaPass + "\n" + "Recuerda que puedes cambiarla en cualquier momento en la sección de perfil.");

            Transport.send(message);

        } catch (MessagingException e) {e.printStackTrace();}
    }

}
