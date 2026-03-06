
import java.io.*;
import java.util.*;

public class task4 {

    public static int[] stringBreaker(String s, int num) {
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[num];
        int i = 0;
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            arr[i] = Integer.parseInt(temp);
            i++;
        }
        return arr;
    }

    public static String solve(String s1, int length1, String s2, int length2) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(s1);
        StringTokenizer st2 = new StringTokenizer(s2);
        int[] arr1 = new int[length1];
        int[] arr2 = new int[length2];
        int i = 0;
        while (st1.hasMoreTokens()) {
            arr1[i] = Integer.parseInt(st1.nextToken());
            i++;
        }
        int j = 0;
        while (st2.hasMoreTokens()) {
            arr2[j] = Integer.parseInt(st2.nextToken());
            j++;
        }
        // Array processing done
        //Main operation:
        int pt1 = 0;
        int pt2 = 0;
        int[] resArr = new int[length1 + length2];
        int resPt = 0;
        while (pt1 < arr1.length && pt2 < arr2.length) {
            if (arr1[pt1] <= arr2[pt2]) {
                resArr[resPt++] = arr1[pt1++];
            } else if (arr1[pt1] > arr2[pt2]) {
                resArr[resPt++] = arr2[pt2++];
            }
        }
        while (pt1 < arr1.length) {
            resArr[resPt++] = arr1[pt1++];
        }

        // Clean up remaining elements for arr2 (if any)
        while (pt2 < arr2.length) {
            resArr[resPt++] = arr2[pt2++];
        }
        //Output format:
        for (int k = 0; k < resArr.length; k++) {
            if (k == resArr.length - 1) {
                sb.append(resArr[k]);
            } else {
                sb.append(resArr[k]).append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int line1 = Integer.parseInt(br.readLine());
        String line2 = br.readLine();
        int line3 = Integer.parseInt(br.readLine());
        String line4 = br.readLine();
        wr.println(solve(line2, line1, line4, line3));
        wr.flush();
    }
}
