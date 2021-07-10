import java.util.*;


class edge{
   int u;
   int v;
   int w;

   edge(int u, int v, int w){
      this.u = u;
      this.v = v;
      this.w = w;
   }
}

class customSort implements Comparator<edge> {
   @Override
   public int compare(edge e1, edge e2) { 
      return e1.w - e2.w; 
   } 
}

public class GraphUtils implements RmiInterface { 

   int MAX_NODES=100000;

   Map<String, Map.Entry<Integer,List<edge>>> graphs= new HashMap<String,  Map.Entry<Integer,List<edge>>>(); 

   public void addGraph(String graph_id, int num_nodes){
      graphs.put(graph_id, new AbstractMap.SimpleEntry<Integer,List<edge>>(num_nodes,new ArrayList<edge>()));
   }

   public void addEdge(String graph_id, int u, int v, int w){
      edge e=new edge(u,v,w);
      graphs.get(graph_id).getValue().add(e);
   }
      

   static int find(int parent[],int u){
      if(parent[u]==u) return u;
      else return find(parent, parent[u]);
   }

   static void union(int parent[], int u, int v){
       parent[find(parent, u)] = find(parent, v);
   }

   public int kruskal(String graph_id){
      int parent[] = new int[MAX_NODES];
      int cost=0;
      int edges_included = 0;


      ArrayList<edge> edges = (ArrayList<edge>) graphs.get(graph_id).getValue();
      Collections.sort(edges,new customSort());
      int e = edges.size();
      int v = graphs.get(graph_id).getKey();

      
      for(int i=0;i<v;i++) parent[i] = i;
      
      for(int i=0;i<e;i++){
         int v1 = edges.get(i).u;
         int v2 = edges.get(i).v;
         if(find(parent,v1)!=find(parent,v2)){
            union(parent, v1, v2);
            edges_included+=1;
            cost += edges.get(i).w;;
         }
         if(edges_included==v-1) return cost;
      }
      return -1;
   } 
}

 