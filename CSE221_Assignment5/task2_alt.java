
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class task2_alt {

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[]visited, int curr_node, ArrayList<Integer> res) {
        visited[curr_node] = true;
        res.add(curr_node);
        ArrayList<Integer> list = graph.get(curr_node);
        for (int i = 0; i<list.size(); i++){
            int neighbor = list.get(i);
            if(!visited[neighbor]){
                dfs(graph,visited,neighbor, res);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int vertice = Integer.parseInt(st1.nextToken());
        int edge = Integer.parseInt(st1.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //Adding the nodes
        for (int i = 0; i <= vertice; i++) {
            graph.add(new ArrayList<>());
        }
        String line2 = br.readLine();
        String line3 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        StringTokenizer st3= new StringTokenizer(line3);
        //Adding edges to the nodes
        for (int i = 0; i < edge; i++) {
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        boolean [] visited = new boolean[vertice+1];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(graph, visited, 1, res);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append(" ");
        }
        wr.println(sb.toString());

        wr.close();
    }
}
