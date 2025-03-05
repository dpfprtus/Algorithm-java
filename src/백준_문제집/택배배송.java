package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 택배배송 {
    static class Node implements Comparable<Node> {

        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int answer = Integer.MAX_VALUE;
    static List<List<Node>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            info = br.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            int c = Integer.parseInt(info[2]);

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        answer = dijkstra(1, N);
        System.out.println(answer);
    }

    public static int dijkstra(int now, int N) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int dest = node.dest;
            int cost = node.cost;

            if(cost > dist[dest]) continue;

            for (Node newNode : list.get(dest)) {
                int nextNode = newNode.dest;
                int nextCost = newNode.cost;
                if (cost + nextCost < dist[nextNode]) {
                    q.offer(new Node(nextNode, cost + nextCost));
                    dist[nextNode] = nextCost + cost;
                }
            }
        }
        return dist[N];

    }
}
