package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//최소한의 높이로 모든길을 밝히고 싶다.
		//가로등 높이가 같아야함, 정수임

		//굴다리 길이
		int N = Integer.parseInt(br.readLine());

		//가로등 갯수 -> 높이가 h면 좌우로 h만큼 비침
		int M = Integer.parseInt(br.readLine());
		int answer = 0;

		//가로등 위치
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] location = new int[M];
		for (int i = 0; i < M; i++) {
			location[i] = Integer.parseInt(st.nextToken());
		}

		for (int light = 1; light <= N; light++) {

			//빛을 채운다.
			int flag = 0;
			if(location[0]-light > 0 || location[M-1]+light < N) continue;

			for (int i = 0; i < M - 1; i++) {
				if(location[i]+light < location[i+1]-light){
					flag = 1;
					break;
				}
				flag = 0;
			}
			if(flag == 0){
				answer = light;
				break;
			}

		}

		System.out.println(answer);


	}
}
