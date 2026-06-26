import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws Exception{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Making the array
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Performing as much as operations as possible 
        int prev_moves = 0;
        int moves = 0;
        StringBuilder operation = new StringBuilder(); 
        int idx = 0;
        int reducer = 0;
        while (true) {
            if (idx >= (n-2 - reducer)) {
                if (moves == prev_moves) {
                    break;
                }
                else {
                    prev_moves = moves;
                    idx = 0; // restart
                    reducer++;
                }
            }
            if (arr[idx] > arr[idx+2]) {
                int temp = arr[idx];
                arr[idx] = arr[idx+2];
                arr[idx+2] = temp;
                moves++;
                operation.append(idx + 1).append(' ').append(idx + 3).append('\n');
            }
            idx++;
        }

        // Now the operations are completed we check if it is sorted 
        boolean sorted = true;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]) {
                sorted = false;
                pw.println("NO");
                break;
            }
        }
        if (sorted == true) {
            pw.println("YES");
            pw.println(moves);
            pw.println(operation);
        }
        pw.close();
    }
}


