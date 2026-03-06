
import java.io.*;
import java.util.*;

public class task6 {

    public static int[] stringBreaker(String s, int num) {
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[num]; // Reuse tokenizer
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        return arr;
    }

    public static String solve(int [] a, int k){
        StringBuilder sb = new StringBuilder();
        //Finding the maximum number to create the length of the frequency array
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        int [] freq = new int[max + 1];
        int left = 0;
        int distinct = 0;
        int maxLen = 0;


        for(int right = 0; right <a.length; right++){
            if(freq[a[right]] == 0){
                distinct++;
            }
            freq[a[right]]++;

            while(distinct > k){
                freq[a[left]]--;
                if(freq[a[left]] == 0){
                    distinct--;
                }
                left++;
            }
            maxLen = Math.max(maxLen , right - left +1);
        }
        return sb.append(maxLen).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String line1 = br.readLine();
        String line2 = br.readLine();
        int [] arr1 = stringBreaker(line1 , 2);
        int [] arr2 = stringBreaker(line2 , arr1[0]);
        int k = arr1[1];
        wr.println(solve(arr2,k));
        wr.flush();
    }

}
