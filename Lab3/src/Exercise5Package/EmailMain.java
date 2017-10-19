package Exercise5Package;

public class EmailMain {
    public static void  main(String[] arg)
    {
        EmailMessage message = EmailMessage.builder()
                .addFrom("japalka@student.agh.edu.pl")
                .addTo("kubas11513@gmail.com")
                .addSubject("Testowy mail JAVA")
                .addContent("To jest mój content.")
                .build();

        message.Sent();
    }
}
