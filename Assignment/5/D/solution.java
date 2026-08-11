
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;



public class solution {

    public static int[] bfs(ArrayList<ArrayList<Integer>> graph, int start, int end) {
        int [] parent = new int[graph.size()];
        int [] visited = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = 1;
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : graph.get(current)) {
                if (visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    parent[neighbour] = current;
                    queue.offer(neighbour);
                    if (neighbour == end) {
                        return parent;
                    }
                } // Normal bfs ahh
            }

        }
        return parent; // Just gonna return the parent cuz we will trace from here 
    }

    public static ArrayList<Integer> path(int[] parent, int start, int end) {
        if (start != end && parent[end] == 0) {
            return null;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int curr = end;
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // Take inputs

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>()); // Add empty arraylists
        }

        // update the graph with the edges input
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        int [] parent_sk = bfs(graph,start,k);
        ArrayList<Integer> path_sk = path(parent_sk, start, k);

        int [] parent_ke = bfs(graph, k, end);
        ArrayList<Integer> path_ke = path(parent_ke,k, end);

        if (path_ke == null || path_sk == null) {
            pw.println(-1);
        }
        else {
            ArrayList<Integer> ans_path = new ArrayList<>();
            for (int i = 0; i < path_sk.size(); i++) {
                ans_path.add(path_sk.get(i));
            }
            for (int i = 1; i < path_ke.size(); i++) {
                ans_path.add(path_ke.get(i));
            }

            StringBuilder path = new StringBuilder();
            for (int i = 0; i < ans_path.size(); i++) {
                path.append(ans_path.get(i)).append(" ");
            }

            pw.println(ans_path.size()-1);
            pw.print(path);
        }
        pw.close();
    }
}