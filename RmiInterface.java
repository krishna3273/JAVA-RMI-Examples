import java.rmi.Remote; 
import java.rmi.RemoteException;  

public interface RmiInterface extends Remote { 
   void addGraph(String graph_id, int num_nodes) throws RemoteException;
   void addEdge(String graph_id, int u, int v, int w) throws RemoteException;
   int kruskal(String graph_id) throws RemoteException;  
}