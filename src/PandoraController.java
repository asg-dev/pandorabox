import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class PandoraController {

    public static void main(String[] args) {
        try {
            // Looking up RMI registry
            PandoraStress c = (PandoraStress) Naming.lookup("rmi://localhost/StressService");
            System.out.println(c.stressCall());
        }
        catch (Exception e) {
        }
    }
}
