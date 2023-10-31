import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], ' ');
        }
        star(0, n - 1, n);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : grid) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int row, int col, int size) {
        if (size == 3) {
            grid[row][col] = '*';
            grid[row + 1][col - 1] = '*';
            grid[row + 1][col + 1] = '*';
            grid[row + 2][col - 2] = '*';
            grid[row + 2][col - 1] = '*';
            grid[row + 2][col] = '*';
            grid[row + 2][col + 1] = '*';
            grid[row + 2][col + 2] = '*';
            return;
        }

        int newSize = size / 2;
        star(row, col, newSize);
        star(row + newSize, col - newSize, newSize);
        star(row + newSize, col + newSize, newSize);
    }
}