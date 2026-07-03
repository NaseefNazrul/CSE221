
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
        long s = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        
        StringTokenizer num = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(num.nextToken());
        } // Making array


        int l = 0;
        int r = n-1;
        boolean found = false;
        while (l < r) {
            if (arr[l] + arr[r] == s) {
                found = true;
                pw.println((l+1) + " " + (r+1));
                break;
            }
            else if (arr[l] + arr[r] < s) {  // when the sum of left and right is smaller then increase the left
                l++;
            }
            else {
                r--;
            }
        }
        if (found == false) {
            pw.println(-1);
        }
        pw.close();
    }
}