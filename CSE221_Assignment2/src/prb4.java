import java.io.*;
import java.util.*;

public class prb4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return -1;
            st = new StringTokenizer(line);
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        // Use PrintWriter for fast output
        PrintWriter out = new PrintWriter(System.out);

        // 1. Read Alice's list
        int n = nextInt();
        int[] alice = new int[n];
        for (int i = 0; i < n; i++) {
            alice[i] = nextInt();
        }

        // 2. Read Bob's list
        int m = nextInt();
        int[] bob = new int[m];
        for (int i = 0; i < m; i++) {
            bob[i] = nextInt();
        }

        // 3. Merge Logic (Two Pointers)
        int i = 0; // Pointer for Alice
        int j = 0; // Pointer for Bob

        while (i < n && j < m) {
            if (alice[i] <= bob[j]) {
                out.print(alice[i] + " ");
                i++;
            } else {
                out.print(bob[j] + " ");
                j++;
            }
        }

        // 4. Print remaining elements
        while (i < n) {
            out.print(alice[i++] + " ");
        }
        while (j < m) {
            out.print(bob[j++] + " ");
        }
        out.flush();
    }
}