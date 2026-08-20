
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i< n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        int [] order = new int[n];
        int [] parent = new int[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        int [] visited = new int[n+1];
        queue.offer(root);
        visited[root] = 1;
        parent[root] = -1;
        int idx = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            order[idx++] = curr;
            for (int neighbour : graph.get(curr)) {
                if (visited[neighbour] != 1) {
                    visited[neighbour] = 1;
                    queue.offer(neighbour);
                    parent[neighbour] = curr;
                }
            }
        }

        int [] sub_arr_size = new int[n+1];
        Arrays.fill(sub_arr_size,1);
        for (int i = n-1; i >= 0; i--) {
            int curr = order[i];
            int p = parent[curr];
            if (p != -1) {
                sub_arr_size[p] += sub_arr_size[curr];
            }
        }

        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < queries; i++) {
            int q = Integer.parseInt(br.readLine());
            pw.println(sub_arr_size[q]);
        }
        
        pw.close();
    }
}