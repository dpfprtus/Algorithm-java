package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 인구이동 {
	static int[][] arr;
	static int N,L,R;
	static int[][] visited;
	static List<Node> nodeArr;

	static class Node{
		int x,y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		L = Integer.parseInt(info[1]);
		R = Integer.parseInt(info[2]);
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			info = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(info[j]);
			}
		}
		System.out.println(move());

		//각 칸의 인구 수  : 연합의 인구 수/ 연합을 이루고 있는 칸의 개수 => 소수점은 제거
		//1. 국경선 열기
		//2. 인구 이동 -> 각 칸의 인구 수로 조정.

	}

	public static int move() {
		int cnt = 0;

		while (true) {
			boolean isMove = false;
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] != 1) {
						int sum = bfs(i, j);
						if (nodeArr.size() > 1) {
							movePopulation(sum);
							isMove = true;

						}
					}
				}
			}
			if (!isMove) break;
			cnt++;
		}
		return cnt;
	}

	public static void movePopulation(int sum) {
		int population = sum/nodeArr.size();
		for (Node node : nodeArr) {
			arr[node.x][node.y] = population;
		}
	}

	//국경선 열기
	public static int bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(i,j));
		visited[i][j] = 1;
		nodeArr = new ArrayList<>();
		nodeArr.add(new Node(i, j));
		int[] dx = new int[] {-1, 1, 0, 0};
		int[] dy = new int[] {0, 0, -1, 1};

		int sum = arr[i][j];
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];

				if (0<= nx && nx < N && 0<= ny && ny <N && visited[nx][ny] != 1) {
					int abs = Math.abs(arr[node.x][node.y] - arr[nx][ny]);
					if (L <= abs && abs <= R) {
						Node newNode = new Node(nx, ny);
						nodeArr.add(newNode);
						q.add(newNode);
						visited[nx][ny] = 1;
						sum += arr[nx][ny];
					}
				}
			}
		}
		return sum;
	}
}
