
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long [] arr = new long[n];
        StringTokenizer num = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(num.nextToken());
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer queries = new StringTokenizer(br.readLine().trim());
            long low = Long.parseLong(queries.nextToken());
            long high = Long.parseLong(queries.nextToken());

            int low_idx = 0;
            int high_idx = n;

            int l = 0;
            int r = n-1;
            while (l <= r) {
                int mid = (l+r)/2;
                
                if (low <= arr[mid]) {
                    r = mid-1;
                    low_idx = mid;
                }
                else {
                    l = mid+1;
                }
            }

            l = 0;
            r = n-1;
            while (l <= r) {
                int mid = (l+r)/2;
                if (high < arr[mid]) {
                    r = mid - 1;
                    high_idx = mid;
                }
                else {
                    l = mid + 1;
                }
            }

            pw.println(high_idx-low_idx);

        }

        pw.close();
    }
}