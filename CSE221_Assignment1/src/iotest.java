import java.io.BufferedReader;
import java.io.InputStreamReader;

public class iotest {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  // BufferedReader object create  
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter a num");
        int num = Integer.parseInt(reader.readLine().trim());  // User Input
        sb.append(num).append(" is the output.");
        System.out.println(sb.toString());  // Output
    }
}
