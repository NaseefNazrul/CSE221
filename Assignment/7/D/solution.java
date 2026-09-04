
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
        int d = Integer.parseInt(st.nextToken());

        int [] nodeW = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nodeW[i] = Integer.parseInt(st.nextToken());
        }   

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[s] = nodeW[s];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{nodeW[s], s});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currCost = current[0];
            int u = (int) current[1];

            if (currCost > dist[u]) continue;
            if (u == d) break;

            for (int neighbour : graph.get(u)) {
                if (dist[u] +  nodeW[neighbour] < dist[neighbour]) {
                    dist[neighbour] = dist[u] +  nodeW[neighbour] ;
                    pq.offer(new long[]{dist[neighbour] , neighbour});
                }
            }
        }

        if (dist[d] == Long.MAX_VALUE) {
            pw.println("-1");
        } else {
            pw.println(dist[d]);
        }
        pw.close();
    }
}  