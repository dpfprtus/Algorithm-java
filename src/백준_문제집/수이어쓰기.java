package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] numArr = br.readLine().toCharArray();

		int answer = 1;
		int pointer = 0;

		while (pointer < numArr.length) {

			String num = String.valueOf(answer);

			for (int i = 0; i < num.length(); i++) {

				if (num.charAt(i) == numArr[pointer]) {
					pointer++;
				}
				if(pointer >= numArr.length) break;
			}
			answer += 1;
		}

		System.out.println(answer-1);
	}
}


