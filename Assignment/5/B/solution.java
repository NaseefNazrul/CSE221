import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class solution {
    public static ArrayList<Boolean> visited = new ArrayList<>();
    public static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int cities = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 

        for (int i = 0; i <= cities; i++) {
            graph.add(new ArrayList<>());
        }

        int [] u = new int[roads];
        int [] v = new int[roads];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < roads; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < roads; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < roads; i++) {
            graph.get(u[i]).add(v[i]);
            graph.get(v[i]).add(u[i]);
        }

        for (int i = 1; i<= cities; i++) {
            Collections.sort(graph.get(i));
        }
  
        visited.set(1, true);
        DFS(graph,1);
        ans.append(1).append(" ");
        pw.println(ans);
        pw.close();
    }

    public static void DFS(ArrayList<ArrayList<Integer>> graph, int u) {
        visited.set(u,true);
        for (int v : graph.get(u)) {
            if (visited.get(v) == false) {
                ans.append(v).append(" ");
                DFS(graph, v);
            }
        }
    }
}