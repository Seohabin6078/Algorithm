import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                grid[i][j] = i1;
                min = Math.min(min, i1);
                max = Math.max(max, i1);
            }
        }

        int answer = bs(0, max - min, grid, n);
        System.out.println(answer);
    }

    private static int min = 200;
    private static int max = 0;
    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int bs(int l, int r, int[][] grid, int n) {
        int answer = r;

        while (l <= r) {
            int mid = l - (l - r) / 2;
            if (isPossible(mid, grid, n)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    private static boolean isPossible(int diff, int[][] grid, int n) {
        for (int i = min; i <= max - diff; i++) {
            int s = i;
            int e = s + diff;

            if (grid[0][0] >= s && grid[0][0] <= e) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{0, 0});
                boolean[][] vis = new boolean[n][n];
                vis[0][0] = true;

                while (!q.isEmpty()) {
                    int[] remove = q.remove();
                    int x = remove[0], y = remove[1];
                    if (x == n - 1 && y == n - 1) {
                        return true;
                    }
                    for (int[] dir : dirs) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n && !vis[newX][newY] && grid[newX][newY] >= s && grid[newX][newY] <= e) {
                            q.add(new int[]{newX, newY});
                            vis[newX][newY] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}