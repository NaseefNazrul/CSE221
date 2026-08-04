import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution {
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

        for (int t = 0; t < roads; t++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i<= cities; i++) {
            Collections.sort(graph.get(i));
        }
  
        boolean [] visited = new boolean[cities+1];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans.append(u).append(" ");

            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        pw.println(ans);
        pw.close();
    }
}