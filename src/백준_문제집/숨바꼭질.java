package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질 {
	static int answer = Integer.MAX_VALUE;
	static int N,K;
	static int[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
		// 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
		// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
		// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		K = Integer.parseInt(info[1]);
		visited = new int[100001];

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;

		while (!q.isEmpty()) {

			int location = q.poll();

			if (location == K) {
				answer = visited[location]-1;
				break;
			}

			if (location + 1 <= 100000 && visited[location + 1] == 0) {
				q.add(location + 1);
				visited[location+1] = visited[location]+1;
			}
			if (location - 1 >= 0 && visited[location - 1] == 0) {
				q.add(location - 1);
				visited[location-1] = visited[location]+1;
			}
			if (location * 2 <= 100000 && visited[location * 2] == 0) {
				q.add(location * 2);
				visited[location*2] = visited[location] + 1;
			}
		}
		System.out.print(answer);
	}

}

