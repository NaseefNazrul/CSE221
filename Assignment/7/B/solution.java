import java.io.*;
import java.util.*;

public class solution {
    static class Edge {
        int to;
        long weight;

        Edge(int to, long w) {
            this.to = to;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Corrected line-by-line input parsing for M edges
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        // Compute shortest paths from S and T independently
        long[] dist_s = dijkstraa(n, graph, s);
        long[] dist_t = dijkstraa(n, graph, t);

        long minTime = Long.MAX_VALUE;
        int bestNode = -1;

        
        for (int i = 1; i <= n; i++) {
            if (dist_s[i] != Long.MAX_VALUE && dist_t[i] != Long.MAX_VALUE) {
                long currentTime = Math.max(dist_s[i], dist_t[i]);
                if (currentTime < minTime) {
                    minTime = currentTime;
                    bestNode = i;
                }
            }
        }

        if (bestNode == -1) {
            pw.println(-1);
        } else {
            pw.println(minTime + " " + bestNode);
        }

        pw.flush();
        pw.close();
    }

    private static long[] dijkstraa(int n, ArrayList<ArrayList<Edge>> graph, int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, start});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int u = (int) current[1];

            if (d > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                if (dist[u] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[u] + edge.weight;
                    pq.offer(new long[]{dist[edge.to], edge.to});
                }
            }
        }

        return dist;
    }
}