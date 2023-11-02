import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] list;
    private static int answer = 0;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        nQueen(0);
        System.out.println(answer);
    }

    private static void nQueen(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPossible(list, row, i)) {
                list[row] = i;
                nQueen(row + 1);
            }
        }
    }

    private static boolean isPossible(int[] list, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (list[i] == col || Math.abs(i - row) == Math.abs(list[i] - col)) {
                return false;
            }
        }
        return true;
    }
}