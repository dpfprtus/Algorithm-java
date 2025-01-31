package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] info = br.readLine().split(" ");
        int[] keys = new int[N];
        for (int i = 0; i < N; i++) {
            keys[i] = Integer.parseInt(info[i]);
        }

        int[] answer = new int[N];
        Arrays.fill(answer,-1);

        for (int i = 0; i < N; i++) {
            int key = keys[i];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(answer[j] == -1){
                    if (cnt == key) {
                        answer[j] = i+1;
                    }
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i]+" ");
        }
        //자기 왼쪽에 키가 큰 사람이 몇명인지 주어짐.

    }
}
