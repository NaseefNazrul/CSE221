
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {
    // Recursive function that fills post[] and returns the next free index
    public static int build(int preStart, int preEnd, int inStart, int inEnd,
                             int[] pre, int[] in, int[] post, int idx) {
        // PreStart and preEnd works for preorder list 
        // InStart and Inend works for inorder list 
        // pre arry and in array stays constant 
        // post array changes and increases depending on IDX

        if (preStart > preEnd) return idx;  // no nodes, no change

        int root = pre[preStart];
        int rootIdx = inStart;
        while (in[rootIdx] != root) rootIdx++;   // find root in inorder

        int leftSize = rootIdx - inStart;

        // Left subtree
        idx = build(preStart + 1, preStart + leftSize,
                    inStart, rootIdx - 1,
                    pre, in, post, idx);

        // Right subtree
        idx = build(preStart + leftSize + 1, preEnd,
                    rootIdx + 1, inEnd,
                    pre, in, post, idx);

        // Place root after children (post-order)
        post[idx++] = root;
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
        int [] pre_order = new int[n];
        for (int i = 0; i < n; i++) {
            pre_order[i] = Integer.parseInt(pre.nextToken());
        } // arr and inputs


        int [] post_order = new int[n];
        build(0,n-1,0,n-1,pre_order,in_order,post_order,0);

        for (int i = 0; i < n; i++) {
            pw.print(post_order[i] + " ");
        }

        pw.close();
    }   
}
