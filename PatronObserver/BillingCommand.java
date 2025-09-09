public class BillingCommand implements Command {
    private User user;
    private String format;

    public BillingCommand(User user, String format) { this.user = user; this.format = format; }

    @Override
    public void execute() {
        System.out.println("[Billing] Facturación registrada para usuario: " + user.getUsername() + " por documento en formato " + format);
    }
}
