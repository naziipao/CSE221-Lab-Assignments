import java.io.*;
import java.util.*;
public class task1{

    public static int[] bfs(ArrayList<ArrayList<Integer>> list , int node){
        boolean [] visited = new boolean[node+1];
        Queue<Integer> q = new LinkedList<>(); 
        int [] res = new int[node];
        int resCount = 0;
        q.add(1);
        visited[1] = true; 
        while(!q.isEmpty()){
            int curr_Node = q.remove();
            res[resCount] = curr_Node;
            resCount++;
            ArrayList<Integer> l = list.get(curr_Node);
            for(int i = 0; i<l.size(); i++){
                int neighbor = l.get(i);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return res;
    }

    public static void main(String [] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       PrintWriter wr = new PrintWriter(System.out);
       String line1 = br.readLine();
       StringTokenizer st1 = new StringTokenizer(line1);
       int vertice = Integer.parseInt(st1.nextToken());
       int edge = Integer.parseInt(st1.nextToken());
       ArrayList<ArrayList<Integer>> list = new ArrayList<>();

       //Adding the nodes
       for(int i = 0; i<= vertice; i++){
        list.add(new ArrayList<>());
       }
       //Adding edges to the nodes
       for(int i = 0; i<edge; i++){
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        list.get(start).add(end);
        list.get(end).add(start);
       }
       int [] result = bfs(list, vertice);
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i<result.length; i++){
        sb.append(result[i]).append(" ");
       }
       wr.println(sb.toString());

       wr.close();
    }
}