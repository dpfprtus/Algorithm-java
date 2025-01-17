package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long answer = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] lengthOfRoads = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			lengthOfRoads[i] = Integer.parseInt(st.nextToken());
		}

		//기름 1리터 = 1km
		int[] priceOfOil = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			priceOfOil[i] = Integer.parseInt(st.nextToken());
		}

		//1. 지금 주유소와 가격이 적다면 가격이 본인보다 작은 주유소가 나올 때까지 주유

		//2. 지금 주유소보다 다음 주유소 가격이 저렴하면 지금 주유소에서는 이번 도로만큼만 주유

		long nowPrice = priceOfOil[0];
		long nextPrice = priceOfOil[1];
		int idx = 0;

		while(idx < N-1){
			answer += nowPrice * lengthOfRoads[idx];
			idx++;
			if (nowPrice > nextPrice) {
				nowPrice = nextPrice;
			}
			if(idx+1 < N-1)
				nextPrice = priceOfOil[idx+1];
		}
		System.out.print(answer);
	}
}
