package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 뱀과사다리게임 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        //
        int[] game = new int[101];

        Map<Integer, Integer> bridge = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        for (int i = 0; i < N; i++) {
             info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            bridge.put(start, end);
            game[start] = 1;
        }

        for (int i = 0; i < M; i++) {
            info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            snake.put(start, end);
            game[start] = -1;
        }

        //주사위 : 1~6
        //게임판 : 10x10 -> 1~100
        //주사위 굴렀을 때 100이 넘어가면 이동 불가
        //도착한 칸이 사다리 -> 위로, 뱀 -> 아래로
        //주사위 굴리는 최솟값
        Deque<Integer> q = new LinkedList<>();
        int[] visited = new int[101];
        visited[1] = 1;
        q.add(1);
        while (!q.isEmpty()) {

            int next = q.poll();
            if (next == 100) {
                answer = visited[next]-1;
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int move = next + i;

                if (move > 100 || visited[move] != 0) {
                    continue;
                }

                if (game[move] == 1) {
                    if(visited[bridge.get(move)] == 0){
                        visited[bridge.get(move)] = visited[next]+1;
                        q.add(bridge.get(move));
                    }

                } else if (game[move] == -1) {
                    if (visited[snake.get(move)] == 0) {
                        visited[snake.get(move)] = visited[next]+1;
                        q.add(snake.get(move));
                    }
                } else{
                    visited[move] = visited[next]+1;
                    q.add(move);
                }

            }
        }
        System.out.print(answer);

    }

}
