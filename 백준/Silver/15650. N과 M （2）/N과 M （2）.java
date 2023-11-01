import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] vis;
    private static int[] basket;
    private static int num;
    private static int n;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        basket = new int[num];
        vis = new boolean[n + 1];
        print(1, 0);
        System.out.print(sb);
    }

    private static void print(int start, int depth) {
        if (depth == num) {
            for (int i : basket) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                basket[depth] = i;
                print(i + 1, depth + 1);
                vis[i] = false;
            }
        }
    }
}