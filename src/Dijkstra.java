import java.util.Random;

public class Dijkstra {
    public static void dijkstra(int[][] adjacencyMatrix, int start) {

        int cnt = adjacencyMatrix.length; //getting the length of adjacency matrix
        boolean[] visitedNode = new boolean[cnt]; //making a boolean array for visited and non visited nodes
        int[] distance = new int[cnt]; //an array for a distances
        for (int i = 0; i < cnt; i++) {
            visitedNode[i] = false;        //this for loop is initlizing Infinity distance
            distance[i] = Integer.MAX_VALUE;  //as we dont know the distances from source to others
        }

        distance[start] = 0;  // Distance of source to source is 0
        for (int i = 0; i < cnt; i++) {  //working for each node
            int u = findMinDistance(distance, visitedNode); //this findMinDistance func is finding the next minimum node
            visitedNode[u] = true; //intilizing the visited array for that node as visited node


            for (int v = 0; v < cnt; v++) { //now updating the shortest distance to each node from the u visited node
                if (!visitedNode[v] && adjacencyMatrix[u][v] != 0 && (distance[u] + adjacencyMatrix[u][v] < distance[v])) {
                    distance[v] = distance[u] + adjacencyMatrix[u][v];
                }
            }
        }
        //printing the results
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance from "+start+" to "+i+" is "+distance[i]);

        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
}
