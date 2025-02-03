package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지름길 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");

		int N = Integer.parseInt(info[0]);
		int D = Integer.parseInt(info[1]);

		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dp = new int[D + 1];
		for (int i = 1; i <= D; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= D; i++) {

			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			for (int j = 0; j < N; j++) {
				if (i == arr[j][1]) {
					dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
				}
			}

		}
		System.out.print(dp[D]);
	}
}
