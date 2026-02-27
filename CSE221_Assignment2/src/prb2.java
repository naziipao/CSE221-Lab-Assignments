import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class rough {

    public static int[] stringBreaker(String s, int num){
        StringTokenizer st = new StringTokenizer(s);
        String [] arrStr = new String[num];
        int [] arrInt = new int[num];
        int i = 0;
        while(st.hasMoreTokens()){
            arrStr[i] = st.nextToken();
            arrInt[i] = Integer.parseInt(arrStr[i]);
            i++;
        }
        return arrInt;
    }

    public static String solve(String s1, String s2, String s3){
        StringBuilder sb = new StringBuilder();
        int [] arrLine1 = stringBreaker(s1,3);
        int [] arr1 = stringBreaker(s2,arrLine1[0]);
        int [] arr2 = stringBreaker(s3,arrLine1[1]);
        int target = arrLine1[2];

        //Main Operation:
        int left = 0;
        int right = arr2.length-1;
        int minDiff = Integer.MAX_VALUE;
        int best_left = 0;
        int best_right = 0;
        while(left<arr1.length && right>=0){
            int sum = arr1[left] + arr2[right];
            int currDiff = sum-target;

            if(minDiff>Math.abs(currDiff)){
                minDiff = Math.abs(currDiff);
                best_left = left;
                best_right = right;
            }

            if(sum<target){
                left++;
            }
            else if(sum>target){
                right--;
            }
            else{ 
                sb.append(left+1).append(" ").append(right+1);
                return sb.toString();
            }
        }
        sb.append(best_left+1).append(" ").append(best_right+1);
        return sb.toString();
    }
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();
            wr.println(solve(line1,line2,line3));
        

        wr.flush();
    }
}
