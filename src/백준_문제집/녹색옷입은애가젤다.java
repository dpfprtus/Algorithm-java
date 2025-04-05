package 백준_문제집;

import java.util.*;
import java.io.*;

public class 녹색옷입은애가젤다 {

    static class Node implements Comparable<Node>{
        int x,y,cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            StringTokenizer st;
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + test + ": "+dijkstra());
            test++;
        }
    }

    static int dijkstra() {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, arr[0][0]));

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0,0,-1,1};
        int[][] move = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }
        move[0][0] = arr[0][0];

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x== N - 1 && node.y == N - 1) {
                return node.cost;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (node.cost + arr[nx][ny] < move[nx][ny]) {
                        move[nx][ny] = node.cost + arr[nx][ny];
                        q.add(new Node(nx, ny, node.cost+arr[nx][ny]));
                    }
                }
            }

        }
        return -1;
    }
}
