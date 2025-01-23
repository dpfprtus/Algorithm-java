package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 햄버거분배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int K = Integer.parseInt(info[1]);

		//햄버거와 사람 문자열 H/P
		char[] charArr = br.readLine().toCharArray();
		Queue<Integer> pIdx = new LinkedList<>();

		//햄버거 먹은건지 체크
		boolean[] eatBurger = new boolean[N];

		//사람 인덱스 추가
		for (int i = 0; i < N; i++) {
			if (charArr[i] == 'P') {
				pIdx.add(i);
			}

		}


		int peopleNum = pIdx.size();

		if (peopleNum == 0 || peopleNum == N) {
			System.out.println(0);
			return;
		}

		int cnt = 0;
		int answer = 0;
		while (cnt < peopleNum) {
			int people = pIdx.poll();

			int findFlag = 0;
			//왼쪽부터 햄버거 찾기
			for (int i = people-K; i < people; i++) {
				if (i < 0 || eatBurger[i] || charArr[i] == 'P') continue;
				eatBurger[i] = true;
				findFlag = 1;
				answer++;
				break;
			}

			if(findFlag == 0){
				for (int i = people+1; i <= people+K; i++) {
					if(i >= N) break;
					if (eatBurger[i] || charArr[i] == 'P') continue;
					eatBurger[i] = true;
					answer++;
					break;
				}
			}
			//오른쪽으로 햄버거 찾기
			cnt++;
		}
		//햄버거를 먹을 수 있는 최대 사람 수
		System.out.println(answer);
	}
}
