import java.io.BufferedReader;
import java.io.InputStreamReader;

public class prb3 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine().trim());
        for(int i = 0; i<T; i++){
            long num = Integer.parseInt(reader.readLine().trim());
            long result = (num*(num+1)) / 2;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}