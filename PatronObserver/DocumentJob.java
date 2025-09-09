public class DocumentJob {
    private String sourceFilePath;
    private String outputFormat;
    private boolean highPriority;
    private String userEmail;
    private User requestingUser;

    public DocumentJob(String source, String format, boolean priority, User user) {
        this.sourceFilePath = source;
        this.outputFormat = format;
        this.highPriority = priority;
        this.requestingUser = user;
        this.userEmail = user.getUsername() + "@example.com";
    }

    public String getSourceFilePath() { return sourceFilePath; }
    public String getOutputFormat() { return outputFormat; }
    public boolean isHighPriority() { return highPriority; }
    public String getUserEmail() { return userEmail; }
    public User getRequestingUser() { return requestingUser; }
}

