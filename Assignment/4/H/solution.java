import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
        public static void main(String[] args)throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] graph=new int[n+1][n];
        int[] neighbors=new int[n+1];

        // making the graph
        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                if(getGCD(i,j)==1){
                    graph[i][neighbors[i]]=j;
                    neighbors[i]++;
                    graph[j][neighbors[j]]=i;
                    neighbors[j]++;
                }
            }
        }
        
        // output
        for(int i=0;i<q;i++){
            st =new StringTokenizer(br.readLine());
            int node=Integer.parseInt(st.nextToken());
            int out=Integer.parseInt(st.nextToken());
            if (out>neighbors[node]) {
                pw.println(-1);

            }else{
                pw.println(graph[node][out-1]);
            }
        }
        pw.close();
    }


    public static int getGCD(int x , int y){
        while(y!=0){
            int temp=x%y;
            x=y;
            y=temp;
        }
        return x;
    }
}