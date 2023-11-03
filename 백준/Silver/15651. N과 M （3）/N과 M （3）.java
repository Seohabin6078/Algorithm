import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int num;
    private static int[] basket;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        basket = new int[num];
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == num) {
            for (int i : basket) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            basket[depth] = i;
            dfs(depth + 1);
        }
    }
}