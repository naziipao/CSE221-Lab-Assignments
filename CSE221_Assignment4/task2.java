import java.io.*;
import java.util.*;
public class task2 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int v = Integer.parseInt(st1.nextToken());
        int e = Integer.parseInt(st1.nextToken());
        String line2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        String line3 = br.readLine();
        StringTokenizer st3 = new StringTokenizer(line3);
        String line4 = br.readLine();
        StringTokenizer st4 = new StringTokenizer(line4);

        //Creating the StringBuilder array
        StringBuilder [] adjList = new StringBuilder[v];
        for(int i = 0; i<v ; i++){
            adjList[i] = new StringBuilder();
            adjList[i].append((i+1)).append(": ");
        }

        for(int i = 1; i<=e; i++){
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            int weight = Integer.parseInt(st4.nextToken());
            adjList[start-1].append("(").append(end).append(",").append(weight).append(")");
        }

        //Printing the list
        for(int i = 0; i<v ; i++){
            wr.println(adjList[i]);
        }

        wr.close();
    }
}
