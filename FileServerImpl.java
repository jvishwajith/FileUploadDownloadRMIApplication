import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;

public class FileServerImpl extends UnicastRemoteObject implements FileServer {
    private AtomicInteger submissionCount = new AtomicInteger(0);
    private int maxSubmissions = 3; // Maximum number of form submissions allowed

    public FileServerImpl() throws RemoteException {
        super();
    }

    public boolean submitForm(String name, String email, String jobProfile) throws RemoteException {
        int currentSubmissionCount = submissionCount.incrementAndGet();

        if (currentSubmissionCount <= maxSubmissions) {
            // Store or process the form data as needed
            System.out.println("Form submitted successfully for client " + currentSubmissionCount);
            return true;
        } else {
            System.out.println("Application form submissions have been completed.");
            return false;
        }
    }

    public boolean isSubmissionCompleted() throws RemoteException {
        return submissionCount.get() >= maxSubmissions;
    }
}
