import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int row;
    private static int col;
    private static List<int[]> cctvList = new ArrayList<>();
    private static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] grid = new int[row][col];


        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                grid[i][j] = i1;
                if (i1 >= 1 && i1 <= 5) {
                    cctvList.add(new int[]{i, j, i1});
                }
            }
        }

        bt(0, grid);
        System.out.println(min);
    }

    private static void bt(int depth, int[][] grid) {
        if (depth == cctvList.size()) {
            int count = countZeroNum(grid);
            min = Math.min(min, count);
            return;
        }

        int[] ints = cctvList.get(depth);
        int x = ints[0], y = ints[1], cctvNum = ints[2];
        int[][] temp;
        if (cctvNum == 1) {
            temp = copy(grid);
            checkLeft(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkRight(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkDown(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkUp(x, y, temp);
            bt(depth + 1, temp);

        } else if (cctvNum == 2) {
            temp = copy(grid);
            checkLeft(x, y, temp);
            checkRight(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkUp(x, y, temp);
            checkDown(x, y, temp);
            bt(depth + 1, temp);

        } else if (cctvNum == 3) {
            temp = copy(grid);
            checkUp(x, y, temp);
            checkRight(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkRight(x, y, temp);
            checkDown(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkDown(x, y, temp);
            checkLeft(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkLeft(x, y, temp);
            checkUp(x, y, temp);
            bt(depth + 1, temp);

        } else if (cctvNum == 4) {
            temp = copy(grid);
            checkLeft(x, y, temp);
            checkUp(x, y, temp);
            checkRight(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkUp(x, y, temp);
            checkRight(x, y, temp);
            checkDown(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkRight(x, y, temp);
            checkDown(x, y, temp);
            checkLeft(x, y, temp);
            bt(depth + 1, temp);

            temp = copy(grid);
            checkDown(x, y, temp);
            checkLeft(x, y, temp);
            checkUp(x, y, temp);
            bt(depth + 1, temp);

        } else {
            temp = copy(grid);
            checkDown(x, y, temp);
            checkLeft(x, y, temp);
            checkUp(x, y, temp);
            checkRight(x, y, temp);
            bt(depth + 1, temp);
        }
    }

    private static int countZeroNum(int[][] grid) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] copy(int[][] grid) {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }

    private static void checkLeft(int x, int y, int[][] grid) {
        for (int i = y - 1; i >= 0; i--) {
            int i1 = grid[x][i];
            if(i1 == 6) return;
            if(i1 != 0) continue;
            grid[x][i] = -1;
        }
    }

    private static void checkRight(int x, int y, int[][] grid) {
        for (int i = y + 1; i < col; i++) {
            int i1 = grid[x][i];
            if(i1 == 6) return;
            if(i1 != 0) continue;
            grid[x][i] = -1;
        }
    }

    private static void checkDown(int x, int y, int[][] grid) {
        for (int i = x + 1; i < row; i++) {
            int i1 = grid[i][y];
            if(i1 == 6) return;
            if(i1 != 0) continue;
            grid[i][y] = -1;
        }
    }

    private static void checkUp(int x, int y, int[][] grid) {
        for (int i = x - 1; i >= 0; i--) {
            int i1 = grid[i][y];
            if(i1 == 6) return;
            if(i1 != 0) continue;
            grid[i][y] = -1;
        }
    }
}