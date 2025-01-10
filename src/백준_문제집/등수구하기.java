package 백준_문제집;

import java.io.*;

public class 등수구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int newScore = Integer.parseInt(info[1]);
        int P = Integer.parseInt(info[2]);

        if(N == 0){
            System.out.println(1);
            return;
        }

        int[] nums = new int[N];
        info = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(info[i]);
        }

        int score = 1;
        int sameScore = 0;

        for (int num : nums) {
            if (num > newScore) {
                score++;
            } else if (num == newScore) {
                sameScore++;
            }
        }

        if (N == P && score+sameScore == N+1) {
            score = -1;
        }

        System.out.println(score);

    }
}
