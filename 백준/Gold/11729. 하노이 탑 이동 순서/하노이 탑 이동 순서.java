import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int k = (int) Math.pow(2, n) - 1;
        System.out.println(k);

        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int des) {
        // n이 1인 경우 한 개만 그냥 목적지로 이동시키면 된다.
        if (n == 1) {
            sb.append(start + " " + des + "\n");
            return;
        }

        // n이 1이 아닌 경우 n-1개를 가운데로 옮기면 된다.
        hanoi(n-1, start, des, mid);

        // 출발지에 있는 n번째 원판을 목적지로 옮긴다.
        sb.append(start + " " + des + "\n");

        // n-1개를 가운데에서 목적지로 옮긴다.
        hanoi(n-1, mid, start, des);
    }
}