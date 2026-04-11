import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task1 {

    
    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      
        int j = mid + 1;  
        int k = left;      
        long inversions = 0;


        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid + 1 - i);
            }
        }

        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversions;
    }

    
    private static long divideAndMerge(int[] arr, int[] temp, int left, int right) {
        long inversions = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;

            
            inversions += divideAndMerge(arr, temp, left, mid);
            
            inversions += divideAndMerge(arr, temp, mid + 1, right);
            
            inversions += mergeAndCount(arr, temp, left, mid, right);
        }
        
        return inversions;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader & StringTokenizer for fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = br.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;
        
        int n = Integer.parseInt(firstLine.trim());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] temp = new int[n];
        
        
        long totalInversions = divideAndMerge(arr, temp, 0, n - 1);
        
        
        System.out.println(totalInversions);
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}