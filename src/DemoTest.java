//this is another example
//	private static String toEmail;
//    private static String link;
//    private static final String HOST_NAME = "smtp.gmail.com";
//    private static final String FROM = "xyz@gmail.com";
//    private static final String SUBJECT = "Welcome to Politicol BLOGS";
//    private static final String MESSAGE = "Welcome to Politicol BLOGS. " +
//            "Please go to this link to verify your account and begin: " ;
//    private static final String USERNAME = "xyz@gmail.com";
//    private static final String PASSWORD = "aa";
//    private static final String SMTP_PORT = "465";
//
//    public static void email(String toEmail, String link) {
//    	DemoTest.toEmail = toEmail;
//    	DemoTest.link = link;
//        try{
//            SimpleEmail email = new SimpleEmail();
//            email.setHostName(HOST_NAME);
//            email.addTo(toEmail, "User");
//            email.setFrom(FROM, "Me");
//            email.setSubject(SUBJECT);
//
//            email.setSSL(true);
//            email.setSslSmtpPort(SMTP_PORT);
//            email.setAuthentication(USERNAME,PASSWORD);
//            String msg = MESSAGE + link;
//            email.setMsg(msg);
//            email.send();
//        }catch(Exception e)
//        {
//            System.out.println("Exceptin in emailer.java" +e.getMessage());
//        }
//
//    }

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

class EmailTemplate {
	private final String HOST_NAME = "smtp.gmail.com";
	private final String FROM = "fromamil@gmail.com";
	private String SUBJECT = "Welcome to Politicol BLOGS";
	private String MESSAGE = "Welcome to Politicol BLOGS. "
			+ "Please go to this link to verify your account and begin: ";
	private final String USERNAME = "xzy@gmail.com";
	private final String PASSWORD = "password";
	private final int SMTP_PORT = 587;
	private String TOEMAIL = "tomail@gmail.com";

	public EmailTemplate(String toEmail, String subject, String message) {
		this.TOEMAIL = toEmail;
		this.SUBJECT = subject;
		this.MESSAGE = message;
	}

	public EmailTemplate() {
		super();
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ReflectionToStringBuilder.toString(this);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public void mailSend() {
		try {
			Email email = new SimpleEmail();
			email.setHostName(HOST_NAME);
			email.setSmtpPort(SMTP_PORT);
			email.setAuthentication(USERNAME, PASSWORD);
			email.setSSLOnConnect(true);
			email.setFrom(FROM);
			email.setSubject(SUBJECT);
			email.setMsg(MESSAGE);
			email.addTo(TOEMAIL);
			email.send();
		} catch (Exception e) {
			System.out.println("Exceptin in emailer.java" + e.getMessage());
		}
	}
}

public class DemoTest {
	public static void main(String[] args) {
		
		EmailTemplate template = new EmailTemplate("arvind86mca@gmail.com",
				"This is test email", "Hi thi");
		template.mailSend();
		
	}
}