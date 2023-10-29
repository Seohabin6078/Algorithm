import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[row][col][height];
        Queue<int[]> q = new LinkedList<>();
        int max = Integer.MAX_VALUE;

        for (int z = 0; z < height; z++) {
            for (int x = 0; x < row; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < col; y++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        tomato[x][y][z] = 0;
                        q.add(new int[]{x, y, z});
                    } else if (temp == 0) {
                        tomato[x][y][z] = max;
                    } else {
                        tomato[x][y][z] = -1;
                    }
                }
            }
        }
        int[][] dirs = {{-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

        while (!q.isEmpty()) {
            int[] remove = q.remove();
            int x = remove[0], y = remove[1], z = remove[2];
            int curDay = tomato[x][y][z];
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                int newZ = z + dir[2];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && newZ >= 0 && newZ < height && tomato[newX][newY][newZ] == max) {
                    q.add(new int[]{newX, newY, newZ});
                    tomato[newX][newY][newZ] = curDay + 1;
                }
            }
        }

        int result = 0;

        for (int z = 0; z < height; z++) {
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (tomato[x][y][z] == max) {
                        System.out.println(-1);
                        return;
                    }
                    if (tomato[x][y][z] > result) {
                        result = tomato[x][y][z];
                    }
                }
            }
        }
        System.out.println(result);
    }
}