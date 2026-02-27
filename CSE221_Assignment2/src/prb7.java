import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class prb7 {
    public static int lowerBound(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int ans = arr.length;
        while (left<=right) { 
            int mid = left + (right-left)/2;
            if (arr[mid]>=num) {
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    public static int upperBound(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int ans = arr.length;
        while (left<=right) { 
            int mid = left + (right-left)/2;
            if (arr[mid]>num) {  // mid element is bigger than target element so move the right pointer to the left 
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter write = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        String inputString = reader.readLine().trim();  // First line input
        String [] arr = inputString.split(" ");
        int n = Integer.parseInt(arr[0]); // Length of the array
        int q = Integer.parseInt(arr[1]); // Number of query
        String secondLine = reader.readLine().trim();  // Second line input
        String [] secondLineInput = secondLine.split(" ");
        int [] inputArr = new int[n];
        for (int i = 0 ; i<n; i++){
            inputArr[i] = Integer.parseInt(secondLineInput[i]);  // Input Array Created
        }
        //Query Input:
        for (int i = 0; i<q; i++){
            String queryString = reader.readLine().trim();
            StringTokenizer st = new StringTokenizer(queryString);
            int q1 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());
            int diff = upperBound(inputArr, q2) - lowerBound(inputArr, q1);
            sb.append(diff).append("\n");
        }
        write.print(sb);
        write.close();
    }
    
}
