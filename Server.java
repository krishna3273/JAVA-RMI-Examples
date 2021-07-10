import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject;

public class Server { 
   public static void main(String args[]) { 
      try { 
         GraphUtils obj = new GraphUtils();
    
         RmiInterface stub = (RmiInterface) UnicastRemoteObject.exportObject(obj, 0);  
         
         Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[0]));
         
         registry.bind("GraphMst", stub);  
      } catch (Exception e) { 
         System.err.println("Error" + e.toString()); 
      }
   } 
} 