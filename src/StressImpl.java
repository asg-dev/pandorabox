import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import support.*;


public class StressImpl extends java.rmi.server.UnicastRemoteObject implements PandoraStress {
      long cVM=0,fSS=0, pCT=0;
      double score=0;
      double pCL=0;
    // Implementations must have an
    //explicit constructor
    // in order to declare the
    //RemoteException exception
    public StressImpl()
        throws java.rmi.RemoteException {
        super();
    }

    public double stressCall() throws java.rmi.RemoteException {
          try {
/*            SystemInfo si=new SystemInfo();
            HardwareAbstractionLayer hal = si.getHardware();
            Sensors sense=hal.getSensors(); */

            ArgumentsMapper argumentsMapper = new ArgumentsMapper();
            Arguments arguments = argumentsMapper.map();
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();


            System.out.println("Test started with " + arguments.getThreads() + " threads and " + arguments.getIterations() + " iterations");
            PiStresser stresser = new PiStresser(arguments.getThreads(), arguments.getIterations());


            long startTime = System.currentTimeMillis();
            stresser.start();
            long tookTime = System.currentTimeMillis() - startTime;

          /*  long cTimeActual = NumberFormat.getNumberInstance().format(tookTime); */

            System.out.println("Test finished in " + NumberFormat.getNumberInstance().format(tookTime) + " ms");

            for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().startsWith("get") && Modifier.isPublic(method.getModifiers())) {
                    Object value;
                    try { value = method.invoke(operatingSystemMXBean); }
                    catch (Exception e) { value = e; }
                    if(method.getName().equals("getCommittedVirtualMemorySize"))
                    cVM = (long) value/1000;
                    if(method.getName().equals("getFreeSwapSpaceSize"))
                    fSS = (long) value/1000;
                    if(method.getName().equals("getProcessCpuLoad"))
                    pCL = (double) value;
                    if(method.getName().equals("getProcessCpuTime"))
                    pCT = (long) value;
                    }


                }
                score = tookTime + cVM + fSS + pCL + pCT;
/*              System.out.println("Cpu Temperature" + sense.getCpuTemperature()); */

             }
             catch(Exception e) { }

             return score;
    }
}
