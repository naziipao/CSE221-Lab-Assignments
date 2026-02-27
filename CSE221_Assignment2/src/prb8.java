import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prb8 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String inputString = reader.readLine();
            String[] stringArr = inputString.split(" ");
            int k = Integer.parseInt(stringArr[0]);
            int x = Integer.parseInt(stringArr[1]);
            long max = 2_000_000_000L;
            long min = 1;
            long ans = max;
            while (min <= max) {
                long mid = min + (max - min) / 2;   // Dont use (max+min)/2 this formula. Instead, use this;
                long count = mid - mid / x;
                if (count >= k) {
                    ans = mid;
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
}
