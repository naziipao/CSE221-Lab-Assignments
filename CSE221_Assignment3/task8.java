import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class task8 {

    static int[] inOrder;
    static int[] postOrder;
    static int[] inOrderIndexMap;
    static StringBuilder sb = new StringBuilder();

    static void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return;
        }

        int root = postOrder[postEnd];
        int rootIndex = inOrderIndexMap[root];
        int leftSubtreeSize = rootIndex - inStart;

        sb.append(root).append(" ");

        buildPreOrder(inStart, rootIndex - 1, postStart, postStart + leftSubtreeSize - 1);
        buildPreOrder(rootIndex + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String nStr = br.readLine();
        if (nStr == null || nStr.trim().isEmpty()) {
            return;
        }
        
        int n = Integer.parseInt(nStr.trim());
        inOrder = new int[n];
        postOrder = new int[n];
        
        inOrderIndexMap = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIndexMap[inOrder[i]] = i; 
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        buildPreOrder(0, n - 1, 0, n - 1);

        System.out.println(sb.toString().trim());
    }
}