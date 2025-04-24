package 백준_문제집;

import java.util.*;
import java.io.*;

public class 가희와탑 {
	static int N,A,B;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		A = Integer.parseInt(info[1]);
		B = Integer.parseInt(info[2]);

		//N : 빌딩 갯수
		//A : 가희가 볼 수 있는 빌딩
		//B : 단비가 볼 수 있는 빌딩
		//출력 : 사전 순으로 가장 앞에 있는 빌딩의 높이 or -1

		//스택?

		//좌, 우 / 빌딩 높이가 같을 수 있음. ->
		if (N+1 < A + B) {
			System.out.println(-1);
			return;
		}

		List<Integer> tower = new ArrayList<>();

		for (int i = 1; i < A; i++) {
			tower.add(i);
		}
		tower.add(Math.max(A, B));

		for (int i = B-1; i > 0; i--) {
			tower.add(i);
		}


		if (A == 1) {
			while (tower.size() < N) {
				tower.add(1, 1);
			}
		} else{
			while (tower.size() < N) {
				tower.add(0, 1);
			}
		}
		for (int a : tower) {
			bw.write(a + " ");
		}
		bw.flush();
		bw.close();

	}
}

