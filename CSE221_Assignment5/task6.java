import java.io.*;
import java.util.*;
public class task6 {
    public static void solution(ArrayList<ArrayList<Integer>> graph, int curr_node, boolean [] visited, int [] subtree){
        visited[curr_node] = true;
        subtree[curr_node] = 1;
        
        ArrayList<Integer> list = graph.get(curr_node);

        for(int i = 0; i<list.size(); i++){
            int neighbor = list.get(i);
            if(!visited[neighbor]){
                solution(graph, neighbor, visited, subtree);
                subtree[curr_node] += subtree[neighbor];
            }
        }
    }


    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int node = Integer.parseInt(st1.nextToken());
        int root = Integer.parseInt(st1.nextToken());
        int edge = node -1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //Creating nodes
        for(int i =0; i<=node; i++){
            graph.add(new ArrayList<>());
        }

        //Creating edges
        for(int i =0; i<edge; i++){
            String line2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(line2);
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        boolean [] visited = new boolean[node+1];
        int [] subtree = new int[node+1];

        solution(graph, root, visited, subtree);

        String line3 = br.readLine();
        int query = Integer.parseInt(line3);

        for(int i = 0; i<query; i++){
            String line4 = br.readLine();
            int x = Integer.parseInt(line4);
            wr.println(subtree[x]);
        }
        wr.close();
    }
}
