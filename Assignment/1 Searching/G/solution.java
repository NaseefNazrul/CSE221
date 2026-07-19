
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
            int n = Integer.parseInt(br.readLine());
            int [][] a = new int[n][2];
            StringTokenizer id = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j][0] = Integer.parseInt(id.nextToken());
            }
            StringTokenizer marks = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j][1] = Integer.parseInt(marks.nextToken());
            }


            int swaps = 0;
            // sorts according to marks
            for (int j = 0; j < n - 1; j++) {

    int max_idx = j;

        for (int k = j + 1; k < n; k++) {

        if (a[k][1] > a[max_idx][1]) {
            max_idx = k;
        }
        else if (a[k][1] == a[max_idx][1] &&
                 a[k][0] < a[max_idx][0]) {
            max_idx = k;
        }
    }

    if (max_idx != j) {
        int[] temp = a[j];
        a[j] = a[max_idx];
        a[max_idx] = temp;
        swaps++;
    }
}

            pw.println("Minimum swaps: " + swaps);
            for (int j = 0; j < n; j++) {
                pw.println("ID: " + a[j][0] + " Mark: " + a[j][1]);
            }
        }
        pw.close();
    }
}