import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  
import java.util.*;

public class Client {  
   public static void main(String[] args) {  
      try {  
         Registry registry = LocateRegistry.getRegistry(args[0],Integer.parseInt(args[1]));
      
         RmiInterface stub = (RmiInterface) registry.lookup("GraphMst"); 
      
         Scanner sc = new Scanner(System.in);
         while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] inputs =  s.split(" ",-2);
            if(inputs[0].equals("add_graph")){
               String graph_id=inputs[1];
               int num_nodes = Integer.parseInt(inputs[2]);
               stub.addGraph(graph_id, num_nodes);
            }
            else if(inputs[0].equals("add_edge")){
               String graph_id = inputs[1];
               int u = Integer.parseInt(inputs[2]);
               int v = Integer.parseInt(inputs[3]);
               int w = Integer.parseInt(inputs[4]);
               stub.addEdge(graph_id,u,v,w);
            }
            else {
               String graph_id = inputs[1];
               System.out.println(stub.kruskal(graph_id));
            }
         }
         sc.close();
      } catch (Exception e) {
         System.out.println("Error"+ e.toString());
      } 
   } 
}