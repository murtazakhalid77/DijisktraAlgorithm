import java.util.Random;

public class RandomGraphGenerator {

        public static final int MAX_VERTICES = 10;
        public static final int MAX_EDGES = 15;

        public static void main(String[] args) {
            Random rng = new Random();

            // Generate a random directed graph
            int[][] directedGraph = new int[MAX_VERTICES][MAX_VERTICES];
            int numEdges = rng.nextInt(MAX_EDGES + 1);
            for (int i = 0; i < numEdges; i++) {
                int from = rng.nextInt(MAX_VERTICES);
                int to = rng.nextInt(MAX_VERTICES);
                directedGraph[from][to] = 1;
            }

            // Generate a random undirected graph
            int[][] undirectedGraph = new int[MAX_VERTICES][MAX_VERTICES];
            numEdges = rng.nextInt(MAX_EDGES + 1);
            for (int i = 0; i < numEdges; i++) {
                int from = rng.nextInt(MAX_VERTICES);
                int to = rng.nextInt(MAX_VERTICES);
                undirectedGraph[from][to] = 1;
                undirectedGraph[to][from] = 1;
            }


            // Print the directed graph
            System.out.println("Directed graph:");
            for (int i = 0; i < MAX_VERTICES; i++) {
                for (int j = 0; j < MAX_VERTICES; j++) {
                    System.out.print(directedGraph[i][j] + " ");
                }
                System.out.println();
            }

            // Print the undirected graph
            System.out.println("Undirected graph:");
            for (int i = 0; i < MAX_VERTICES; i++) {
                for (int j = 0; j < MAX_VERTICES; j++) {
                    System.out.print(undirectedGraph[i][j] + " ");
                }
                System.out.println();
            }
            Dijkstra dijkstra = new Dijkstra(); //calling the dijisktra by using object
            long  a=System.currentTimeMillis(); //using nano time before calling the function
            System.out.println("\n\nTime in milli second before "+a);
            dijkstra.dijkstra(directedGraph, 0); //calling the methode by sending adjacency matrix as param
            long  b=System.currentTimeMillis();//using nano time after calling the function
            System.out.println("Time in milli second after "+b);
            System.out.println("The total time taken is "+(b-a)+"Millisecond"); //the total time taken

        }
    }
