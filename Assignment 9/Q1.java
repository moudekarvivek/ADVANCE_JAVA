import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Q1
{
	public static void main(String[] args)
	{
		String receiver = "syca221574@localhost.localdomain";
		String sender = "syca221574@localhost.localdomain";
		String host="localhost";
		
		Properties prop = System.getProperties();
		prop.setProperty("mail.smtp.host",host);
		
		Session s = Session.getDefaultInstance(prop);
		
		try
		{
			MimeMessage msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(sender));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
			msg.setSubject("Text Message");
			msg.setText("Hello Jeevan Sir");
			Transport.send(msg);
			System.out.println("Message Send Successfully");
		}
		catch (MessagingException me)
		{
			me.printStackTrace();
		}		
	}
}
