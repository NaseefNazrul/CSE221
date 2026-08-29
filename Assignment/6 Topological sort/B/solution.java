
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

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        } // Made the graph




        int [] color = new int[n+1];
        int max_total = 0;
        for (int i = 1; i <= n; i++) { // for disconnected components
            if (color[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        color[i] = 1;
        int r = 0;
        int h = 0;
        r++;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbour : graph.get(current)) {
                
                if (color[neighbour] == 0) {
                    queue.offer(neighbour);
                    if (color[current] == 1) { 
                        color[neighbour] = 2;
                        h++;
                    }
                    else {
                        color[neighbour] = 1;
                        r++;
                    }
                }
            }
        }
        max_total += Math.max(r, h);
            }
        }
        
        pw.print(max_total);
        pw.close();
    }
}