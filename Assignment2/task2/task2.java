import java.io.*;
import java.util.*;
public class task2 {
    public static int[] stringBreaker(String s, int num){
        StringTokenizer st = new StringTokenizer(s);
        int [] arr = new int[num];
        int i = 0;
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            arr[i] = Integer.parseInt(temp);
            i++;
        }
        return arr;
    }
    public static String solve(String line1, String line2, String line3){
        StringBuilder sb = new StringBuilder();
        int [] arr1 = stringBreaker(line1,3);
        int [] arr2 = stringBreaker(line2, arr1[0]); //Array-1 
        int [] arr3 = stringBreaker(line3, arr1[1]); //Array-2
        int target = arr1[2];

        int left = 0;
        int right = arr3.length-1;
        int minDiff = Integer.MAX_VALUE;
        int bestLeft = 0;
        int bestRight = 0;

        while(left < arr2.length && right >=0){
            int sum = arr2[left] + arr3[right];
            int currDiff = Math.abs(sum-target);

            if(currDiff<minDiff){ //updating minimum difference
                minDiff = currDiff;
                bestLeft = left;
                bestRight = right;
            }

            if(sum<target){  //Steer to left
                left++;
            }
            else if(sum > target){  //Steer to right
                right--;
            }

            else{  //Sum is equal
                sb.append(left+1).append(" ").append(right+1);
                return sb.toString();
            }
        }
        return sb.append(bestLeft+1).append(" ").append(bestRight +1).toString();
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