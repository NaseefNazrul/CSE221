
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
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        long[] dist1 = new long[n + 1];
        long[] dist2 = new long[n + 1];
        Arrays.fill(dist1, Long.MAX_VALUE);
        Arrays.fill(dist2, Long.MAX_VALUE);

        dist1[s] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, s});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currDist = current[0];
            int currNode = (int) current[1];

            if (currDist > dist2[currNode]) continue;

            for (Edge edge : graph.get(currNode)) {
                long newDist = currDist + edge.weight;
                
                if (newDist < dist1[edge.to]) {
                    dist2[edge.to] = dist1[edge.to];
                    dist1[edge.to] = newDist;
                    pq.offer(new long[]{dist1[edge.to], edge.to});
                    if (dist2[edge.to] != Long.MAX_VALUE) {
                        pq.offer(new long[]{dist2[edge.to], edge.to});
                    }
                }
                else if (newDist > dist1[edge.to] && newDist < dist2[edge.to]) {
                    dist2[edge.to] = newDist;
                    pq.offer(new long[]{dist2[edge.to], edge.to});
                }
            }
        }

        if (dist2[d] == Long.MAX_VALUE) {
            pw.println("-1");
        } else {
            pw.println(dist2[d]);
        }
        pw.close();
    }
}  