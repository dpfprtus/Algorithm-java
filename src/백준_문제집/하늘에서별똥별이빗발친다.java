package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 하늘에서별똥별이빗발친다 {
    static int N,M,L,K;
    static List<int[]> stars = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        L = Integer.parseInt(info[2]);
        K = Integer.parseInt(info[3]);


        for (int i = 0; i < K; i++) {
            info = br.readLine().split(" ");
            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);
            stars.add(new int[]{x, y});
        }

        int max = 0;
        for (int[] a : stars) {
            for (int[] b : stars) {
                max = Math.max(max, check(a[0], b[1]));
            }
        }

        System.out.println(K - max);
    }

    public static int check(int x, int y) {
        int cnt = 0;
        for (int[] a : stars) {
            if (a[0] >= x && a[0] <= x + L && a[1] >= y && a[1] <= y + L) {
                cnt++;
            }
        }
        return cnt;
    }

}
