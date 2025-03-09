package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] spoil = new int[N];
        String[] info = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            spoil[i] = Integer.parseInt(info[i]);
        }

        long answer = Long.MAX_VALUE;
        int a = 0;
        int b =0;
        for (int i = 0; i < N-1; i++) {
            int left = i+1;
            int right = N-1;
            while (left <= right) {
                int mid = (left+right)/2;
                long sum = Math.abs(spoil[i] + spoil[mid]);
                if (sum < answer) {
                    answer = sum;
                    a = spoil[i];
                    b = spoil[mid];
                }
                if (spoil[mid] >= -spoil[i]) {
                    right = mid-1;
                } else{
                    left = mid+1;
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
