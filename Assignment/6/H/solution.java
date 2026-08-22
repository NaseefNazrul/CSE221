
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;





public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String wordA = st.nextToken();
        String wordB = st.nextToken();

        if (wordA.equals(wordB)) {
            pw.println("YES");
            pw.close();
            return;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String w = br.readLine().trim();
            int u = w.charAt(0) - 'A';
            int v = w.charAt(w.length()-1) - 'A';
            graph.get(u).add(v);
        }

        int start = wordA.charAt(wordA.length()-1) - 'A';
        int end = wordB.charAt(0) - 'A';
        if (canReach(start, end, graph)) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }

        pw.close();

    }

    private static boolean canReach(int start, int end, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[26];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == end) {
                return true;
            }

            for (int letter : graph.get(curr)) {
                if (visited[letter] == false) {
                    visited[letter] = true;
                    queue.offer(letter);
                }
            }
        }
        return false;
    }
}