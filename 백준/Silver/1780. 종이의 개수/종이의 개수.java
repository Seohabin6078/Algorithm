import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] grid;
    private static int[] answer = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }
        func(0, 0, n);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void func(int startX, int startY, int size) {
        if (isEqual(startX, startY, size)) {
            answer[grid[startX][startY]]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 9; i++) {
            func(startX + (i/3)*newSize, startY + (i%3)*newSize, newSize);
        }
    }

    private static boolean isEqual(int startX, int startY, int size) {
        int std = grid[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (std != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}