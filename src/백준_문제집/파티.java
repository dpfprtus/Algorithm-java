package 백준_문제집;

import java.io.*;
import java.util.*;

public class 파티 {
	static List<List<Node>> list = new ArrayList<>();
	static List<List<Node>> reverseList = new ArrayList<>();

	static int N,X;

	static class Node implements Comparable<Node>{
		int dest, cost;

		Node(int dest, int cost){
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		X = Integer.parseInt(info[2]);

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}

		//시작점 != 끝점, A->B 1개
		for (int i = 0; i < M; i++) {
			info = br.readLine().split(" ");
			int start = Integer.parseInt(info[0]);
			int end = Integer.parseInt(info[1]);
			int time = Integer.parseInt(info[2]);
			list.get(start).add(new Node(end, time));
			reverseList.get(end).add(new Node(start, time));
 		}
		int[] ans1 = dijkstra(list);
		int[] ans2 = dijkstra(reverseList);

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, ans1[i] + ans2[i]);
		}
		System.out.println(max);
	}

	public static int[] dijkstra(List<List<Node>> list){
		int[] dest = new int[N+1];
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(X, 0));

		for (int i = 0; i <= N; i++) {
			Arrays.fill(dest, Integer.MAX_VALUE);
		}
		dest[X] = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int end = node.dest;
			int nowCost = node.cost;

			if(nowCost > dest[end])continue;

			for (Node nodeList : list.get(end)) {
				if (nodeList.cost + nowCost < dest[nodeList.dest]) {
					q.add(new Node(nodeList.dest, nodeList.cost + nowCost));
					dest[nodeList.dest] = nodeList.cost + nowCost;
				}
			}
		}

		return dest;

	}
}
