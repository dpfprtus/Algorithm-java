package 백준_문제집;

import java.io.*;
import java.util.*;

public class 문제집 {
	public static void main(String[] args) throws IOException {

		//## 위상정렬 + 우선순위 큐
		//N개의 문제 모두 풀어야 함.
		//먼저 풀어야 하는 문제 먼저 품.
		//가능하면 쉬운 문제부터 풀어야 함.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		//문제 수
		int N = Integer.parseInt(info[0]);

		//먼저 푸는게 좋은 문제의 정보에 대한 수
		int M = Integer.parseInt(info[1]);
		List<List<Integer>> list = new ArrayList<>();
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		int[] degree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			info = br.readLine().split(" ");
			int numA = Integer.parseInt(info[0]);
			int numB = Integer.parseInt(info[1]);
			degree[numB]++;
			list.get(numA).add(numB);
		}

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
		}
		Queue<Integer> result = new LinkedList<>();
		while (!q.isEmpty()) {
			int node = q.poll();
			if (degree[node] == 0) {
				result.offer(node);
			}
			for (int a : list.get(node)) {
				degree[a]--;
				if (degree[a] == 0) {
					q.offer(a);
				}

			}

		}
		for(int a : result){
			System.out.print(a + " ");
		}

	}
}