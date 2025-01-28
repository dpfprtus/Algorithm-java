package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최소힙 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                if (q.isEmpty()) {
                    bw.write(0+"\n");
                } else {
                    bw.write(q.poll() + "\n");
                }

            } else{
                q.add(order);
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
