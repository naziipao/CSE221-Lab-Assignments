import java.io.*;
import java.util.*;
public class task8 {

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    } 

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int N = Integer.parseInt(st1.nextToken()); //# of nodes
        int Q = Integer.parseInt(st1.nextToken()); //# of queries

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        // Adding empty lists from 0 to N
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i!=j){
                    if(gcd(i,j) == 1){
                        graph.get(i).add(j);
                    }
                }
            }
        }

        
        //Iterating through all queries
        for(int i = 0; i<Q; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(graph.get(x).size()>=k){
                wr.println(graph.get(x).get(k-1));
            }
            else{
                wr.println("-1");
            }
        }
        wr.close();
    }
}