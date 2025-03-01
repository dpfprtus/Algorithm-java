package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 크로스컨트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//팀 성적 : 6명 중 상위 4명 점수 합산
		//점수 : 결승점 통과 순서대로 점수 부여.
		//우승 : 가장 낮은 점수를 얻는 팀
		//제약조건
		//1. 6명의 주자가 참가하지 못한 팀은 점수 계산에서 제외.
		//2. 동점의 경우 5번째 주자가 가장 빨리 들어온 팀이 우승.

		//출력 : 우승팀

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] players = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				players[j] = Integer.parseInt(st.nextToken());
			}

			Map<Integer, Integer> checkPlayerNum = new HashMap<>();
			for (int j = 0; j < N; j++) {
				checkPlayerNum.put(players[j], checkPlayerNum.getOrDefault(players[j], 0) + 1);
			}

			Map<Integer, Integer> playerScore = new HashMap<>();
			int order = 1;
			int[] playerCnt = new int[201];
			int[] fifty = new int[201];
			for (int j = 0; j < N; j++) {
				if (checkPlayerNum.getOrDefault(players[j], 0) < 6) {
					continue;
				}
				playerCnt[players[j]]++;
				if (playerCnt[players[j]] <= 4) {
					playerScore.put(players[j], playerScore.getOrDefault(players[j] , 0)+order);
				} else if (playerCnt[players[j]] == 5) {
					fifty[players[j]] = order;
				}
				order++;
			}

			int maxScore = Integer.MAX_VALUE;
			int fiftyScore = Integer.MAX_VALUE;;
			int answer = 0;
			for (int n : playerScore.keySet()) {
				int tmp = playerScore.get(n);
				if (tmp < maxScore) {
					maxScore = tmp;
					fiftyScore = fifty[n];
					answer = n;
				} else if (tmp == maxScore) {
					if (fiftyScore > fifty[n]) {
						answer = n;
						fiftyScore = fifty[n];
					}
				}
			}

			System.out.println(answer);
		}

	}
}
