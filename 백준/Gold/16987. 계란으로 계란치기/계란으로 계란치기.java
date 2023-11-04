import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] dura;
    private static int[] weight;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dura = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dura[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int count) {
        if (idx == n) {
            answer = Math.max(answer, count);
            return;
        }

        if (dura[idx] <= 0 || count == n - 1) {
            dfs(idx + 1, count);
            return;
        }

        int tempCount = count;
        for (int i = 0; i < n; i++) {
            if(i != idx && dura[i] > 0) {
                // 계란끼리 부딪혀보기
                hitEggs(idx, i);
                if(dura[idx] <= 0) count++;
                if(dura[i] <= 0) count++;
                dfs(idx + 1, count);
                recoveryEggs(idx, i);
                count = tempCount;
            }
        }
    }

    private static void hitEggs(int idx, int i) {
        dura[idx] = dura[idx] - weight[i];
        dura[i] = dura[i] - weight[idx];
    }

    private static void recoveryEggs(int idx, int i) {
        dura[idx] = dura[idx] + weight[i];
        dura[i] = dura[i] + weight[idx];
    }
}