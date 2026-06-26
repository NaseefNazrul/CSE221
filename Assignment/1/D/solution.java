
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tests = Integer.parseInt(br.readLine());

        for (int i = 0; i < tests; i++) {
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long prev = Long.parseLong(st.nextToken());
            boolean sorted = true;
            for (int k = 0; k < size-1; k++) {
                long num = Long.parseLong(st.nextToken());

                if (prev > num) {
                    pw.println("NO");
                    sorted = false;
                    break;
                }
                prev = num;
            }
            if (sorted == true) {
                pw.println("YES");
            }
        }
        pw.close();
    }
}