
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {

    private static int buildOrder(long[] A, int l, int r, long[] out, int idx) {
        if (l > r) return idx;
        int mid = (l + r) / 2;
        out[idx++] = A[mid];                  // place root, advance index
        idx = buildOrder(A, l, mid - 1, out, idx); // left fills from idx
        idx = buildOrder(A, mid + 1, r, out, idx); // right continues
        return idx;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        long [] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }  // Made the arrays and inputs 

        long [] res = new long[n];
        buildOrder(arr, 0, n-1, res, 0);
        for (int i = 0; i < n; i++) {
            pw.print(res[i] + " ");
        }
        pw.close();
    }
}