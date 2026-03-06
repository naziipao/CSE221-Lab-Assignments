import java.io.*;
import java.util.*;
public class task3 {

    public static int[] stringBreaker(String s, int num) {
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[num];
        int i = 0;
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            arr[i] = Integer.parseInt(temp);
            i++;
        }
        return arr;
    }

    public String solve(int [] a, int num){
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);




        wr.flush();
    }
}
