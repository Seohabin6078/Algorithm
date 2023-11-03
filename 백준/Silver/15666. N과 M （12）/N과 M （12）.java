import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // n과 m (9) 이 문제의 핵심은 같은 depth에서 같은 숫자를 넣으면 안된다.
    private static int n;
    private static int m;
    private static int[] data;
    private static int[] basket;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        data = new int[n];
        basket = new int[m];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(basket[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < n; i++) {
            if (before != data[i]) {
                basket[depth] = data[i];
                before = data[i];
                dfs(depth + 1, i);
            }
        }
    }
}