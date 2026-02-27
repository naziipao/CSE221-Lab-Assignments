import java.io.*;
import java.util.*;

public class prb3{
    // 1. Class to store value and original index together
    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        // Compare based on value for sorting
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        Pair[] arr = new Pair[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            // Store 1-based index (i + 1)
            arr[i] = new Pair(val, i + 1);
        }

        // 2. Sort the array O(N log N)
        Arrays.sort(arr);

        // 3. Fix one element and find the other two using Two Pointers O(N^2)
        for (int i = 0; i < n - 2; i++) {
            // We need to find two numbers that sum to (x - arr[i].value)
            int target = x - arr[i].value;
            
            // Pointers
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int currentSum = arr[left].value + arr[right].value;
                
                if (currentSum == target) {
                    // Found the triplet! Print indices and exit.
                    System.out.println(arr[i].index + " " + arr[left].index + " " + arr[right].index);
                    return;
                } else if (currentSum < target) {
                    // Sum is too small, need larger numbers -> move left pointer
                    left++;
                } else {
                    // Sum is too large, need smaller numbers -> move right pointer
                    right--;
                }
            }
        }
        
        // 4. No solution found
        System.out.println("-1");
    }
}