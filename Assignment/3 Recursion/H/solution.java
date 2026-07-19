
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {
    public static int build(int inStart, int inEnd,
                                int postStart, int postEnd,
                                int[] in, int[] post, int[] pre,
                                int idx) {

        if (inStart > inEnd) return idx;   // null

        int root = post[postEnd];
        int rootIdx = inStart;
        while (in[rootIdx] != root) rootIdx++;   // find root in inorder

        int leftSize = rootIdx - inStart;

        // preorder
        pre[idx++] = root;

        // Left
        idx = build(inStart, rootIdx - 1,
                       postStart, postStart + leftSize - 1,
                       in, post, pre, idx);

        // Right
        idx = build(rootIdx + 1, inEnd,
                       postStart + leftSize, postEnd - 1,
                       in, post, pre, idx);

        return idx;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer in = new StringTokenizer(br.readLine().trim());
        int [] in_order = new int[n];
        for (int i = 0; i < n; i++) {
            in_order[i] = Integer.parseInt(in.nextToken());
        } 
        StringTokenizer pre = new StringTokenizer(br.readLine().trim());
        int [] post_order = new int[n];
        for (int i = 0; i < n; i++) {
            post_order[i] = Integer.parseInt(pre.nextToken());
        } // arr and inputs


        int [] pre_order = new int[n];
        build(0, n - 1, 0, n - 1, in_order, post_order, pre_order, 0);

        for (int i = 0; i < n; i++) {
            pw.print(pre_order[i] + " ");
        }

        pw.close();
    }   
}
