public class FloydWarshall {
 final static int INF = 99999; // Represents infinity
 final static int V = 4; // Number of vertices
 void floydWarshall(int[][] graph) {
 int[][] dist = new int[V][V];
 // Initialize the solution matrix the same as input graph matrix
 for (int i = 0; i < V; i++)
 for (int j = 0; j < V; j++)
 dist[i][j] = graph[i][j];
 // Add all vertices one by one to the set of intermediate vertices
 for (int k = 0; k < V; k++) {
 for (int i = 0; i < V; i++) {
 for (int j = 0; j < V; j++) {
 if (dist[i][j] > dist[i][k] + dist[k][j] && dist[k][j] != INF && dist[i][k] != INF)
 dist[i][j] = dist[i][k] + dist[k][j];
 }
 }
 }
 printSolution(dist);
 }
 void printSolution(int[][] dist) {
 System.out.println("The following matrix shows the shortest distances between 
every pair of vertices:");
 for (int i = 0; i < V; i++) {
 for (int j = 0; j < V; j++) {
 if (dist[i][j] == INF)
 System.out.print("INF ");
 else
 System.out.print(dist[i][j] + " ");
 }
 System.out.println();
 }
 }
 public static void main(String[] args) {
 FloydWarshall fw = new FloydWarshall();
 int[][] graph = { 
 { 0, 5, INF, 10 },
 { INF, 0, 3, INF },
 { INF, INF, 0, 1 },
 { INF, INF, INF, 0 }
 };
 fw.floydWarshall(graph);
 }
}
