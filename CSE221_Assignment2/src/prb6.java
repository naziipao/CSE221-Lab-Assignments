import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class prb6 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter write = new PrintWriter(System.out);
        String firstLineIn = reader.readLine();
        StringTokenizer st = new StringTokenizer(firstLineIn);
        int num1 = Integer.parseInt(st.nextToken());  //Length of the array
        int num2 = Integer.parseInt(st.nextToken());  //Value of k
        String secondLine = reader.readLine();
        int [] inputArr = new int[num1];
        st = new StringTokenizer(secondLine); // Reuse tokenizer
        for (int i = 0; i < num1; i++) {
            if (st.hasMoreTokens()) {
                inputArr[i] = Integer.parseInt(st.nextToken());
            }
        }
        int left = 0;
        int right = 0;
        int unique = 0;
        int [] freq = new int[200005];
        int maxLen = 0;

        while (right < num1) { 
            if(freq[inputArr[right]] == 0){
                unique++;
            }
            freq[inputArr[right]]++;

            while (unique > num2) { 
                freq[inputArr[left]]--;
                if (freq[inputArr[left]] == 0) {
                    unique--;
                }
                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);
            right++;
        }
        write.print(maxLen);
        write.close();
    }
}
