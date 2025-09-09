public class EmailNotifier implements DocumentObserver {
    @Override
    public void update(DocumentJob job, String statusMessage) {
        System.out.println("[Email] Enviado a " + job.getUserEmail() + " - " + statusMessage);
    }
}
