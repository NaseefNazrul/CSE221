
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
        int k = Integer.parseInt(st.nextToken());
        StringTokenizer num = new StringTokenizer(br.readLine().trim());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(num.nextToken());
        }

        // Using a count fequency array to work with duplicates 
        // window method 
        // increase right if distinct counter is under k or increase right if duplicate
        // increase left if distinct number is above k to reduce the window

        int [] distinct_arr = new int[n];
        int distinct_counter = 0;
        int left = 0;
        int best_length = 0;

        for (int right = 0; right < n; right++) {
            int val = arr[right];

            if (distinct_arr[val-1] == 0) {
                distinct_counter++;
            }
            
            distinct_arr[val-1]++;

            while (distinct_counter > k) {
                int remove_val = arr[left];
                distinct_arr[remove_val-1]--;

                if (distinct_arr[remove_val-1] == 0) {
                    distinct_counter--;
                }
                left++;
            }

            if (right - left > best_length) {
                best_length = right-left;
            }
            
        }
        pw.println(best_length+1);
        pw.close();
    }
}