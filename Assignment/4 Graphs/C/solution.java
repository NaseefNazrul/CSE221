
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] graph=new int[n][n];


        for(int i=0;i<n;i++){
            st =new StringTokenizer(br.readLine());
            int k  =Integer.parseInt(st.nextToken());
            for (int j=0;j<k;j++) {
                int edges = Integer.parseInt(st.nextToken());
                graph[i][edges]=1;
            }
        }


        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                pw.print(graph[i][j]+" ");
            }
            pw.println();
        }
        pw.close();
    }

}