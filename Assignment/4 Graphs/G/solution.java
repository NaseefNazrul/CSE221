import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // start
        int[] p1 = new int[k];
        int[] p2 = new int[k];
        boolean[][] attack = new boolean[row+1][column+1];

        //assigning positions
        for(int i=0;i<k;i++){
            st =new StringTokenizer(br.readLine());
            p1[i]=Integer.parseInt(st.nextToken());
            p2[i]=Integer.parseInt(st.nextToken());
            attack[p1[i]][p2[i]]=true;
        }


        // Knight Moves
        int[] x_moves = {-2,-2,-1,-1,1,1,2,2};
        int[] y_moves = {-1,1,-2,2,-2,2,-1,1};
 
        // checking attacks
        for (int i=0;i<k;i++) {
            for(int j=0;j<8;j++){
                int check1=p1[i]+x_moves[j];
                int check2=p2[i]+y_moves[j];
                if(check1>=1 && check1<=row && check2>=1 && check2<=column){
                    if(attack[check1][check2]){
                        pw.print("YES");
                        pw.close();
                        return;
                    }
                }
            }
        }
        //printing NO
        pw.print("NO");
        pw.close();
    }
}