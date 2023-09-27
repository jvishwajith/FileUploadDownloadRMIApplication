import java.rmi.Remote;
import java.rmi.RemoteException;


public interface FileServer extends Remote {
    boolean submitForm(String name, String email, String jobProfile) throws RemoteException;
    boolean isSubmissionCompleted() throws RemoteException;
}
