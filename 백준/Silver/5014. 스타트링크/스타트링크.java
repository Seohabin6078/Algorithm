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
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] dirs = {u, -d};
        boolean[] vis = new boolean[f + 1];

        int answer = bfs(vis, dirs, s, g, f);
        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(boolean[] vis, int[] dirs, int s, int g, int f) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        vis[s] = true;

        while (!q.isEmpty()) {
            int[] remove = q.remove();
            int x = remove[0], count = remove[1];
            if (x == g) {
                return count;
            }
            for (int dir : dirs) {
                int newX = x + dir;
                if (newX >= 1 && newX <= f && !vis[newX]) {
                    q.add(new int[]{newX, count + 1});
                    vis[newX] = true;
                }
            }
        }
        return -1;
    }

}