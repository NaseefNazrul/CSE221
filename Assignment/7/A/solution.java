
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

        StringTokenizer u = new StringTokenizer(br.readLine());
        StringTokenizer v = new StringTokenizer(br.readLine());
        StringTokenizer w = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(Integer.parseInt(u.nextToken())).add(new Edge(Integer.parseInt(v.nextToken()), Long.parseLong(w.nextToken())));
        }

        long[] dist = new long[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[s] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, s});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currDist = current[0];
            int currNode = (int)current[1];

            if (currDist > dist[currNode]) continue;
            if (currNode == d) break;

            for (Edge neighbour : graph.get(currNode)) {
                if (dist[currNode] + neighbour.weight < dist[neighbour.to]) {
                    dist[neighbour.to] = dist[currNode] + neighbour.weight;
                    parent[neighbour.to] = currNode;
                    pq.offer(new long[]{dist[neighbour.to],neighbour.to});
                }
            }
        }

        if (dist[d] == Long.MAX_VALUE) {
            pw.println(-1);
            pw.close();
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int curr = d; curr != -1; curr = parent[curr]) {
            path.add(curr);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = path.size()-1; i >= 0; i--) {
            ans.append(path.get(i)).append(" ");
        }

        pw.println(dist[d]);
        pw.println(ans);
        pw.close();
    }
}  