public class SlackNotifier implements DocumentObserver {
    @Override
    public void update(DocumentJob job, String statusMessage) {
        System.out.println("[Slack] Usuario " + job.getRequestingUser().getUsername() + " - " + statusMessage);
    }
}
