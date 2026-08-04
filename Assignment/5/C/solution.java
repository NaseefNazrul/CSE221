import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int cities = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= cities; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int [] u = new int[roads];
        int [] v = new int[roads];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < roads ;i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < roads ;i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < roads; i++) {
            graph.get(u[i]).add(v[i]);
            graph.get(v[i]).add(u[i]);
        } 

        for (int i = 1; i<= cities; i++) {
            Collections.sort(graph.get(i));
        } // made the graph 

        
        boolean [] visited = new boolean[cities+1];
        int [] parent = new int[cities+1];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        visited[start] = true;
        queue.offer(start);
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.append(current).append(" ");

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    parent[neighbour] = current;
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        } // BFS search


        int temp = end;
        Deque<Integer> stack = new ArrayDeque<>();
        while (temp != start ) {
            stack.push(temp);
            temp = parent[temp];
        } // So that the path gets reversed using a stack
        stack.push(temp);

        StringBuilder path = new StringBuilder();
        int count = -1;
        while (!stack.isEmpty()) {
            path.append(stack.pop()).append(" ");
            count++;
        }
        pw.println(count);
        pw.println(path);
        pw.close();
    }
}