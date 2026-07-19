import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {
    static final long MOD = 1000000007L; // using this would be better than re calculating it, learnt something new

    public static long[] power(long [] arr, long x) {
        if (x == 0) {
            return new long [] {1, 0, 0, 1}; // When The array keeps getting have it returns its IDENTITY (1) as its a square matrix
        }

        long [] half = power(arr, x/2);
        long [] res = new long[4];

        res[0] = (half[0]*half[0]  + half[1]*half[2]) % MOD; // This is how matrix are multiplied dont question
        res[1] = (half[0]*half[1]  + half[1]*half[3]) % MOD; // In this case its multiplying with itself
        res[2] = (half[2]*half[0]  + half[3]*half[2]) % MOD;
        res[3] = (half[2]*half[1]  + half[3]*half[3]) % MOD;

        if (x % 2 == 1) { 
            long [] temp = new long[4];
            temp[0] = (res[0]*arr[0]  + res[1]*arr[2]) % MOD; // Mulitplying with the base array because X is odd
            temp[1] = (res[0]*arr[1]  + res[1]*arr[3]) % MOD;
            temp[2] = (res[2]*arr[0]  + res[3]*arr[2]) % MOD;
            temp[3] = (res[2]*arr[1]  + res[3]*arr[3]) % MOD;
            return temp;
        }

        return res;

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tests = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tests; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            long [] arr = new long[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }  // Made the array

            long x = Long.parseLong(br.readLine());
            long [] ans = power(arr,x); // Returning the edited array, inplace

            pw.print(ans[0] + " " + ans[1]);
            pw.println();
            pw.print(ans[2] + " " + ans[3]);
            pw.println();

        }

        pw.close();

    }
}