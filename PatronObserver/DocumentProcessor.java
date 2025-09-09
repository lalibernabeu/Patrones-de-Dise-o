import java.io.File;
import java.util.UUID;

public class DocumentProcessor extends DocumentSubject {

    private ConfigurationManager configManager = new ConfigurationManager();
    private SystemLog log = new SystemLog();
    private LegacyArchiver archiver = new LegacyArchiver();

    public void processDocument(DocumentJob job) {
        log.info("Iniciando procesamiento del trabajo...");

        if (job.getRequestingUser() == null) {
            log.error("Error: Usuario no especificado.");
            notifyObservers(job, "Error: Usuario no especificado.");
            return;
        }

        File file = new File(job.getSourceFilePath());
        // Para testeo temporal, comentar esta línea si no hay archivo real
        // if (!file.exists()) { log.error("Error: El archivo no existe."); notifyObservers(job,"Error"); return; }

        if (file.length() > configManager.getMaxFileSize()) {
            log.error("Error: Archivo demasiado grande.");
            notifyObservers(job, "Error: Archivo demasiado grande.");
            return;
        }

        if (job.isHighPriority() && !job.getRequestingUser().getPlan().equals("Premium")) {
            log.error("Error: Solo usuarios Premium pueden usar alta prioridad.");
            notifyObservers(job, "Error: Solo usuarios Premium pueden usar alta prioridad.");
            return;
        }

        byte[] convertedFile;
        switch (job.getOutputFormat()) {
            case "PDF": convertedFile = new byte[100]; break;
            case "DOCX": convertedFile = new byte[120]; break;
            default: convertedFile = new byte[50]; break;
        }

        archiver.save(convertedFile, "archive/" + UUID.randomUUID().toString());

        notifyObservers(job, "Procesamiento completado correctamente.");

        Command billingCommand = new BillingCommand(job.getRequestingUser(), job.getOutputFormat());
        billingCommand.execute();

        log.info("Trabajo finalizado.");
    }
}
