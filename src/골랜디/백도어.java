package 골랜디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백도어 {
	static int N,M;
	static int[] sight;
	static List<List<Node>> list = new ArrayList<>();
	static class Node implements Comparable<Node>{
		int dest;
		long price;

		Node(int dest, long price) {
			this.dest = dest;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.price, o.price);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		sight = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sight[i] = Integer.parseInt(st.nextToken());

		}
		for (int i = 0; i < N; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 0; i < M; i++) {
			info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int c = Integer.parseInt(info[2]);
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		System.out.println(dijkstra());

		//처음은 안보이고, 마지막은 보임 -> 1(보이는 곳)은 지나칠 수 없음
	}

	public static long dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		long[] dest = new long[N];
		Arrays.fill(dest, Long.MAX_VALUE);
		dest[0] = 0;
		pq.add(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int nowNode = node.dest;
			long nowPrice = node.price;

			if((nowNode != N && sight[nowNode] == 1) || nowPrice > dest[nowNode])
				continue;

			for (Node nextNode : list.get(nowNode)) {
				if (nextNode.price + nowPrice < dest[nextNode.dest]) {
					pq.offer(new Node(nextNode.dest, nextNode.price+nowPrice));
					dest[nextNode.dest] = nextNode.price + nowPrice;
				}
			}
		}
		return dest[N-1] != Long.MAX_VALUE ? dest[N-1] : -1;
	}
}
