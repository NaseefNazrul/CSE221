
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int[] start=new int[e];
        int[] end=new int[e];
        int[] edge=new int[n+1];
        st =new StringTokenizer(br.readLine());
        for(int i=0;i<e;i++){
            start[i]=Integer.parseInt(st.nextToken());
        }
        st =new StringTokenizer(br.readLine());
        for(int i=0;i<e;i++){
            end[i]=Integer.parseInt(st.nextToken());
        } // input
 

        // degree of the graph
        for(int i=0; i<e; i++){
            edge[start[i]]++;
            edge[end[i]]++;
        }

        // compare the degree of the graph
        int odd = 0;
        for(int i=1; i<=n; i++){
            if(edge[i] % 2== 1)odd++;
        }
        if(odd == 0|| odd == 2)pw.println("YES");
        else pw.println("NO");
        pw.close();
    }
}