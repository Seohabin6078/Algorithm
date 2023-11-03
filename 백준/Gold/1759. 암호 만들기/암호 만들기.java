import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int num;
    private static char[] data;
    private static char[] basket;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        data = new char[n];
        basket = new char[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(data);
        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == num) {
            if (isPossible()) {
                for (char c : basket) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < n; i++) {
            basket[depth] = data[i];
            dfs(depth + 1, i + 1);
        }
    }

    private static boolean isPossible() {
        int count = 0;
        for (char c : basket) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        int temp = num - count;
        if (temp >= 2 && count >= 1) {
            return true;
        }
        return false;
    }
}