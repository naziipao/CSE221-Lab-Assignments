import java.io.*;
import java.util.*;
public class task4 {
    public static ArrayList<Integer> solution(ArrayList<ArrayList<Integer>> list, int vertice, int source, int destination){

        boolean [] visited = new boolean[vertice+1];
        int [] parent = new int[vertice+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) { 
            int curr_node = q.remove();
            if(curr_node == destination){
                break;
            }
            ArrayList<Integer> l = list.get(curr_node);
            for(int i = 0; i<l.size(); i++){
                int neighbor = l.get(i);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    parent[neighbor] = curr_node;
                    q.add(neighbor);
                }
            }
        }

        ArrayList<Integer> way = new ArrayList<>();
        int index = destination;
        while(index != 0){
            way.add(index);
            if(index == source){
                break;
            }
            index = parent[index];
        }

        ArrayList<Integer> new_way = new ArrayList<>();
        for(int i = way.size()-1; i>=0; i--){
            new_way.add(way.get(i));
        }
        return new_way;
    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int vertice = Integer.parseInt(st1.nextToken());
        int edge = Integer.parseInt(st1.nextToken());
        int source = Integer.parseInt(st1.nextToken());
        int destination = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //Creating nodes
        for(int i = 0; i<=vertice; i++){
            list.add(new ArrayList<>());
        }

        //Connecting edges
        for(int i = 0; i<edge; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
        }

        ArrayList<Integer> left = solution(list, vertice, source,k);
        ArrayList<Integer> right = solution(list, vertice, k,destination);

        if((left.size() == 1 && source != k) || (right.size() == 1 && k != destination)){
            wr.print(-1);
        }
        else{
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i<left.size()-1; i++){
                ans.add(left.get(i));
            }
            for(int i = 0; i<right.size(); i++){
                ans.add(right.get(i));
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<ans.size(); i++){
                sb.append(ans.get(i)).append(" ");
            }
            wr.println(ans.size() - 1);
            wr.println(sb.toString());
        }
        wr.close();

    }
    
}
