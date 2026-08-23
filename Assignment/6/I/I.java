import java.io.*;
import java.util.*;

public class I {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // 1. Read words
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        boolean[] used = new boolean[26];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();

            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                used[ch - 'a'] = true;
            }
        }


        // 2. Create graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        int[] before = new int[26];
        boolean[][] edge = new boolean[26][26];


        // 3. Compare adjacent words
        for (int i = 0; i < n - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int min = Math.min(first.length(), second.length());

            boolean found = false;

            for (int j = 0; j < min; j++) {

                char a = first.charAt(j);
                char b = second.charAt(j);

                // First different letters
                if (a != b) {

                    int from = a - 'a';
                    int to = b - 'a';

                    // Add: from → to
                    if (edge[from][to] == false) {
                        edge[from][to] = true;

                        graph.get(from).add(to);
                        before[to]++;
                    }

                    found = true;
                    break;
                }
            }

            // abc before ab is impossible
            if (found == false && first.length() > second.length()) {
                pw.print(-1);
                pw.close();
                return;
            }
        }


        // 4. Put free letters in PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int total = 0;

        for (int i = 0; i < 26; i++) {

            if (used[i]) {
                total++;

                if (before[i] == 0) {
                    pq.add(i);
                }
            }
        }


        // 5. Topological Sort
        StringBuilder answer = new StringBuilder();

        while (!pq.isEmpty()) {

            int current = pq.poll();

            answer.append((char)(current + 'a'));

            for (int i = 0; i < graph.get(current).size(); i++) {

                int next = graph.get(current).get(i);

                before[next]--;

                if (before[next] == 0) {
                    pq.add(next);
                }
            }
        }


        // If all letters were not processed → cycle
        if (answer.length() != total) {
            pw.print(-1);
        } else {
            pw.print(answer);
        }

        pw.close();
    }
}