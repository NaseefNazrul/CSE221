
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;



public class solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        int[] component = new int[n+1];
        int comp_id = 1;
        
        for(int i = 1; i<=n;i++) {
            if (component[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                component[i] = comp_id;

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int neighbour : graph.get(curr)) {
                        if (component[neighbour] == 0) {
                            component[neighbour] = comp_id;
                            queue.offer(neighbour);
                        }
                    }
                }
                comp_id++;
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
    
            if (component[u] == component[v]) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }
    
}