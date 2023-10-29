import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        func(size, r, c);

        System.out.println(count);
    }

    public static void func(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) {
            func(size/2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            count = count + (size/2)*(size/2);
            func(size/2, r, c-size/2);
        } else if (r >= size / 2 && c < size / 2) {
            count = count + (size/2)*(size/2)*2;
            func(size/2, r-size/2, c);
        } else {
            count = count + (size/2)*(size/2)*3;
            func(size/2, r-size/2, c-size/2);
        }
    }
}