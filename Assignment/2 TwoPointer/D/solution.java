
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
        long k = Long.parseLong(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int best_length = 0; 
        int left = 0;
        long sum = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (right - left + 1 > best_length) {
                best_length = right - left + 1;
            }
        }

        pw.println(best_length);
        pw.close();
    }
}