import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class task5 {

    private static long[][] multiplyMatrices(long[][] a, long[][] b, long mod) {
        long[][] result = new long[2][2];
        
        result[0][0] = ((a[0][0] * b[0][0]) % mod + (a[0][1] * b[1][0]) % mod) % mod;
        result[0][1] = ((a[0][0] * b[0][1]) % mod + (a[0][1] * b[1][1]) % mod) % mod;
        result[1][0] = ((a[1][0] * b[0][0]) % mod + (a[1][1] * b[1][0]) % mod) % mod;
        result[1][1] = ((a[1][0] * b[0][1]) % mod + (a[1][1] * b[1][1]) % mod) % mod;
        
        return result;
    }

    private static long[][] exponentiateMatrix(long[][] base, long exp, long mod) {
        long[][] result = {
            {1, 0},
            {0, 1}
        };

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiplyMatrices(result, base, mod);
            }
            base = multiplyMatrices(base, base, mod);
            exp /= 2;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long[][] baseMatrix = {
                {a % m, a % m},
                {0, 1}
            };

            long[][] resultMatrix = exponentiateMatrix(baseMatrix, n, m);

            sb.append(resultMatrix[0][1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}