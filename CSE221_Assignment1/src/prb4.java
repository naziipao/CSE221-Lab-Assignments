import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prb4 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine().trim());
        for(int i = 0; i<T; i++){
            int length = Integer.parseInt(reader.readLine().trim());
            String s = reader.readLine();
            String [] arr = s.split(" ");  // Array created containing the numbers.
            boolean flag = true;
            for (int j = 0; j<length-1; j++){;
                int num1 = Integer.parseInt(arr[j]);
                int num2 = Integer.parseInt(arr[j+1]);
                if (num1 > num2) {  // Not matching the condition.
                    flag = false;
                    break;
                }
            }
            if (flag == false){
                sb.append("NO").append("\n");  
            }
            else{
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}