
import java.io.*;
import java.util.*;



public class solution {
    static class Edge {
        int to;
        long weight;

        Edge (int to, long w) {
            this.to = to;
            this.weight = w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 1});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long maxDangerSoFar = current[0];
            int currNode = (int)current[1];

            if (maxDangerSoFar > dist[currNode]) continue;

            for (Edge neighbour : graph.get(currNode)) {
                long nextDanger = Math.max(maxDangerSoFar, neighbour.weight);
                
                if (nextDanger < dist[neighbour.to]) {
                    dist[neighbour.to] = nextDanger;
                    pq.offer(new long[]{nextDanger, neighbour.to});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                sb.append("-1").append(" ");
            } else {
                sb.append(dist[i]).append(" ");
            }
        }

        pw.println(sb.toString());
        pw.close();
    }
}  