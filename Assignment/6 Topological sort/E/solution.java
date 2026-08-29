import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int [] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int u = Integer.parseInt(st.nextToken());
            dist[u] = 0;
            queue.offer(u);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbour : graph.get(curr)) {
                if (dist[neighbour] == -1) {
                    dist[neighbour] = dist[curr] + 1;
                    queue.offer(neighbour);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int v = Integer.parseInt(st.nextToken());
            ans.append(dist[v]).append(" ");
        }
        pw.println(ans);
        pw.close();
    }
}