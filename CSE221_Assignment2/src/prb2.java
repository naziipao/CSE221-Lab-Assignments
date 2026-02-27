import java.io.*;
import java.util.*;

public class prb2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Read N, M, K
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken()); // Use long for K to prevent overflow issues during diff calc

        // Read Array A
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // Read Array B
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // --- Two Pointer Logic ---
        
        int l = 0;          // Pointer for A (starts at beginning)
        int r = m - 1;      // Pointer for B (starts at end)
        
        long minDiff = Long.MAX_VALUE;
        int resL = -1;      // To store best index from A
        int resR = -1;      // To store best index from B

        while (l < n && r >= 0) {
            long currentSum = (long)A[l] + B[r];
            long currentDiff = Math.abs(currentSum - k);

            // 1. Check if this is the best pair so far
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                resL = l;
                resR = r;
            }

            // 2. Move pointers
            if (currentSum < k) {
                // We need a larger sum, so move left pointer forward
                l++;
            } else {
                // We need a smaller sum (or equal), so move right pointer backward
                r--;
            }
        }

        // Output results (converting 0-based indices to 1-based)
        System.out.println((resL + 1) + " " + (resR + 1));
    }
}