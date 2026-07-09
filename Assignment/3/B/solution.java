
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {

    public static long mergeSort(long [] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        else {
            int mid = left + (right - left) / 2;
            long a = mergeSort(arr, left, mid);
            long b = mergeSort(arr, mid + 1, right);
            return merger(arr, left, mid, right) + a + b;  // will return the total number of inversions from both the sides and this recursion itself
        }
    }

    public static long merger(long [] arr, int left, int mid, int right) {
        // make copies of left and right
        long [] left_arr = new long[mid - left + 1];
        long [] right_arr = new long[right - mid];
        for (int i = 0; i < left_arr.length; i++) {
            left_arr[i] = arr[left+i];
        }
        for (int i = 0; i < right_arr.length; i++) {
            right_arr[i] = arr[mid + 1 + i];
        }


        // onto sorting 
        long answer = 0; // counts the number of inversions
        int i = 0, j = 0, k = left;
        while (i < left_arr.length && j < right_arr.length) {
            if (left_arr[i] > right_arr[j]) {
                arr[k] = right_arr[j];
                if (left_arr[i] > right_arr[j]*right_arr[j]) {
                    answer += (left_arr.length - i);
                }
                j++;
            }
            else {
                arr[k] = left_arr[i];
                i++;
            }
            k++;
        }

        // Fill the rest of the arrays
        while (i < left_arr.length) arr[k++] = left_arr[i++];
        while (j < right_arr.length) arr[k++] = right_arr[j++];

        return answer;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer num = new StringTokenizer(br.readLine().trim());
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(num.nextToken());
        }

        pw.println(mergeSort(arr, 0, n-1));
        for (int i = 0; i < n; i++) {
            pw.print(arr[i] + " ");
        }
        pw.close();
    }
}