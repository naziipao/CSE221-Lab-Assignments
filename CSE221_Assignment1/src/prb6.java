import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prb6 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine().trim());
        String input = reader.readLine();
        String [] arr = input.split(" ");
        int [] part = new int[arr.length];
        for(int i = 0; i<N ; i++){
            part[i] = Integer.parseInt(arr[i]);
        }
        // Sorting:
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i<N-1; i++) {
                if(part[i] %2 == part[i+1]%2){
                    if(part[i]> part[i+1]){
                        int temp = part[i];
                        part[i] = part[i+1];
                        part[i+1] = temp;
                        swapped = true;
                    }
                }
            }
        }
        //Output String formatting:
        for(int i = 0; i<N; i++){
            sb.append(part[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
