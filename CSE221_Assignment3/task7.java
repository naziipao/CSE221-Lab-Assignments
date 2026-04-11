import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class task7 {

    static int[] inOrder;
    static int[] preOrder;
    static int[] inOrderIndexMap;
    static StringBuilder sb = new StringBuilder();

    static void buildPostOrder(int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd) {
            return;
        }

        int root = preOrder[preStart];
        int rootIndex = inOrderIndexMap[root];
        int leftSubtreeSize = rootIndex - inStart;

        buildPostOrder(inStart, rootIndex - 1, preStart + 1, preStart + leftSubtreeSize);
        buildPostOrder(rootIndex + 1, inEnd, preStart + leftSubtreeSize + 1, preEnd);

        sb.append(root).append(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String nStr = br.readLine();
        if (nStr == null || nStr.trim().isEmpty()) {
            return;
        }
        
        int n = Integer.parseInt(nStr.trim());
        inOrder = new int[n];
        preOrder = new int[n];
        
        inOrderIndexMap = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIndexMap[inOrder[i]] = i; 
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }

        buildPostOrder(0, n - 1, 0, n - 1);

        System.out.println(sb.toString().trim());
    }
}