import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] node = new int[10000];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            node[idx++] = Integer.parseInt(s);
        }
        postOrder(0, idx - 1);
        System.out.print(sb);
    }

    private static void postOrder(int start, int end) {
        if (start > end) {
            return;
        }

        int mid = start + 1;
        while (mid <= end && node[start] > node[mid]) {
            mid++;
        }

        postOrder(start + 1, mid - 1);
        postOrder(mid, end);
        sb.append(node[start]).append("\n");
    }
}