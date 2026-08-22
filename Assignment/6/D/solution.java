
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;



public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int [] resA = bfs(1, n, graph);
        int [] resB = bfs(resA[0], n, graph);

        pw.println(resB[1]);
        pw.println(resA[0] + " " + resB[0]);
        pw.close();
    }

    private static int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        int[] d = new int[n+1];
        Arrays.fill(d, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        d[start] = 0;

        int furthest = start;
        int maxd = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (d[curr] > maxd) {
                maxd = d[curr];
                furthest = curr;
            }

            for (int neighbour : adj.get(curr)) {
                if (d[neighbour] == -1) {
                    d[neighbour] = d[curr] + 1;
                    queue.offer(neighbour);
                }
            }
        }
        return new int[]{furthest,maxd};
    }
}