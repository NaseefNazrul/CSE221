
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {

    public static long power(long a, long b) {
        if (b == 0) {
            return 1;
        }
        a = a % 107;
        long tmp = power(a, b/2);
        long result = (tmp * tmp) %107;
        if (b % 2 == 1) {
            result = (result * a) %107;
        }
        return result;

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        pw.println(power(a,b));
        pw.close();
    }
}