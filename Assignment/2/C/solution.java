
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer num1 = new StringTokenizer(br.readLine().trim());
        int [] alice = new int[n];
        for (int i = 0; i<n; i++) {
            alice[i] = Integer.parseInt(num1.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer num2 = new StringTokenizer(br.readLine().trim());
        int [] bob = new int[m];
        for (int i = 0; i<m; i++) {
            bob[i] = Integer.parseInt(num2.nextToken());
        }

        // Not gonna make an array just gonna print it out 
        int i = 0; 
        int j = 0; // two pointers
        while (i < n && j < m) {
            if (alice[i] == bob[j]) {
                pw.print(alice[i] + " ");
                i++;
            }
            else if (alice[i] < bob[j]) {
                pw.print(alice[i] + " ");
                i++;
            }
            else{
                pw.print(bob[j] + " ");
                j++;
            }
        }


        // Print the rest of the lists 
        while (i < n) {
            pw.print(alice[i] + " ");
            i++;
        }
        while (j < m) {
            pw.print(bob[j] + " ");
            j++;
        }

        pw.close();

    }
}