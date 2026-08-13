
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class solution {
    public static boolean [][] visited;
    public static int bfs(char [][] grid, int row, int col) {
        // We need to complete 4 movements 
        // up down left right 
        // gotta take care of the boundaries 
        Integer[] cords = new Integer[2];
        cords[0] = row;
        cords[1] = col;
        Queue<Integer[]> q = new ArrayDeque<>();
        q.offer(cords);
        visited[cords[0]][cords[1]] = true;
        int border_x = grid.length;
        int border_y = grid[0].length;
        int diamonds = 0;
        while (!q.isEmpty()) {
            Integer [] curr = q.poll();
            if (grid[curr[0]][curr[1]] == 'D') {
                diamonds++;
            }
            else if (grid[curr[0]][curr[1]] == '#') {
                continue;
            }

            int curr_x = curr[0];
            int curr_y = curr[1];
            // up 
            while ((curr_y-1 != -1) && (visited[curr_x][curr_y-1] != true)) {
                q.offer(new Integer[]{curr_x,curr_y-1});
                visited[curr_x][curr_y-1] = true;
            }

            curr_x = curr[0];
            curr_y = curr[1];

            // down
            while ((curr_y+1 < border_y) && (visited[curr_x][curr_y+1] != true)) {
                q.offer(new Integer[]{curr_x,curr_y+1});
                visited[curr_x][curr_y+1] = true;
            }
            curr_x = curr[0];
            curr_y = curr[1];
            // left
            while ((curr_x-1 != -1) && (visited[curr_x-1][curr_y] != true)) {
                q.offer(new Integer[]{curr_x-1,curr_y});
                visited[curr_x-1][curr_y] = true;
            }
            curr_x = curr[0];
            curr_y = curr[1];
            //right
            while ((curr_x+1 < border_x) && (visited[curr_x+1][curr_y] != true)) {
                q.offer(new Integer[]{curr_x+1,curr_y});
                visited[curr_x+1][curr_y] = true;
            }
        }
        return diamonds;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        char [][] grid = new char[r][h];
        visited = new boolean[r][h];

        for (int row = 0; row < r; row++) {
            String line = br.readLine().trim();
            for (int col = 0; col < h; col++) {
                grid[row][col] = line.charAt(col);
            }
        }

        // Lets iterate through the grid and perform bfs wherever new node is visited 
        int MaxD = 0;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < h; col++) {
                if (visited[row][col] == false) {
                    int temp = bfs(grid, row, col);
                    if (temp > MaxD) {
                        MaxD = temp;
                    }
                }
            }
        }
        pw.println(MaxD);
        pw.close();
    }
}