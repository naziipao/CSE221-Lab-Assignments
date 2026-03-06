import java.io.*;
import java.util.*;
public class task5{

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

    public static String solve(int []arr, int num){
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int maxLen = 0;
        int sum = 0;
        for(int right = 0; right<arr.length; right++){
            sum += arr[right];

            while(sum> num && left<=right){
                sum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen , right-left+1);
        }
        return sb.append(maxLen).toString();
    } 

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        String line2 = br.readLine();
        int arr1[] = stringBreaker(line1 , 2);
        int arr[] = stringBreaker(line2, arr1[0]);
        int target = arr1[1];
        wr.println(solve(arr,target));
        wr.flush();
    }
}