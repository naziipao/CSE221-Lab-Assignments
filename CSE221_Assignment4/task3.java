import java.io.*;
import java.util.*;
public class task3 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int v = Integer.parseInt(st1.nextToken());
        int [][] adjMat = new int[v][v];

        for(int i = 0; i<v ; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int num_of_edge = Integer.parseInt(st.nextToken());
            for(int j = 0; j<num_of_edge; j++){
                int e = Integer.parseInt(st.nextToken());
                adjMat[i][e] = 1; 
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<v ; i++){
            for(int j = 0; j<v ; j++){
                sb.append(adjMat[i][j]).append(" ");
            }
            sb.append("\n");
        }
        wr.println(sb.toString());
        wr.close();
    }
}
