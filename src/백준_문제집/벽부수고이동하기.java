package 백준_문제집;


import java.io.*;
import java.util.*;

public class 벽부수고이동하기 {
	static int N,M;
	static int[][] maps;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		maps = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
			}
		}
		bfs();
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[][][] visited = new int[N][M][2];
		q.add(new int[] {0,0, 0});
		int[] dx = new int[] {0, 0, -1, 1};
		int[] dy = new int[] {-1, 1, 0, 0};
		visited[0][0][0] = 1;
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int isBroken = node[0];
			int x = node[1];
			int y = node[2];

			if (x == N - 1 && y == M - 1) {
				System.out.println(Math.max(visited[x][y][0], visited[x][y][1]));
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if(isBroken == 0){
					if (maps[nx][ny] == 0 && visited[nx][ny][0] == 0) {
						q.add(new int[] {0,nx, ny});
						visited[nx][ny][0] = visited[x][y][0] + 1;
					} else if (maps[nx][ny] == 1 && visited[nx][ny][0] == 0 && visited[nx][ny][1] == 0) {
						q.add(new int[] {1,nx, ny});
						visited[nx][ny][1] = visited[x][y][0] + 1;
					}
				} else{
					if (maps[nx][ny] == 0 && visited[nx][ny][1] == 0) {
						q.add(new int[] {1,nx, ny});
						visited[nx][ny][1] = visited[x][y][1]+1;
					}
				}

			}
		}
		System.out.println(-1);

	}
}
