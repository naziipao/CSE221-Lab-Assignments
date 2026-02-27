import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prb5 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine().trim());
        String s = reader.readLine().trim();  // User Input
        String [] arr = s.split(" ");
        int [] part = new int[arr.length];
        for (int i =0; i<N; i++){
            part[i] = Integer.parseInt(arr[i]);
        }
        // Reverse Operation --> Have to use Bubble sort:
        boolean swapped = true;
        int count = 0;
        while (swapped) { 
            swapped = false;
            for (int i = 0; i<N-2; i++) {
                if(part[i]>part[i+2]){
                    int temp = part[i];
                    part[i] = part[i+2];
                    part[i+2] = temp;
                    sb.append(i+1).append(" ").append(i+3).append("\n");
                    swapped = true;
                    count++;
                }
            }
        }
        //Checking whether non-decreasing:
        boolean flag = true;
        for (int i = 0; i<part.length-1; i++) {
            if(part[i]<=part[i+1]){
                flag = true;
            }
            else if(part[i]>part[i+1]){
                flag = false;
                break;
            }
        }
        if(flag == true){
            System.out.println("YES");
            System.out.println(count);
            System.out.println(sb);
        }
        else{
            System.out.println("NO");
        }
    }
}
