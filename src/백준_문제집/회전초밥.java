package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");

		//접시 수
		int N = Integer.parseInt(info[0]);
		//초밥 가짓 수
		int D = Integer.parseInt(info[1]);
		//연속해서 먹는 접시의 수
		int K = Integer.parseInt(info[2]);
		//쿠폰 번호
		int C = Integer.parseInt(info[3]);

		int[] sushi = new int[N];
		int[] eating = new int[D + 1];
		eating[C] = 3001;

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		//회전하지 않았을 때의 초밥 구하기
		int cnt = 1;
		for (int i = 0; i < K; i++) {
			if(eating[sushi[i]] == 0) {
				cnt++;
			}
			eating[sushi[i]]++;

		}
		int answer = cnt;
		//K개를 연속해서 먹으며, 그 중 쿠폰에 해당하는 초밥이 없는게 최댓값
		for (int i = 0; i < N-1; i++) {
			int s_idx = sushi[i];
			int e_idx = sushi[i + K < N ? i + K : (i + K) % N];
			if (--eating[s_idx] == 0) {
				cnt--;
			}
			if (++eating[e_idx] == 1) {
				cnt++;
			}
			answer = Math.max(answer, cnt);
		}
		System.out.print(answer);
	}
}
