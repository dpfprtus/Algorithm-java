package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영만들기 {
    static int N;
    static boolean[] visited;
    static char[] arr;
    static List<String> ans = new ArrayList<>();
    static String[] op = {"-", "+", " "};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(ans);
            for (String s : ans) {
                System.out.println(s);
            }
            System.out.println();
        }

    }

    public static void dfs(int cnt, String express) {
        if (cnt == N) {
            String answer = express.replaceAll(" ", "");
            if (cal(answer)) {
                ans.add(express);
            }
            return;
        }
        dfs(cnt + 1, express + op[0]+ Integer.toString(cnt + 1));
        dfs(cnt + 1, express + op[1] +Integer.toString(cnt + 1));
        dfs(cnt + 1, express + op[2]+Integer.toString(cnt + 1));
    }

    public static boolean cal(String express) {
        StringTokenizer st = new StringTokenizer(express, "+-", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreElements()) {
            String token = st.nextToken();
            if (token.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            }else{
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        return sum == 0;
    }
}
