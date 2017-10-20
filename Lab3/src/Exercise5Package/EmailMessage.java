package Exercise5Package;

import java.util.LinkedList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailMessage {
    public String from; //required (must be e-mail)
    public LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional


    protected EmailMessage(  String from_,
                          LinkedList<String> to_,
                          String subject_,
                          String content_,
                          String mimeType_,
                          LinkedList<String> cc_,
                          LinkedList<String> bcc_){
        from = from_;
        to = to_;
        subject = subject_;
        content = content_;
        mimeType = mimeType_;
        cc = cc_;
        bcc = bcc_;
    }

    static public class Builder{
        String from, subject, content, mimeType = "";
        LinkedList<String> to = new LinkedList<String>();
        LinkedList<String> cc = new LinkedList<String>();
        LinkedList<String> bcc = new LinkedList<String>();

        public Builder addFrom(String from_)
        {
            from = from_;
            return this;
        }
        public Builder addTo(String to_)
        {
            to.add(to_);
            return this;
        }
        public Builder addSubject(String subject_)
        {
            subject = subject_;
            return this;
        }
        public Builder addContent(String content_)
        {
            content = content_;
            return this;
        }
        public Builder addmimeType(String mType_)
        {
            mimeType = mType_;
            return this;
        }
        public Builder addCC(String cc_)
        {
            cc.add(cc_);
            return this;
        }
        public Builder addBCC(String bcc_)
        {
            bcc.add(bcc_);
            return this;
        }
        public EmailMessage build()
        {
            return new EmailMessage(from, to,subject,content,mimeType,cc,bcc);
        }
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void Send(String password)
    {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to.getFirst()));
            message.setSubject("Testing Subject");
            message.setText("MAIL MESSAGE"
                    + "\n\n SPAM");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
