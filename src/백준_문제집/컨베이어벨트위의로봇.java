package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int K = Integer.parseInt(info[1]);

		int[] belt = new int[2 * N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int[] robot = new int[N];
		int cnt = 0;
		int answer = 0;
		while (cnt < K) {
			
			//1. 한칸 회전
			//2. 로봇 이동
			//3. 내구도가 0이면 로봇 이동 가능
			//4. 내구도가 0인 칸의 갯수가 K개 이상이면 종료



			int tmp = belt[belt.length - 1];
			for (int i = belt.length-1; i > 0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;

			//로봇 회전
			for (int i = N-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = 0;
			robot[N-1] = 0;

			for (int i = N - 1; i > 0; i--){
				if (belt[i] > 0 && robot[i-1] == 1 && robot[i] == 0) {
					robot[i] = 1;
					robot[i-1] = 0;
					belt[i]--;
					if (belt[i] == 0) {
						cnt++;
					}
				}
			}

			if (belt[0] > 0) {
				belt[0]--;
				robot[0]=1;
				if (belt[0] == 0) {
					cnt++;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}


}
