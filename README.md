
<h1>Architecture & Algorithm Implementation</h1>

<h3>Code Written in 4 Files</h3>
<ul>
  <li><b>Server.java-</b>A remote object is created and binded to rmi registery</li>
  <li><b>Client.java-</b>Requests the remote objects on the server and invokes its methods</li>
  <li><b>RmiInterface.java-</b>Defines Remote Interface</li>
  <li><b>GraphUtils.java-</b>Contains implementation for add_graph,add_edge,get_mst(implemented using kruskal's algorithm)</li>
</ul>

<hr>

<h1>Results</h1>

## Sample Test Case-1
>add_graph 12 5<br>
add_edge 12 1 2 100<br>
get_mst 12<br>
<b>-1</b><br>
add_edge 12 2 3 50<br>
add_edge 12 3 4 40<br>
add_edge 12 3 5 30<br>
add_edge 12 4 5 1000<br>
get_mst 12<br>
<b>220</b><br>
add_edge 12 2 5 1<br>
get_mst 12<br>
<b>171</b><br>

## Sample Test Case-2
>add_graph 12345 2<br>
add_edge 12345 1 1 10<br>
add_edge 12345 2 2 1<br>
add_edge 12345 1 2 4<br>
add_edge 12345 2 1 30<br>
add_edge 12345 1 2 2<br>
get_mst 12345<br>
<b>2</b>