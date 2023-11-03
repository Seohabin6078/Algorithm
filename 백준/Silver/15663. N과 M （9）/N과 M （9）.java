import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[] data;
    private static int[] basket;
    private static boolean[] vis;
    private static List<int[]> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        data = new int[n];
        basket = new int[m];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            if(!isExist()) {
                for (int i = 0; i < m; i++) {
                    sb.append(basket[i]).append(" ");
                }
                sb.append("\n");
                int[] ints = Arrays.copyOf(basket, m);
                list.add(ints);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                basket[depth] = data[i];
                dfs(depth + 1);
                vis[i] = false;
            }
        }
    }

    private static boolean isExist() {
        for (int[] ints : list) {
            boolean temp = true;
            for (int i = 0; i < m; i++) {
                if (ints[i] != basket[i]) {
                    temp = false;
                }
            }
            if(temp) return true;
        }
        return false;
    }
}