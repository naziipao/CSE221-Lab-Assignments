import java.io.*;
import java.util.*;
public class task5 {

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int source, int [] tagArr){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        tagArr[source] = source;
        while(!q.isEmpty()){
            int curr_node = q.remove();
            ArrayList<Integer> list = graph.get(curr_node);
            for(int i = 0; i<list.size(); i++){
                int neighbor = list.get(i);
                if(tagArr[neighbor] == 0){
                    tagArr[neighbor] = source;
                    q.add(neighbor);
                }
            }

        }
    }
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int vertice = Integer.parseInt(st1.nextToken());
        int edge = Integer.parseInt(st1.nextToken());
        int queries = Integer.parseInt(st1.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //Creating vertices
        for(int i = 0; i<=vertice; i++){
            graph.add(new ArrayList<>());
        }
        //Creating edges
        for(int i = 0; i<edge; i++){
            String line2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(line2);
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        //Tagging the nodes with an id
        int [] tagArr = new int[vertice+1];
        for(int i = 1; i<=vertice; i++){
            if(tagArr[i] == 0){  //Very important, only run bfs in an unvisited / untagged vertice
                bfs(graph, i, tagArr);
            }
        }

        //Queries input
        for(int i = 0; i<queries; i++){
            String line3 = br.readLine();
            StringTokenizer st3 = new StringTokenizer(line3);
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());
            if(tagArr[x] == tagArr[y]){
                wr.println("YES");
            }
            else{
                wr.println("NO");
            }
        }
        wr.close();
    }
}