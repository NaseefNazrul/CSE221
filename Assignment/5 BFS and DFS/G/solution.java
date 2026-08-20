import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solution {
    public static boolean[] visited;
    public static boolean[] inStack; // replaces ArrayList path!

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int u) {
        visited[u] = true;
        inStack[u] = true; // add node u to current path

        for (int v : graph.get(u)) {
            // If v is ALREADY on the current active path meaning cycle found
            if (inStack[v]) {
                return true;
            }
            // If v is unvisited, recurse into it
            if (!visited[v]) {
                if (hasCycle(graph, v)) {
                    return true;
                }
            }
        }

        inStack[u] = false; // Remove node u from path 
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line.trim());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        inStack = new boolean[n + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); 
        }

        boolean cycle = false;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i)) {
                    cycle = true;
                    break;
                }
            }
        }

        if (cycle) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }
}