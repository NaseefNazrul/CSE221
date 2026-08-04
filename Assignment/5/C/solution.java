import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int cities = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int [] u = new int[roads];
        int [] v = new int[roads];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < roads ;i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < roads ;i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < roads; i++) {
            graph.get(u[i]).add(v[i]);
            graph.get(v[i]).add(u[i]);
        } 

        for (int i = 1; i<= cities; i++) {
            Collections.sort(graph.get(i));
        } // made the graph 


    }
}