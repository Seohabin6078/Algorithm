import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static char[][] grid = new char[5][5];
    private static int[] group = new int[7];
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == 7) {
            if (check()) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            group[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    private static boolean check() {
        int yCount = 0;
        for (int i : group) {
            int row = i / 5;
            int col = i % 5;
            if(grid[row][col] == 'Y') yCount++;
        }
        if(yCount >= 4) return false;

        List<Integer> tempList = new ArrayList<>();
        for (int i : group) {
            tempList.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(tempList.get(0));
        tempList.remove(0);

        while (!q.isEmpty()) {
            Integer remove = q.remove();
            for (int[] dir : dirs) {
                int newX = remove / 5 + dir[0];
                int newY = remove % 5 + dir[1];
                if (newX >= 0 && newX < 5 && newY >= 0 && newY < 5) {
                    Integer newVal = newX * 5 + newY;
                    if (tempList.contains(newVal)) {
                        q.add(newVal);
                        tempList.remove(newVal);
                    }
                }
            }
        }
        return tempList.isEmpty();
    }

    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
}