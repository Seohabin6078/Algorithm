import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] grid;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        quadTree(0, 0, n);
        System.out.println(sb);
    }

    private static void quadTree(int row, int col, int size) {
        if (isEqual(row, col, size)) {
            sb.append(grid[row][col]);
            return;
        }

        sb.append("(");

        int newSize = size / 2;
        for (int i = 0; i < 4; i++) {
            quadTree(row + (i / 2) * newSize, col + (i % 2) * newSize, newSize);
        }

        sb.append(")");
    }

    private static boolean isEqual(int row, int col, int size) {
        int std = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (std != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}