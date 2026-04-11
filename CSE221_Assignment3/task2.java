import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class task2 {

    private static void mergeList(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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
    }

    private static void orderElements(long[] arr, long[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            orderElements(arr, temp, left, mid);
            orderElements(arr, temp, mid + 1, right);
            mergeList(arr, temp, left, mid, right);
        }
    }

    private static int findPosition(long[] arr, int len, long target) {
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static void addValue(int[] bit, int index, int val) {
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }

    private static int getSum(int[] bit, int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        
        if (firstLine == null || firstLine.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(firstLine.trim());
        long[] a = new long[n];
        long[] vals = new long[2 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            vals[2 * i] = a[i];
            vals[2 * i + 1] = a[i] * a[i];
        }

        long[] temp = new long[2 * n];
        orderElements(vals, temp, 0, 2 * n - 1);

        long[] uniqueVals = new long[2 * n];
        int uniqueCount = 0;
        
        if (vals.length > 0) {
            uniqueVals[0] = vals[0];
            uniqueCount = 1;
            for (int i = 1; i < 2 * n; i++) {
                if (vals[i] != vals[i - 1]) {
                    uniqueVals[uniqueCount++] = vals[i];
                }
            }
        }

        int[] bit = new int[uniqueCount + 1];
        long totalPairs = 0;

        for (int i = n - 1; i >= 0; i--) {
            int queryIdx = findPosition(uniqueVals, uniqueCount, a[i]);
            totalPairs += getSum(bit, queryIdx);

            int insertIdx = findPosition(uniqueVals, uniqueCount, a[i] * a[i]);
            addValue(bit, insertIdx + 1, 1);
        }

        System.out.println(totalPairs);
    }
}