import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prb1{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T; i++){
            long num = Long.parseLong(reader.readLine().trim());
            if(num % 2 == 0){  //Means even number
                sb.append(num).append(" is Even number.\n");
            }
            else{
                sb.append(num).append(" is Odd number.\n");
            }
        }
        System.out.println(sb.toString());
    }
}