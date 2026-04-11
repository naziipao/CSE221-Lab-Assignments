import java.io.IOException;
import java.io.InputStream;

public class task4 {

    private static final long MOD = 1000000007L;

  
    private static void multiply(long[][] a, long[][] b) {
     
        long a00 = a[0][0], a01 = a[0][1];
        long a10 = a[1][0], a11 = a[1][1];
        
        long b00 = b[0][0], b01 = b[0][1];
        long b10 = b[1][0], b11 = b[1][1];

     
        a[0][0] = (a00 * b00 + a01 * b10) % MOD;
        a[0][1] = (a00 * b01 + a01 * b11) % MOD;
        a[1][0] = (a10 * b00 + a11 * b10) % MOD;
        a[1][1] = (a10 * b01 + a11 * b11) % MOD;
    }

    private static void exponentiateMatrix(long[][] base, long exp, long[][] result) {
        
        result[0][0] = 1; result[0][1] = 0;
        result[1][0] = 0; result[1][1] = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                multiply(result, base);
            }
            multiply(base, base);
                exp = exp / 2;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        
        long t = scanner.nextLong();
        if (t == -1) return;

        StringBuilder sb = new StringBuilder();
        
        
        long[][] matrix = new long[2][2];
        long[][] resultMatrix = new long[2][2];

        for (int tc = 0; tc < t; tc++) {
            matrix[0][0] = scanner.nextLong() % MOD;
            matrix[0][1] = scanner.nextLong() % MOD;
            matrix[1][0] = scanner.nextLong() % MOD;
            matrix[1][1] = scanner.nextLong() % MOD;

            long x = scanner.nextLong();

            exponentiateMatrix(matrix, x, resultMatrix);

            sb.append(resultMatrix[0][0]).append(" ").append(resultMatrix[0][1]).append("\n");
            sb.append(resultMatrix[1][0]).append(" ").append(resultMatrix[1][1]).append("\n");
        }

        System.out.print(sb.toString());
    }

    
    static class FastScanner {
        private final InputStream stream;
        private final byte[] buf = new byte[1 << 16];
        private int head, tail;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = stream.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public long nextLong() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }
}