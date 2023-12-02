import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            int l = 0, r = n-1;
            boolean isFound = false;
            while (l <= r) {
                int mid = (l-r)/2 + r;
                if (data[mid] == k) {
                    System.out.println(1);
                    isFound = true;
                    break;
                } else if (data[mid] > k) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if(!isFound) System.out.println(0);
        }
    }
}