import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class prb1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // Input of / array length and target number
        String firstLine = reader.readLine().trim();
        String [] arr1 = firstLine.split(" "); 
        int n = Integer.parseInt(arr1[0]);
        int target = Integer.parseInt(arr1[1]);

        // Input of the array
        String secondLine = reader.readLine().trim();
        String [] arr2 = secondLine.split(" ");
        int [] inputArr = new int[n];
        for (int i = 0; i<arr2.length; i++) {
            inputArr[i] = Integer.parseInt(arr2[i]);
        }

        int i = 0;
        int j = inputArr.length-1;
        boolean flag = false;
        while(i < j){
            if(inputArr[i] + inputArr[j] == target){
                flag = true;
                break;
            }
            else if (inputArr[i] + inputArr[j] <target) {
                i++;
            }
            else if (inputArr[i] + inputArr[j] > target) {
                j--;
            }
        }
        if (flag) {
            sb.append((i+1)).append(" ").append((j+1));
            wr.write(sb.toString());
        }
        else if (!flag){
            wr.write("-1");
        }
        wr.close();
    }
}
