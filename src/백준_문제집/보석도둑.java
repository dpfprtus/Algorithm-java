package 백준_문제집;

import java.util.*;
import java.io.*;

public class 보석도둑 {
    //extends가 아니라 implements임
    static class Jewlery {
        int mass, price;
        Jewlery(int mass, int price) {
            this.mass = mass;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);
        Jewlery[] jewlery = new Jewlery[N];
        for (int i = 0; i < N; i++) {
            //보석 정보
            info = br.readLine().split(" ");
            int M = Integer.parseInt(info[0]); //무게
            int V = Integer.parseInt(info[1]); //가격
            jewlery[i] = new Jewlery(M, V);
        }
        Arrays.sort(jewlery, (o1, o2) -> {
            if (o1.mass == o2.mass) {
                return o2.price - o1.price;
            }
            return o1.mass - o2.mass;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine()); //가방에 담을 수 있는 최대무게
            bags[i] = C;
        }
        Arrays.sort(bags);

        int j = 0;
        long answer = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewlery[j].mass <= bags[i]) {
                pq.offer(jewlery[j++].price);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}
