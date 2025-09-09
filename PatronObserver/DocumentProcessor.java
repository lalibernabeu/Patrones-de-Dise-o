import java.io.File;
import java.util.UUID;

public class DocumentProcessor extends DocumentSubject {
    private LegacyArchiver archiver = new LegacyArchiver();

    public void processDocument(DocumentJob job) {
        if (job.getRequestingUser() == null) {
            notifyObservers(job, "Error: Usuario no especificado.");
            return;
        }

        File file = new File(job.getSourceFilePath());
        if (!file.exists()) {
            notifyObservers(job, "Error: El archivo no existe.");
            return;
        }

        byte[] convertedFile;
        switch (job.getOutputFormat()) {
            case "PDF":
                convertedFile = new byte[100];
                break;
            case "DOCX":
                convertedFile = new byte[120];
                break;
            default:
                convertedFile = new byte[50];
        }

        archiver.save(convertedFile, "archive/" + UUID.randomUUID().toString());
        notifyObservers(job, "Procesamiento completado correctamente.");
    }
}
