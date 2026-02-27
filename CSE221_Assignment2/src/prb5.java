import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class prb5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        long currentSum = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            // Add new element to the window
            currentSum += arr[right];
            while (currentSum > k) {
                currentSum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        out.println(maxLen);
        out.close();
    }
}