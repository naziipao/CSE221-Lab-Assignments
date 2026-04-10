import java.io.*;
import java.util.*;

public class task4 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int v = Integer.parseInt(st1.nextToken());
        int num_of_edges = Integer.parseInt(st1.nextToken());

        int [] degree_of_nodes = new int[v+1];
        String line2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        String line3 = br.readLine();
        StringTokenizer st3 = new StringTokenizer(line3);
        for(int i = 1; i<=num_of_edges ; i++){
            int start_node = Integer.parseInt(st2.nextToken());
            int end_node = Integer.parseInt(st3.nextToken());
            degree_of_nodes[start_node]++;
            degree_of_nodes[end_node]++;
        }

        //Answer checking
        int num_of_odd_degree = 0;
        for(int i = 0; i<degree_of_nodes.length; i++){
            if(degree_of_nodes[i]%2!=0){
                num_of_odd_degree++;
            }
        }

        if(num_of_odd_degree == 2 || num_of_odd_degree == 0){
            wr.println("YES");
        }
        else{
            wr.println("NO");
        }
        
        wr.close();
    }
}
