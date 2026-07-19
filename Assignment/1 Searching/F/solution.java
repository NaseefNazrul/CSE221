
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        long [] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int moves = 0;
        int prev_moves = 0;
        int idx = 0;
        while (true) {
            if (idx == n-1) {
                if (moves == prev_moves) {
                    break;
                }
                else {
                    idx = 0;
                    prev_moves = moves;
                }
            }

            if ((arr[idx] % 2 == arr[idx+1] % 2) && (arr[idx] > arr[idx+1])) {
                long temp = arr[idx];
                arr[idx] = arr[idx+1];
                arr[idx+1] = temp;
                moves++;
            }
            idx++;
        }

        for (int i = 0; i < n; i++) {
            pw.print(arr[i] + " ");
        }
        pw.close();
    }
}