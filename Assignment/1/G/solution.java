
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class solution {
    public static int merge_sort(int [][] arr, int p, int r) {
        if (p >= r) {
            return 0;
        }

        int q = (p+r)/2;
        int left = merge_sort(arr,p,q);
        int right = merge_sort(arr,q+1,r);
        return merger(arr,p,q,r) + left + right;
    }

    public static int merger(int[][]arr, int p, int q, int r) {
        int swaps = 0;
        int l_len = q - p + 1;
        int r_len = r - q;

        int [][] l_arr = new int[l_len][2];
        int [][] r_arr = new int[r_len][2];

        for (int i = 0; i < l_len; i++) {
            l_arr[i] = arr[p+i];
        }

        for (int i = 0; i < r_len; i++) {
            r_arr[i] = arr[q+i+1];
        } // TEMP ARR MADE


        // SWAPS
        int left = 0;
        int right = 0;
        int k = p;

        while (left < l_len && right < r_len) {
            if (l_arr[left][1] == r_arr[right][1]) {
                if (l_arr[left][0] > r_arr[right][0]) {
                    arr[k] = r_arr[right];
                    right++;
                    swaps++;
                    System.out.println("same id bid");
                }
                else {
                    arr[k] = l_arr[left];
                    left++;
                    System.out.println("same but id smol");
                }
            }
            else if (l_arr[left][1] < r_arr[right][1]) {
                arr[k] = r_arr[right];
                right++;
                swaps++;
                System.out.println("right big");
            }
            else {
                arr[k] = l_arr[left];
                left++;
                System.out.println("left big");
            }
            k++;
        }


        // remainder of the arr
        while (left < l_len) {
            arr[k] = l_arr[left];
            left++;
            k++; 
            System.out.println("remaing left");
        }

        while (right < r_len) {
            arr[k] = r_arr[right];
            right++;
            k++;
            System.out.println("remaining right");
        }

        return swaps;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tests; i++) {
            // MAKING ARRAY 
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                continue;
            }
            int [][] arr = new int[n][2];
            StringTokenizer id = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                arr[j][0] = Integer.parseInt(id.nextToken());
            }
            StringTokenizer marks = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                arr[j][1] = Integer.parseInt(marks.nextToken());
            }


            // now working on swaps, merge sort
            int swaps = merge_sort(arr, 0, n-1);

            // output
            pw.println("Minimum swaps: " + swaps);
            for (int j = 0; j < n; j++) {
                pw.println("ID: " + arr[j][0] + " Mark: " + arr[j][1]);
            }
        }

        pw.close();
    }
}
