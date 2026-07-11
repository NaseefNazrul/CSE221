
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class solution {
    public static long countPairs(long[] arr, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        long total = countPairs(arr, l, m) + countPairs(arr, m + 1, r);

        // Now count the pairse using binary search on the left arr and linear search on the right arr
        for (int j = m + 1; j <= r; j++) {
            // threshold from the right array
            long threshold = arr[j] * arr[j];
            // binary implementation
            int lo = l, hi = m;
            int firstGreater = m + 1; // keeping this as the norm so later can be used for check if none exists
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (arr[mid] > threshold) {
                    firstGreater = mid;
                    hi = mid - 1;      // try to find an even smaller index
                } else {
                    lo = mid + 1;
                }
            }
            if (firstGreater <= m) {
                total += (m - firstGreater + 1);
            }
        }

        merge(arr, l, m, r);
        return total;
    }

    // Normal merge sort
    public static void merge(long [] arr, int left, int mid, int right) {
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
        int i = 0, j = 0, k = left;
        while (i < left_arr.length && j < right_arr.length) {
            if (left_arr[i] > right_arr[j]) {
                arr[k] = right_arr[j];
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

        pw.println(countPairs(arr, 0, n-1));
        pw.close();
    }
}