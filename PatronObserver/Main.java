public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Laura");
        user.setPlan("Premium");

        DocumentJob job = new DocumentJob("archivo.txt", "PDF", null, true, user);

        DocumentProcessor processor = new DocumentProcessor();
        processor.addObserver(new SlackNotifier());
        processor.addObserver(new EmailNotifier());

        processor.processDocument(job);
    }
}
