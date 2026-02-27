
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class prb8{
    public static int getCharRank(char c){
        if(c>='a' && c<='z'){
            return c - 'a';
        }
        else{
            return c - 'A' + 26;
        }
    }

    public static int compare(String s1, String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int min = Math.min(length1, length2);
        for (int i = 0; i<min ; i++){
            int rank1 = getCharRank(s1.charAt(i));
            int rank2 = getCharRank(s2.charAt(i));
            if(rank1!=rank2){
                return rank1 - rank2;
            }
        }
        return length1 - length2;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<train> trains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            sc.next();
            sc.next();
            sc.next();
            String dest = sc.next();
            sc.next();
            String time = sc.next();
            trains.add(new train(name, dest, time, i));
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                train t1 = trains.get(j);
                train t2 = trains.get(j + 1);
                
                boolean shouldSwap = false;

                int nameDiff = compare(t1.name, t2.name);
                
                if (nameDiff > 0) {
                    shouldSwap = true;
                } 
                else if (nameDiff == 0) {
                    if (t1.time.compareTo(t2.time) < 0) {
                        shouldSwap = true;
                    }
                }
                if (shouldSwap) {
                    trains.set(j, t2);
                    trains.set(j + 1, t1);
                }
            }
        }
        for (train t : trains) {
            System.out.println(t.name + " will depart for " + t.destination + " at " + t.time);
        }

    }
}
class train{
    String name;
    String destination;
    String time;
    int id;

    public train(String name, String destination, String time, int id){
        this.name = name;
        this.destination = destination;
        this.time = time;
        this.id = id;
    }
}