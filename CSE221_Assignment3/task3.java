import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class task3 {

    private static long calculateModPower(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent /= 2;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        
        if (inputLine == null || inputLine.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(inputLine);
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long ans = calculateModPower(a, b, 107);
        System.out.println(ans);
    }
}