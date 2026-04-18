import java.io.*;
import java.util.*;
public class task8 {

    public 


    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char [][] arr = new char[row][col];
        for(int r = 0; r<row; r++){
            String line = br.readLine();
            for(int c = 0; c<col; c++){
                arr[r][c] = line.charAt(c);
            }
        }

        //Iterate through every single cells and initiate bfs if the cell contains . or D and it is unvisited
        boolean [][] visited = new boolean[row][col];
        int max_d = 0; 
        for(int r = 0; r<row; r++){
            for(int c = 0; c<col ; c++){
                if(arr[r][c] != '#' && !visited[r][c]){
                    int curr_d = bfs(arr, visited, r,c,row,col);
                    if(){

                    }
                }
            }
        }

    }
    
}
