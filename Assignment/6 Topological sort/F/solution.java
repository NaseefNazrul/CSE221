
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
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        int [] dist = new int[10000]; // 0000-9999 is 100000 combinations
        Arrays.fill(dist, -1);

        for (int i = 0; i < n; i++) {
            int forbidden = Integer.parseInt(br.readLine());
            dist[forbidden] = -2;
        }


        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        dist[s] = 0;
        int ans = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == c) {
                ans = dist[curr];
                break;
            }

            for (int neighbour : getNeighbours(curr)) {
                if (dist[neighbour] == -1) {
                    dist[neighbour] = dist[curr] + 1;
                    queue.add(neighbour);
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

    private static ArrayList<Integer> getNeighbours(int combination) {
        ArrayList<Integer> neighbours = new ArrayList<>();

        int x1 = (combination / 1000);
        int x2 = (combination / 100) % 10;
        int x3 = (combination / 10) % 10;
        int x4 = combination % 10;

        // for x1
        neighbours.add(((x1+1)%10) * 1000 + x2 * 100 + x3 * 10 + x4);
        neighbours.add(((x1+9)%10) * 1000 + x2 * 100 + x3 * 10 + x4);

        // for x2
        neighbours.add(x1 * 1000 + ((x2+1)%10) * 100 + x3 * 10 + x4);
        neighbours.add(x1 * 1000 + ((x2+9)%10) * 100 + x3 * 10 + x4);

        // for x3
        neighbours.add(x1 * 1000 + x2 * 100 + ((x3+1)%10) * 10 + x4);
        neighbours.add(x1 * 1000 + x2 * 100 + ((x3+9)%10) * 10 + x4);

        // for x4
        neighbours.add(x1 * 1000 + x2 * 100 + x3 * 10 + ((x4+1)%10));
        neighbours.add(x1 * 1000 + x2 * 100 + x3 * 10 + ((x4+9)%10));

        return neighbours;
    }
}