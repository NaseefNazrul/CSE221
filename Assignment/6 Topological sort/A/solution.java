
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;



public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tests = Integer.parseInt(br.readLine());

        for (int t = 0; t < tests; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [] indegree = new int[n+1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n ; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                indegree[v]++;
                graph.get(u).add(v);
            } // Made the graph and indegree array



            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i<=n; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            } // Starting nodes
            
            StringBuilder ans = new StringBuilder();
            int order_count = 0;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                ans.append(current).append(" ");
                order_count++;

                for (int neighbour : graph.get(current)) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        queue.offer(neighbour);
                  }
                }
            } // normal topological sort

            if (order_count == n) {
                pw.println(ans);
            }
            else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}

