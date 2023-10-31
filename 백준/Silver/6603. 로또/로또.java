import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int k;
    private static int[] data;
    private static int[] basket = new int[6];
    private static boolean[] vis;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;
            data = new int[k];
            for (int i = 0; i < k; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            vis = new boolean[k];
            lotto(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void lotto(int start, int depth) {
        if (depth == 6) {
            for (int i : basket) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (!vis[i]) {
                basket[depth] = data[i];
                vis[i] = true;
                lotto(i, depth + 1);
                vis[i] = false;
            }
        }
    }
}