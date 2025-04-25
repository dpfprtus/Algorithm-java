package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일의개수세기 {
	static long[] dp = new long[55];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		long A = Long.parseLong(info[0]);
		long B = Long.parseLong(info[1]);
		setDp();
		System.out.println(convertToBinary(B) - convertToBinary(A-1));

	}

	static long convertToBinary(long num) {
		long cnt = num & 1;
		int size = (int) (Math.log(num) / Math.log(2));

		for (int i = size; i > 0; i--) {
			if((num & (1L << i)) != 0L) {
				cnt += dp[i - 1] + num - (1L << i) + 1;
				num -= 1L << i;
			}
		}
		return cnt;
	}

	static void setDp() {
		dp[0] = 1;
		for (int i = 1; i < 55; i++) {
			dp[i] = (dp[i - 1] << 1) + (1L << i);
		}
	}
}
