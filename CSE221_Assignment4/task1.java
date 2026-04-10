import java.io.*;
import java.util.*;
public class task1{
    public static void main(String [] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);
        //Finding the number of vertices of the graph from the first line
        int v = Integer.parseInt(st.nextToken());
        //Finding the number of edges
        int e = Integer.parseInt(st.nextToken());

        int [][] adj_mat = new int[v][v];
        
        for(int i = 0; i<e; i++){  // the loop will run till all the given vertices ends.
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            adj_mat[row][col] = weight;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<v ; i++){
            for(int j = 0; j<v ; j++){
                sb.append(adj_mat[i][j]).append(" ");
            }
            sb.append("\n");
        }
        wr.println(sb.toString());
        wr.close();
    }
}