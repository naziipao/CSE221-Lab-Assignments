
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class task2 {

    public static int[] dfs(ArrayList<ArrayList<Integer>> list, int total_nodes) {
        boolean[] visited = new boolean[total_nodes+1];
        Stack<Integer> s = new Stack<>();
        int[] res = new int[total_nodes];
        int res_count = 0;
        s.push(1);
        while (!s.isEmpty()) {
            int curr_node = s.pop();
            if (!visited[curr_node]) {
                visited[curr_node] = true;
                res[res_count] = curr_node;
                res_count++;
                ArrayList<Integer> l = list.get(curr_node);
                for (int i = 0; i < l.size(); i++) {
                    int neighbor = l.get(i);
                    if (!visited[neighbor]) {
                        s.push(neighbor);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int vertice = Integer.parseInt(st1.nextToken());
        int edge = Integer.parseInt(st1.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        //Adding the nodes
        for (int i = 0; i <= vertice; i++) {
            list.add(new ArrayList<>());
        }
        String line2 = br.readLine();
        String line3 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        StringTokenizer st3 = new StringTokenizer(line3);
        //Adding edges to the nodes
        for (int i = 0; i < edge; i++) {
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        int[] result = dfs(list, vertice);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        wr.println(sb.toString());

        wr.close();
    }
}
