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
		int[] answer = new int[T];
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<Integer, Integer> countMap = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] ranks = new int[N];
			int maxTeamNum = 0;
			for (int j = 0; j < N; j++) {

				int teamNum = Integer.parseInt(st.nextToken());
				countMap.put(teamNum, countMap.getOrDefault(teamNum,0)+1);
				ranks[j] = teamNum;
				maxTeamNum = Math.max(maxTeamNum, teamNum);
			}

			int[] fivePlayer = new int[maxTeamNum + 1];
			Map<Integer, Integer> scoreMap = new HashMap<>();
			Map<Integer, Integer> tmpMap = new HashMap<>();
			int score = 1;

			for (int rank : ranks) {
				if(countMap.get(rank) == 6) {
					tmpMap.put(rank, tmpMap.getOrDefault(rank, 0) + 1);

					if (tmpMap.get(rank) <= 4) {
						scoreMap.put(rank, scoreMap.getOrDefault(rank,0)+score);

					}
					if (tmpMap.get(rank) == 5) {
						fivePlayer[rank] = score;
					}
					score++;
				}

			}

			int result = Integer.MAX_VALUE;
			int fiveScore = Integer.MAX_VALUE;

			for (Integer key : scoreMap.keySet()) {
				int tmp = scoreMap.get(key);
				if (tmp < result) {
					result = tmp;
					fiveScore = fivePlayer[key];
					answer[i] = key;
				} else if (tmp == result) {
					if (fiveScore > fivePlayer[key]) {
						answer[i] = key;
					}

				}
			}

		}
		for (int a : answer) {
			System.out.println(a);
		}


	}
}
