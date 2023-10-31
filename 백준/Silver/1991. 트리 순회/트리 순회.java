import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static StringBuilder pre = new StringBuilder();
    private static StringBuilder in = new StringBuilder();
    private static StringBuilder post = new StringBuilder();
    private static Map<String, String[]> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            String[] strings = Arrays.copyOfRange(s, 1, 3);
            map.put(s[0], strings);
        }
        preorder("A");
        inorder("A");
        postorder("A");
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    private static void postorder(String a) {
        if (a.equals(".")) {
            return;
        }

        String[] strings = map.get(a);
        postorder(strings[0]);
        postorder(strings[1]);
        post.append(a);
    }

    private static void inorder(String a) {
        if (a.equals(".")) {
            return;
        }

        String[] strings = map.get(a);
        inorder(strings[0]);
        in.append(a);
        inorder(strings[1]);
    }

    private static void preorder(String a) {
        if (a.equals(".")) {
            return;
        }

        String[] strings = map.get(a);
        pre.append(a);
        preorder(strings[0]);
        preorder(strings[1]);
    }
}