import java.util.*;

// 1. THE CLASS (Our Index Card)
class Train {
    String name;
    String destination;
    String time;
    int id; 

    public Train(String name, String destination, String time, int id) {
        this.name = name;
        this.destination = destination;
        this.time = time;
        this.id = id;
    }
}

public class rough {
    
    // 2. THE HELPER (Fixing the Alphabet)
    // This assigns scores: a=0 ... z=25, A=26 ... Z=51
    public static int getCharRank(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }

    // This compares two names using our new scores
    public static int compareNames(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int minLength = Math.min(length1, length2);

        // Compare letter by letter
        for (int i = 0; i < minLength; i++) {
            int rank1 = getCharRank(s1.charAt(i));
            int rank2 = getCharRank(s2.charAt(i));

            // If the letters are different, the one with the smaller rank wins
            if (rank1 != rank2) {
                return rank1 - rank2;
            }
        }
        // If we ran out of letters (e.g. "apple" vs "applepie"), shorter wins
        return length1 - length2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Safety check: is there input?
        if (!sc.hasNext()) return;

        int N = sc.nextInt();
        
        // 3. THE LIST
        ArrayList<Train> trains = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            sc.next(); // skip "will"
            sc.next(); // skip "depart"
            sc.next(); // skip "for"
            String dest = sc.next();
            sc.next(); // skip "at"
            String time = sc.next();

            // Add to list, remembering 'i' as the original position
            trains.add(new Train(name, dest, time, i));
        }

        // 4. THE SORT (The Judge)
        Collections.sort(trains, new Comparator<Train>() {
            @Override
            public int compare(Train t1, Train t2) {
                // RULE 1: Compare Names
                if (!t1.name.equals(t2.name)) {
                    return compareNames(t1.name, t2.name);
                }

                // RULE 2: Compare Times (Descending / Latest First)
                if (!t1.time.equals(t2.time)) {
                    // We compare t2 against t1 to flip the order
                    return t2.time.compareTo(t1.time);
                }

                // RULE 3: Original Input Order (Ascending)
                return Integer.compare(t1.id, t2.id);
            }
        });

        // 5. OUTPUT
        for (Train t : trains) {
            System.out.println(t.name + " will depart for " + t.destination + " at " + t.time);
        }
        
        sc.close();
    }
}