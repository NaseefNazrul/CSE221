
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Edge [] adj_list = new Edge[n];
        int [] start = new int[e];
        int [] end = new int[e];
        int [] weight = new int[e];

        StringTokenizer num = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < e; i++) {
            start[i] = Integer.parseInt(num.nextToken());
        }

        StringTokenizer num1 = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < e; i++) {
            end[i] = Integer.parseInt(num1.nextToken());
        }

        StringTokenizer num2 = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < e; i++) {
            weight[i] = Integer.parseInt(num2.nextToken());
        } // These are all the inputs collected 



        // Now time to work on the edges
        for (int i = 0; i < e; i++) {
            insert_edge(adj_list, start[i], end[i], weight[i]);
        }


        for (int i = 0; i < n; i++) {
            Edge curr = adj_list[i];
            pw.print((i+1) + ": ");
            while (curr!= null) {
                pw.print("("+ (curr.destination+1) + "," + curr.weight + ") ");
                curr = curr.next;
            }
            pw.println();
        }

        pw.close();

        

    }

    public static void insert_edge(Edge [] arr, int start, int end, int weight) { // Dont ask me why I made a whole ass method
        start--;
        end--;
        Edge current = arr[start];
        
        if (current == null) {
            arr[start] = new Edge(end, weight, null);
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Edge(end, weight, null);
        }
    }
}

class Edge { // Going to use this like a hashmap linked list 
    int destination;
    Edge next;
    int weight;

    Edge (int d, int w, Edge n) {
        this.destination = d;
        this.weight = w;
        this.next = n;
    }
}
