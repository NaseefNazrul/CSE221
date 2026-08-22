
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class solution {
    private static final int[] dx = {-2, -2, -1, -1,  1,  1,  2,  2};
    private static final int[] dy = {-1,  1, -2,  2, -2,  2, -1,  1}; // How a knight moves
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        if (x1 == x2 && y1 == y2) {
            pw.println(0);
            return;
        }

        pw.println(bi_bfs(n, x1, y1, x2, y2));
        pw.close();
    }

    public static int bi_bfs(int n, int x1, int y1, int x2, int y2) {
        int [][] start_visited = new int[n+1][n+1]; 
        int [][] end_visited = new int[n+1][n+1]; // Stores distance

        Queue<int[]> start_queue = new ArrayDeque<>();
        start_queue.offer(new int[] {x1,y1});
        start_visited[x1][y1] = 1;

        Queue<int[]> end_queue = new ArrayDeque<>();
        end_queue.offer(new int[] {x2,y2});
        end_visited[x2][y2] = 1;

        while (!start_queue.isEmpty() && !end_queue.isEmpty()) {
            int ans = 0;
            
            if (start_queue.size() <= end_queue.size()) {
                ans = expandLevel(start_queue, start_visited, end_visited, n);
            }
            else {
                ans = expandLevel(end_queue, end_visited, start_visited, n);
            }

            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    public static int expandLevel(Queue<int[]> queue, int[][] self_visited, int[][] other_visited, int n) {
        int qlen = queue.size();
        
        for (int i = 0; i < qlen; i++) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cd = self_visited[cx][cy] - 1;

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    if (other_visited[nx][ny] > 0) {
                        // they two meet
                        return cd + 1 + (other_visited[nx][ny] - 1);
                    }


                    if (self_visited[nx][ny] == 0) {
                        self_visited[nx][ny] = cd + 2;
                        queue.offer(new int[] {nx,ny});
                    }
                }
            }
        }
        return -1;
    }
}