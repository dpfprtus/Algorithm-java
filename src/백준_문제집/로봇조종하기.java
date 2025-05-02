package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 로봇조종하기 {
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            info = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(info[j]);
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = maps[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + maps[0][i];
        }

        for (int i = 1; i < N; i++) {
            //왼쪽
            int[] left = new int[M];
            int[] right = new int[M];
            left[0] = dp[i-1][0] + maps[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + maps[i][j];
            }

            //오른쪽
            right[M - 1] = dp[i - 1][M - 1] + maps[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + maps[i][j];
            }

            //합쳐서 계산
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }
        System.out.println(dp[N - 1][M - 1]);

    }

}
