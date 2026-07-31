
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] start = new int[e];
        int[] end = new int[e];
        int[] in = new int[n+1];
        int[] out = new int[n+1];
 
        // start vertexes input
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<e; i++){
            start[i]=Integer.parseInt(st.nextToken());
        }

        // end vertexes along with in and out degree management 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<e; i++){
            end[i]=Integer.parseInt(st.nextToken());
            out[start[i]]++;
            in[end[i]]++;
        }

        // output
        for(int i=1; i<=n; i++){
            pw.print((in[i] - out[i])+" ");
        }

        pw.close();
    }
}