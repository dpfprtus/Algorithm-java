package 백준_문제집;

import java.io.*;
import java.util.*;

public class 동전분배 {
	static class Coin{
		int price, amount;

		Coin(int price, int amount) {
			this.price = price;
			this.amount = amount;
		}
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//출력 : 1, 0
		//동전 종류, 갯수 = 자연수

		//조건 : 0 ->
		//조건 : 1 ->
		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			Coin[] coins = new Coin[N];
			int sum = 0;
			for (int j = 0; j < N; j++) {
				String[] info = br.readLine().split(" ");
				int coin = Integer.parseInt(info[0]);
				int cnt= Integer.parseInt(info[1]);
				coins[j] = new Coin(coin, cnt);
				sum += (coin * cnt);
			}

			if (sum % 2 == 1) {
				bw.write("0\n");
			} else{
				sum /= 2;
				boolean[][] dp = new boolean[N + 1][sum+1];
				dp[0][0] = true;
				for (int t = 1; t <= N; t++) {
					Coin coin = coins[t - 1];

					for (int p = 0; p <= sum; p++) {
						if(dp[t-1][p]){
							for (int k = 0; k <= coin.amount; k++) {
								int sumPrice = p+coin.price * k;
								if (sumPrice <= sum) {
									dp[t][sumPrice] = true;
								}

							}
						}

					}
				}
				if(dp[N][sum]){
					bw.write("1\n");
				} else{
					bw.write("0\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}

