public class PushSender extends NotificationSender {

    public PushSender(AuditLog audit) {
        super(audit);
    }

    @Override
    protected void doSend(Notification n) {
        System.out.println("PUSH -> body=" + n.body);
        audit.add("push sent");
    }
}