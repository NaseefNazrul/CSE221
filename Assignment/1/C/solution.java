import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tests = Integer.parseInt(br.readLine());

        for (int i = 0; i < tests; i++) {
            long n = Long.parseLong(br.readLine());
            pw.println((n* (n+1))/2);
        }
        pw.close();
    }
}