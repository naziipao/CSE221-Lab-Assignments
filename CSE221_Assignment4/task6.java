import java.io.*;
import java.util.*;
public class task6 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        int N = Integer.parseInt(st1.nextToken());
        String line2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2);
        int x = Integer.parseInt(st2.nextToken());
        int y = Integer.parseInt(st2.nextToken());


        // Direction Sequence: Up-Left, Up, Up-Right, Left, Right, Down-Left, Down, Down-Right --> This squence is already sorted
        int [] direction_x = {-1,-1,-1,0,0,1,1,1};
        int [] direction_y = {-1,0,1,-1,1,-1,0,1};

        ArrayList<int[]> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i<8 ; i++){
            int curr_x = x + direction_x[i];
            int curr_y = y + direction_y[i];

            if(curr_x>=1 && curr_x<=N && curr_y>=1 && curr_y<=N){
                list.add( new int[] {curr_x, curr_y});
                count++;
            }
        }

        wr.println(count);  //Total number of steps

        //Printing the List
       
        for(int i = 0; i<list.size(); i++){
            int [] move = list.get(i);
            wr.println(move[0] + " " + move[1]);
        }

        wr.close();
    }
}
