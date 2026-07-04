
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        StringTokenizer num = new StringTokenizer(br.readLine().trim());
        long [] arr = new long[n];
        long low = Long.MAX_VALUE;
        long high = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(num.nextToken());
            if (arr[i] > high) {
                high = arr[i];
            }
            if (arr[i] < low) {
                low = arr[i];
            }
            sum += arr[i];
        }

        if (sum < k) {
            pw.println(-1);
        }
        else {
            long bestl = 0;
            
            while (low)
        }

        pw.close();
    }
}