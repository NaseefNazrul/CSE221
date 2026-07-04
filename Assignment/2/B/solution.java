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
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long [] arr1 = new long[n]; // Gonna start from the smallest (left)
        long [] arr2 = new long[m]; // Gonna start from largest (right)
        StringTokenizer num1 = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr1[i] = Long.parseLong(num1.nextToken());
        }

        StringTokenizer num2 = new StringTokenizer(br.readLine().trim());
        for (int i = 0 ; i < m; i++) {
            arr2[i] = Long.parseLong(num2.nextToken());
        }



        int i = 0;
        int j = m-1; 
        long best_diff = Long.MAX_VALUE;
        int besti = 0;
        int bestj = 0;

        while (i < n && j >= 0) { 
            long diff = Math.abs(arr1[i]+arr2[j]-k);
            long sum = arr1[i] + arr2[j];

            if (diff < best_diff) {
                best_diff = diff;
                besti = i;
                bestj = j;
            }

            if (sum == k) {
                break;
            }
            else if (sum > k) { 
                j--;
            }
            else {
                i++;
            }
        }

        pw.println((besti+1) + " " + (bestj+1));
        pw.close();
    }
}