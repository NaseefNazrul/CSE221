
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
     public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
 
        // position inputs
        st = new StringTokenizer(br.readLine());
        int p1= Integer.parseInt(st.nextToken());
        int p2= Integer.parseInt(st.nextToken());
        // store the moves
        int[][] moves=new int[8][2];
        int count = 0;
 
        // bottom left
        if (p1>1 && p2>1) {
            moves[count][0]=p1-1;
            moves[count][1]=p2-1;
            count++;
        }
        // left
        if (p1>1) {
            moves[count][0]=p1-1;
            moves[count][1]=p2;
            count++;
        }
        // top left
        if (p1>1 && p2<N) {
            moves[count][0]=p1-1;
            moves[count][1]=p2+1;
            count++;
        }
        // down
        if (p2>1) {
            moves[count][0]=p1;
            moves[count][1]=p2-1;
            count++;
        }
        // up
        if (p2<N) {
            moves[count][0]=p1;
            moves[count][1]=p2+1;
            count++;
        }
        // bottom right
        if (p1<N && p2>1) {
            moves[count][0]=p1+1;
            moves[count][1]=p2-1;
            count++;
        }
        // right
        if (p1<N) {
            moves[count][0]=p1+1;
            moves[count][1]=p2;
            count++;
        }
        // top right
        if (p1<N && p2<N) {
            moves[count][0]=p1+1;
            moves[count][1]=p2+1;
            count++;
        }
        //printing
        pw.println(count);
        for (int i=0;i<count;i++) {
 
                pw.println(moves[i][0] +" "+ moves[i][1]);

        }
        pw.close();
    }
}