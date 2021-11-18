import java.rmi.Naming;

public class PandoraClient {

   public PandoraClient() {
     try {
        
       PandoraStress c = new StressImpl();
       
       Naming.rebind("rmi://localhost:1098/StressService", c);
     } catch (Exception e) {
       System.out.println("Trouble: " + e);
     }
   }

   public static void main(String args[]) {
     new PandoraClient();
   }
}