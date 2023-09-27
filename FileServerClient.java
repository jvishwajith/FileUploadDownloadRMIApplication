import java.rmi.Naming;
import java.util.Scanner;

public class FileServerClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Lookup the remote object by name
            FileServer fileServer = (FileServer) Naming.lookup("//localhost/FileServer");

            if (fileServer.isSubmissionCompleted()) {
                System.out.println("Application form submissions have been completed.");
            } else {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                System.out.print("Enter your job profile: ");
                String jobProfile = scanner.nextLine();

                // Submit the form to the server
                boolean submissionResult = fileServer.submitForm(name, email, jobProfile);

                if (submissionResult) {
                    System.out.println("Form submitted successfully.");
                } else {
                    System.out.println("Form submission failed. Application forms submissions have been completed.");
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        } finally {
            // Close the scanner to prevent resource leak
            scanner.close();
        }
    }
}
