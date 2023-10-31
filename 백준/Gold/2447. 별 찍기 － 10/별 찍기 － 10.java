import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static char[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        star(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int row, int col, int size, boolean blank) {
        if (blank) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    grid[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            grid[row][col] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 9; i++) {
            boolean newBlank = false;
            if(i==4) newBlank = true;
            star(row + (i / 3) * newSize, col + (i % 3) * newSize, newSize, newBlank);
        }
    }
}