import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prb2 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine().trim());
        for(int i = 0; i < T; i++){
            String s = reader.readLine();
            String [] parts = s.split(" ");
            double num1 = Double.parseDouble(parts[1]);
            double num2 = Double.parseDouble(parts[3]);
            String op = parts[2];
            double result = 0;
            if(op.equals("+")) {
                result = num1 + num2;
            }
            else if(op.equals("-")){ 
                result = num1 - num2;
            }
            else if (op.equals("*")) {
                result = num1 * num2;
            }
            else if (op.equals("/")){
                result = num1 / num2;
            }
            sb.append(String.format("%.6f\n", result));
        }
        System.out.println(sb);
    }
}
