import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FileServerServer {
    public static void main(String[] args) {
        try {
            // Create and export the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create an instance of the server implementation
            FileServer fileServer = new FileServerImpl();

            // Bind the remote object to the registry with a name "FileServer"
            Naming.rebind("FileServer", fileServer);

            System.out.println("Form submission server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
