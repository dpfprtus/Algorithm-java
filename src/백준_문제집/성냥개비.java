package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 성냥개비 {
    static int N;
    static long[] minDp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int N = Integer.parseInt(br.readLine());
            minDp();
            StringBuilder max = new StringBuilder();
            long a = N / 2;
            long b = N % 2;
            if (b == 1) {
                max.append("7");
            } else{
                max.append("1");
            }
            for (int j = 1; j < a; j++) {
                max.append("1");
            }
            System.out.println(minDp[N] + " " + max);
        }

    }

    public static void minDp() {
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10;

        long[] add = {1, 7, 4, 2, 0, 8};
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                minDp[i] = Math.min((minDp[i - j]*10 + add[j - 2]), minDp[i]);
            }
        }
    }
}
