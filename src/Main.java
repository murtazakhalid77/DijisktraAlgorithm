import java.io.BufferedWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many vertices you want?: ");
        Scanner sc = new Scanner(System.in);
                int n= sc.nextInt(); // Number of vertices user want
                int[][] adjacencyMatrix = new int[n][n];
                Random rand = new Random();

                // Generate random edges
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(i!=j){
                            int randomNum = rand.nextInt(5);
                            adjacencyMatrix[i][j] = randomNum;
                        }
                    }   //this loop will create random edges
                 }   //it will create an exception if it enters a negative random number
                     //so just run it again


                // Print the adjacency matrix
        System.out.println("\nThe adjacancy matrix for Undirected Graph is ");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(adjacencyMatrix[i][j] + " ");
                    }
                    System.out.println();
                }


        Dijkstra dijkstra = new Dijkstra(); //calling the dijisktra by using object
        long  a=System.currentTimeMillis(); //using nano time before calling the function
        System.out.println("\n\nTime in milli second before "+a);
        dijkstra.dijkstra(adjacencyMatrix, 0); //calling the methode by sending adjacency matrix as param
        long  b=System.currentTimeMillis();//using nano time after calling the function
        System.out.println("\n\nTime in milli second after "+b);
        System.out.println("\nThe total time taken is "+(b-a)+"Millisecond"); //the total time taken



        int[][] adjacencyMatrixDirected = new int[n][n];
        Random rand2 = new Random();

// Generate random edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {  // Don't allow self-loops
                    int randomNum = rand2.nextInt(5);
                    adjacencyMatrixDirected[i][j] = randomNum;
                }
            }
        }
        System.out.println("\nThe adjacancy matrix for directed Graph is ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrixDirected[i][j] + " ");
            }
            System.out.println();
        }

        long  a1=System.currentTimeMillis(); //using nano time before calling the function
        System.out.println("\n\nTime in milli second before "+a1);
        dijkstra.dijkstra(adjacencyMatrixDirected, 0); //calling the methode by sending adjacency matrix as param
        long  b2=System.currentTimeMillis();//using nano time after calling the function
        System.out.println("\nTime in milli second after "+b2);
        System.out.println("\nThe total time taken is "+(b2-a1)+"Millisecond"); //the total time taken
            }



    }






