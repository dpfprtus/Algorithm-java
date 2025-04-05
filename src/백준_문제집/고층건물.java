package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double tmp = 0;
            //왼쪽 탐색
            for (int j = i-1; j >= 0; j--) {
                double slope = (double) (nums[i] - nums[j]) / (i - j);
                if (j == i-1 || tmp > slope) {
                    cnt++;
                    tmp = slope;
                }
            }

            //오른쪽 탐색
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (nums[j] - nums[i]) / (j - i);

                if (j == i+1 || tmp < slope) {
                    cnt++;
                    tmp = slope;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);

    }
}
