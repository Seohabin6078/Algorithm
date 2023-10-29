import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(func(a, b, c));
    }

    private static long func(long a, long b, long c) { // a를 b번 곱하고 c로 나눈 나머지를 구하는 함수
        if (b == 1) {
            return a % c;
        }

        long val = func(a, b / 2, c);

        if (b % 2 == 0) {
            return val * val % c;
        }

        return (val * val % c) * a % c;
    }
}