

public class rough {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int num = 3;
        int ans = 0;
        for (int i = 0; i<arr.length; i++) { 
            if (num <= arr[i] ) {
                ans = arr[i];
                break;
            }
        }
        System.out.println("Answer: " + ans);
    }
}
