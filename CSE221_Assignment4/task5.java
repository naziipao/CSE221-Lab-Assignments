import java.io.*;
import java.util.*;

public class task5 {
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

        int [] indegree = new int[v+1];
        int [] outdegree = new int[v+1];

        for(int i = 1; i<=e ; i++){
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            indegree[end]++;
            outdegree[start]++;
        }

        
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<=v ; i++){
            int res = indegree[i] - outdegree[i];
            sb.append(res).append(" ");
        }

        wr.println(sb.toString());

        wr.close();
    }
}
