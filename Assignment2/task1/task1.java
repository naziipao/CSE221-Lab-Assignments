import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class task1 {
    public static int [] stringBreaker(String s1){  //Line1 input
        StringTokenizer st = new StringTokenizer(s1);
        int [] arr = new int[2];
        int i = 0;
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            arr[i] = Integer.parseInt(temp);
            i++;
        }
        return arr;
    }

    public static int[] stringBreaker(String s , int[]a){  //Line2 input
        StringTokenizer st = new StringTokenizer(s);
        int length = a[0];
        int [] arr = new int[length];
        int i = 0;
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            arr[i] = Integer.parseInt(temp);
            i++;
        }
        return arr;
    }


    public static String solve(String s1, String s2){  // param : line1 , line2
        StringBuilder sb = new StringBuilder();
        int [] arrLine1 = stringBreaker(s1);
        int [] arrLine2 = stringBreaker(s2 , arrLine1);
        //Main Operation
        int length = arrLine2.length;
        int target = arrLine1[1];

        int left = 0;
        int right = length-1;

        while(left<right){
            int sum = arrLine2[left] + arrLine2[right];

            if(sum == target){
                return sb.append(left+1).append(" ").append(right+1).toString();
            }

            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return sb.append(-1).toString();
    }
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        String line2 = br.readLine();
        String ans = solve(line1,line2);
        wr.println(ans);
        wr.flush();
    }
    
}
