package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		//최소 교환으로 a가 전부 이어지게 만들어야 한다.
		int totalA = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				totalA++;
			}
		}

		int aCount = 0;
		for (int i = 0; i < str.length(); i++) {
			int tmpCnt = 0;
			for (int j = 0; j < totalA; j++) {

				int idx = i + j < str.length() ? i+j : i + j - str.length();
				if (str.charAt(idx) == 'a') {
					tmpCnt++;
				}
			}
			aCount = Math.max(aCount, tmpCnt);

		}
		System.out.println(totalA - aCount);
	}

}
