package Exercise5Package;

import java.util.LinkedList;


public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional


    protected EmailMessage(  String from,
                          LinkedList<String> to,
                          String subject,
                          String content,
                          String mimeType,
                          LinkedList<String> cc,
                          LinkedList<String> bcc){}

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

    public void Sent()
    {

    }
}
