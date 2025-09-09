import java.util.ArrayList;
import java.util.List;

public abstract class DocumentSubject {
    private List<DocumentObserver> observers = new ArrayList<>();

    public void addObserver(DocumentObserver observer) { observers.add(observer); }
    public void removeObserver(DocumentObserver observer) { observers.remove(observer); }

    protected void notifyObservers(DocumentJob job, String statusMessage) {
        for (DocumentObserver observer : observers) { observer.update(job, statusMessage); }
    }
}
