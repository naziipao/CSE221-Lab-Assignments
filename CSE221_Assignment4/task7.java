import java.io.*;
import java.util.*;

public class task7 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        boolean [][] mat = new boolean [N+1][M+1];
        ArrayList<int[]> list = new ArrayList<>(); //For saving the coordinates of the Knights
        for(int i = 0; i<K; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            mat[row][col] = true;
            list.add(new int[] {row,col});
        }

        int [] direction_x = {-2, -2, -1, -1,  1, 1,  2, 2};
        int [] direction_y = {-1,  1, -2,  2, -2, 2, -1, 1};

        for(int i = 0; i<K; i++){
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            for(int j = 0; j<8; j++){
                int curr_x = x + direction_x[j];
                int curr_y = y + direction_y[j];

                if(curr_x>=1 && curr_x<=N && curr_y>=1 && curr_y<=M){
                    if(mat[curr_x][curr_y] == true){
                        wr.println("YES");
                        wr.close();
                        return;
                    }
                }
            }
        }
        wr.println("NO");
        wr.close();
    }
}