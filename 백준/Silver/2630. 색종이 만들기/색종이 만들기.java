import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] grid;
    private static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, n);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void cutPaper(int row, int col, int size) {
        if(isEqual(row, col, size)) {
            answer[grid[row][col]]++;
            return;
        }

        int newSize = size / 2;
        for (int i = 0; i < 4; i++) {
            cutPaper(row + (i/2)*newSize, col + (i%2)*newSize, newSize);
        }
    }

    private static boolean isEqual(int row, int col, int size) {
        int color = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}