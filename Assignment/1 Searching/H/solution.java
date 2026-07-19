
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String [][] trains = new String[n][3];

        // Making the array
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp.trim());
            trains[i][0] = st.nextToken();
            trains[i][2] = temp;
            for (int j = 0; j < 5; j++) {
                st.nextToken();
            }
            trains[i][1] = st.nextToken();
        }

        // Sorting 
        int moves = 0;
        int prev_moves = 0;
        int idx = 0;
        int reducer = 0;
        while (true) { 
            if (idx == n-1 - reducer) {
                if (moves == prev_moves) {
                    break;
                }
                else {
                    prev_moves = moves;
                    idx = 0;
                    reducer++;
                    continue;
                }
            }

            if (trains[idx][0].compareTo(trains[idx+1][0]) == 0) { // basically if they are same 
                if (Integer.parseInt(trains[idx][1].replace(":", "")) < Integer.parseInt(trains[idx+1][1].replace(":", ""))) {
                    String [] temp = trains[idx];
                    trains[idx] = trains[idx+1];
                    trains[idx+1] = temp; 
                    moves++;
                }
            }
            else if (trains[idx][0].compareTo(trains[idx+1][0]) > 0) {
                String [] temp = trains[idx];
                trains[idx] = trains[idx+1];
                trains[idx+1] = temp;
                moves++;
            }
            idx++;
        }

        // Now print
        for (int j = 0; j < n; j++) {
            pw.println(trains[j][2]);
        }

        pw.close();
    }
}