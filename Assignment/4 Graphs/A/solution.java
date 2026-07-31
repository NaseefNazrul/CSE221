
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
        int e = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][n];

        for (int i = 0; i < e; i++) {
            StringTokenizer num = new StringTokenizer(br.readLine().trim());
            int out = Integer.parseInt(num.nextToken());
            int in = Integer.parseInt(num.nextToken());
            int weight = Integer.parseInt(num.nextToken());

            arr[out-1][in-1] = weight;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(arr[i][j] + " ");
            }
            pw.println();
        }

        pw.close();
    }
}