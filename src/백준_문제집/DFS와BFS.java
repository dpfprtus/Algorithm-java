package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
    static int[][] graph;
    static boolean[] visited;
    static int N, M,V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정점 번호가 작은 것을 먼저 방문 (1~N)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for (int i = 1; i <= N; i++) {
            if(graph[x][i] == 0 || visited[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int x = q.poll();

            System.out.print(x + " ");
            for (int i = 1; i <=N; i++) {
                if(graph[x][i] == 0 || visited[i]) continue;
                q.add(i);
                visited[i] = true;
            }
        }
    }

}
