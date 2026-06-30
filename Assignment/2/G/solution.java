
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int partitions = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        StringTokenizer num = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i =0; i< n; i++) {
            int k = Integer.parseInt(num.nextToken());
            arr[i] = k;
            sum+=k;
        }

        int sub_count = 0;
        int temp = 0;
        for (int i = sum; i > 0; i--) {
            sub_count = 0;
            temp = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] + temp >= i) {
                    temp = 0; 
                    sub_count++;
                    continue;
                }
                temp += arr[j];
            }

            if (sub_count > partitions-1) {
                pw.println(i+1);
                break;
            }
        }

        pw.close();
    }
}