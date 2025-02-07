package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단축키지정 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder[] option = new StringBuilder[N];

		for (int i = 0; i < N; i++) {
			option[i] = new StringBuilder(br.readLine());
		}

		//하나의 옵션에 대해 왼쪽~오른쪽 단축키 지정되었느지 확인
		int[] alphabet = new int[200];

		for (int i = 0; i < N; i++) {
			String[] word = option[i].toString().split(" ");

			//단어 첫글자 체크
			int flag = 0;
			for (int j = 0; j < word.length; j++) {

				int idx = word[j].charAt(0);
				if (alphabet[Character.toLowerCase(idx)] == 0) {
					alphabet[Character.toLowerCase(idx)] = 1;
					StringBuilder newWord = new StringBuilder();
					int flag2 = 0;
					for (int k = 0; k < word.length; k++) {

						for (int l = 0; l < word[k].length(); l++) {
							if (word[k].charAt(l) == (char)idx && flag2 == 0 && idx != ' ') {
								newWord.append("[").append(word[k].charAt(l)).append("]");
								flag2 = 1;
								continue;
							}
							newWord.append(word[k].charAt(l));
						}
						newWord.append(" ");
					}
					option[i] = newWord;
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				for (int j = 0; j < option[i].length(); j++) {
					int idx = option[i].charAt(j);
					if (alphabet[Character.toLowerCase(idx)] == 0 && idx != ' ') {
						alphabet[Character.toLowerCase(idx)] = 1;
						StringBuilder newWord = new StringBuilder();
						int flag2 = 0;
						for (int k = 0; k < option[i].length(); k++) {

							if (option[i].charAt(k) == (char)idx && flag2 == 0) {
									newWord.append("[").append(option[i].charAt(k)).append("]");
									flag2 = 1;
									continue;
								}
								newWord.append(option[i].charAt(k));
							}
						option[i] = newWord;
						break;
						}

					}
				}
			System.out.println(option[i]);
			}


			//단어 첫글자 체크 실패 시 맨 처음부터 알파벳 검사
		}
	}

