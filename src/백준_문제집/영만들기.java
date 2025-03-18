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
    static StringBuilder sb;
    static String[] op = {"-", "+", " "};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");
            System.out.println(sb);
        }


    }

    public static void dfs(int idx, int lastNum, int sum, int ops, String str) {
        if(idx == N){
            sum += (lastNum * ops);
            if (sum == 0) {
                sb.append(str+"\n");
            }
            return;
        }

        dfs(idx+1, (lastNum)*10+(idx+1),sum,ops,str+op[2]+(idx+1));
        dfs(idx + 1, idx+1, sum+(lastNum*ops), 1,str+op[1]+(idx+1));
        dfs(idx+ 1, idx+1, sum+(lastNum*ops),-1,str+op[0]+(idx+1));
    }

}

