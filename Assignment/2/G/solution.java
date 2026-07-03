import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int total_partitions = Integer.parseInt(st.nextToken()) - 1; // max cuts allowed
        int[] arr = new int[n];

        StringTokenizer num = new StringTokenizer(br.readLine());
        long sum = 0;
        int max_num = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(num.nextToken());
            arr[i] = k;
            sum += k;
            if (k > max_num) max_num = k;
        }

        long left = max_num;
        long right = sum;
        long last_best = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            int partition_count = 0; // number of cuts
            long temp = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (temp + arr[i] > mid) {   // need a cut
                    partition_count++;
                    temp = arr[i];
                    if (partition_count > total_partitions) {
                        possible = false;
                        break;
                    }
                } else {
                    temp += arr[i];
                }
            }

            if (possible && partition_count <= total_partitions) {
                last_best = mid;   // feasible, try smaller
                right = mid - 1;
            } else {
                left = mid + 1;    // infeasible, try larger
            }
        }

        pw.println(last_best);
        pw.close();
    }
}