package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class 지름길 {
	static List<List<Node>> list = new ArrayList<>();
	static int D;
	static int[] distance;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");

		int N = Integer.parseInt(info[0]);
		D = Integer.parseInt(info[1]);

		int[][] arr = new int[N][3];
		for (int i = 0; i <=10001; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			list.get(arr[i][0]).add(new Node(arr[i][1], arr[i][2]));
		}

		distance = new int[10001];
		for (int i = 1; i <= D; i++) {
			distance[i] = i;
		}

		for (int i = 0; i <= D; i++) {
			dijkstra(i);
		}
		System.out.print(distance[D]);

	}

	public static void dijkstra(int start) {
		if(start > D) return;
		if(distance[start+1] > distance[start]+1) distance[start+1] = distance[start]+1;

		for (int i = 0; i < list.get(start).size(); i++) {
			if (distance[list.get(start).get(i).node] > distance[start] + list.get(start).get(i).weight) {
				distance[list.get(start).get(i).node] = distance[start] + list.get(start).get(i).weight;
			}
		}
	}

	static class Node{
		int node;
		int weight;

		Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
}
