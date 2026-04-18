import java.io.*;
import java.util.*;

public class task7 {

    public static boolean solution(ArrayList<ArrayList<Integer>> graph, int curr_node, boolean[] visited, boolean[] path){
        visited[curr_node] = true;
        path[curr_node] = true;
        ArrayList<Integer> list = graph.get(curr_node);
        for(int i = 0; i<list.size(); i++){
            int neighbor = list.get(i);
            if(!visited[neighbor]){
                if(solution(graph, neighbor, visited, path)){
                    return true;
                }
            }
            else if(path[neighbor]){
                    return true;
            }
        }
        path[curr_node] = false;
        return false;
    }
     public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int vertice = Integer.parseInt(st1.nextToken());
        int edge = Integer.parseInt(st1.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //creating vertices:
        for(int i =0; i<=vertice; i++){
            graph.add(new ArrayList<>());
        }

        //Creating edges:
        for(int i = 0; i<edge; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }
        boolean[] visited = new boolean[vertice+1];
        boolean[] path = new boolean[vertice+1];
        boolean ans = false;

        for(int i = 0; i<=vertice; i++){  //Check every single node whether it contains any cycle or not
            int curr_node = i;
            if(!visited[curr_node]){
                if(solution(graph,curr_node, visited, path)){
                    ans = true;
                    break;
                }
            }
        }

        if(ans){
            wr.println("YES");
        }
        else{
            wr.println("NO");
        }
        wr.close();
    }
}
