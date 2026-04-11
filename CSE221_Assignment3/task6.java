import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class task6 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void getBalancedOrder(int left, int right) {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;
        
        sb.append(arr[mid]).append(" ");
        
        getBalancedOrder(left, mid - 1);
        getBalancedOrder(mid + 1, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String nStr = br.readLine();
        if (nStr == null || nStr.trim().isEmpty()) {
            return;
        }
        
        int n = Integer.parseInt(nStr.trim());
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getBalancedOrder(0, n - 1);

        System.out.println(sb.toString().trim());
    }
}