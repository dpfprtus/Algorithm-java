package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //1. 주식 하나 구매
        //2. 원하는 만큼 주식 매도
        //3. 아무것도 안함

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] days = new int[N];
            for (int j = 0; j < N; j++) {
                days[j] = Integer.parseInt(st.nextToken());
            }

            //주식이 없으면 매수
            //뒤에 날에 더 크게 매도할 수 있는 날을 탐색
            long answer = 0;
            long nowNum = days[N - 1];
            for (int j = N - 2; j >= 0; j--) {
                if (days[j] < nowNum) {
                    answer += (nowNum - days[j]);

                } else if (days[j] > nowNum) {
                    nowNum = days[j];
                }
            }
            System.out.println(answer);
        }

    }
}
