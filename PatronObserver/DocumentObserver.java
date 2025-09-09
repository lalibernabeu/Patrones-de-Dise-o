public interface DocumentObserver {
    void update(DocumentJob job, String statusMessage);
}