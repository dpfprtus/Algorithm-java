package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 진우의달여행 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        int[][] maps = new int[N][M];
        int[][][] visited = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(visited[i][j], (int)1e9);
            }
        }


        for (int i = 0; i < M; i++) {
            visited[0][i][0] = maps[0][i];
            visited[0][i][1] = maps[0][i];
            visited[0][i][2] = maps[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    visited[i][j][0] = Math.min(visited[i - 1][j + 1][1] + maps[i][j],
                            visited[i - 1][j + 1][2] + maps[i][j]);
                    visited[i][j][1] = visited[i - 1][j][0] + maps[i][j];
                } else if (j == M - 1) {
                    visited[i][j][2] = Math.min(visited[i - 1][j - 1][1] + maps[i][j],
                            visited[i - 1][j - 1][0] + maps[i][j]);
                    visited[i][j][1] = visited[i - 1][j][2] + maps[i][j];
                } else{
                    visited[i][j][0] = Math.min(visited[i - 1][j+1][1] + maps[i][j],
                            visited[i - 1][j +1][2] + maps[i][j]);
                    visited[i][j][1] = Math.min(visited[i - 1][j][0] + maps[i][j], visited[i - 1][j][2]+maps[i][j]);
                    visited[i][j][2] = Math.min(visited[i - 1][j-1][1] + maps[i][j],
                            visited[i - 1][j - 1][0] + maps[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            answer = Math.min(answer, visited[N - 1][i][0]);
            answer = Math.min(answer, visited[N - 1][i][1]);
            answer = Math.min(answer, visited[N - 1][i][2]);
        }
        System.out.print(answer);
    }
}
