package 백준_문제집;

import java.util.*;
import java.io.*;

public class 알파벳 {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int R, C;
    static int answer = 0;
    static char[][] maps;
    static int[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        R = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);
        maps = new char[R][C];
        for (int i = 0; i < R; i++) {
            maps[i] = br.readLine().toCharArray();
        }
        visited = new int[26];
        visited[maps[0][0] - 'A'] = 1;
        dfs(0,0,1);
        System.out.println(answer);

    }

    static void dfs(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > R-1 || ny < 0 || ny > C-1 || visited[maps[nx][ny] - 'A'] == 1) continue;
            visited[maps[nx][ny] -'A'] = 1;
            dfs(nx, ny, cnt + 1);
            visited[maps[nx][ny] - 'A'] = 0;
        }
    }

}
