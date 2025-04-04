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
		int answer = 0;

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			info = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(info[j]);
			}
		}

		while(true) {
			boolean isBreak = true;
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						int sum = bfs(i, j);
						if(nodeArr.size() > 1){
							cal(sum);
							isBreak = false;
						}
					}
				}
			}
			if (isBreak) break;
			answer++;
		}
		System.out.println(answer);
	}



	public static void cal(int sum) {
		for (Node node : nodeArr) {
			arr[node.x][node.y] = sum / nodeArr.size();
		}
	}

	public static int bfs(int a, int b){
		nodeArr = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, b));
		nodeArr.add(new Node(a, b));
		visited[a][b] = 1;
		int[] dx = new int[]{-1,1,0,0};
		int[] dy = new int[]{0,0,-1,1};
		int sum = arr[a][b];
		while(!q.isEmpty()){
			Node node = q.poll();
			for(int i = 0;i<4;i++){
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if(0 <= nx && nx < N && 0 <= ny && ny < N && visited[nx][ny] != 1){
					int result = Math.abs(arr[nx][ny] - arr[node.x][node.y]);
					if(result >= L && result <= R){
						nodeArr.add(new Node(nx, ny));
						sum += arr[nx][ny];
						visited[nx][ny] = 1;
						q.add(new Node(nx, ny));
					}

				}
			}
		}
		return sum;
	}
}
