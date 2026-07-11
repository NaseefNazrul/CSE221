
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {

    public static long[] power_summation(long a, long n, long m) {
        if (n == 0) return new long[]{1 % m, 0};
        if (n == 1) {
            long am = a % m;
            return new long[]{am, am};
        }

        long[] half = power_summation(a, n / 2, m);
        long prev = half[0];                         // a^(n/2) % m
        long s = half[1];                         // S(n/2) % m

        long new_prev = (prev * prev) % m;                    // a^n when n is even
        long sumN;
        long aPowN;

        if (n % 2 == 0) {
            aPowN = new_prev;
            long factor = (1 + prev) % m;
            sumN = (s * factor) % m;
        } else {
            aPowN = (new_prev * (a % m)) % m;
            long factor = (1 + prev) % m;
            sumN = (s * factor + aPowN) % m;
        }

        return new long[]{aPowN, sumN};
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tests = Integer.parseInt(br.readLine());

        for (int t = 0; t < tests; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long [] res = power_summation(a, n, m);
            pw.println(res[1]);
        }
        pw.close();
    }
}
