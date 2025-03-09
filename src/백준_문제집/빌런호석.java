package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빌런호석 {
    static int N,K,P,X;
    static int[][] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //호석 : 1~p개 반전
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        K = Integer.parseInt(info[1]);
        P = Integer.parseInt(info[2]);
        X = Integer.parseInt(info[3]);

        nums = new int[10][7];
        nums[0] = new int[]{1,1,1,0,1,1,1};
        nums[1] = new int[]{0,0,1,0,0,0,1};
        nums[2] = new int[]{0,1,1,1,1,1,0};
        nums[3] = new int[]{0,1,1,1,0,1,1};
        nums[4] = new int[]{1,0,1,1,0,0,1};
        nums[5] = new int[]{1,1,0,1,0,1,1};
        nums[6] = new int[]{1,1,0,1,1,1,1};
        nums[7] = new int[]{0,1,1,0,0,0,1};
        nums[8] = new int[]{1,1,1,1,1,1,1};
        nums[9] = new int[]{1,1,1,1,0,1,1};
        int[] digit = toDigit(X);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            if (change(i, digit)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static int[] toDigit(int a) {
        int[] digit = new int[K];
        for (int i = K-1; i >= 0; i--) {
            digit[i] = (a % 10);
            a /= 10;
        }
        return digit;
    }

    public static boolean change(int tartget, int[] digit) {
        int[] target = toDigit(tartget);
        int diff = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if (nums[digit[i]][j] != nums[target[i]][j]) {
                    diff++;
                }
                if(diff > P) return false;
            }
        }
        return true;
    }
}
