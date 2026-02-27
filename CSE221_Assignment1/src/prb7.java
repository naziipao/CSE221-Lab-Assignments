
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prb7 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        for (int k = 0; k < t; k++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(reader.readLine().trim());
            String id_String = reader.readLine().trim();
            String mark_String = reader.readLine().trim();
            String[] id_arr_str = id_String.split(" ");
            String[] mark_arr_str = mark_String.split(" ");
            int[] id_arr = new int[n];
            int[] mark_arr = new int[n];
            // ID & Marks array create:
            for (int i = 0; i < n; i++) {
                id_arr[i] = Integer.parseInt(id_arr_str[i]);
                mark_arr[i] = Integer.parseInt(mark_arr_str[i]);
            }

            //Sorting --> Use Selection sort as the problem wants to calculate the mininum steps to sort which can be obtained by "Selection Sort":
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (mark_arr[j] == mark_arr[min_idx]) {  //When marks are same
                        if (id_arr[min_idx] > id_arr[j]) {
                            min_idx = j;
                        }
                    } else if (mark_arr[j] > mark_arr[min_idx]) {
                        min_idx = j;
                    }
                }
                if (min_idx != i) {
                    //Swap marks
                    int temp = mark_arr[i];
                    mark_arr[i] = mark_arr[min_idx];
                    mark_arr[min_idx] = temp;
                    //Swap id
                    temp = id_arr[i];
                    id_arr[i] = id_arr[min_idx];
                    id_arr[min_idx] = temp;
                    count++;
                }
            }

            //Output formatting:
            for (int i = 0; i < n; i++) {
                sb.append("ID: ").append(id_arr[i]).append(" ").append("Mark: ").append(mark_arr[i]).append("\n");
            }
            System.out.println("Minimum swaps: " + count);
            System.out.print(sb);
        }
    }
}