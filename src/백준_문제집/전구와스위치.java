package 백준_문제집;

import java.util.*;
import java.io.*;

public class 전구와스위치 {
	static char[] state;
	static char[] target;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		state = br.readLine().toCharArray();
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = state[i] - '0';
			arr2[i] = state[i] - '0';
		}
		target = br.readLine().toCharArray();
		arr1[0] = 1 - arr1[0];
		arr1[1] = 1 - arr1[1];
		int answer1= solve(arr1);
		if(answer1 != - 1) answer1++;
		int answer2= solve(arr2);

		if (answer1 == -1) {
			System.out.println(answer2);
			return;
		} else if (answer2 == -1) {
			System.out.println(answer1);
		} else{
			System.out.println(Math.min(answer1,answer2));
		}


		//최소 변경 횟수를 구해야 함 -> Greedy
		//일치하지 않는 부분 먼저 변경?
		//i, i+1, i+2 문제로 변경 -> 예외조건 (1번 전구 스위치, 마지막 전구 스위치 못함)

	}

	static int solve(int[] arr){
		int cnt = 0;
		for (int i = 0; i < N-1; i++) {
			if(arr[i] != Integer.parseInt(String.valueOf(target[i]))){
				arr[i] = 1-arr[i];
				arr[i + 1] = 1 - arr[i + 1];
				if(i != N-2) {
					arr[i + 2] = 1 - arr[i + 2];
				}
				cnt++;
			}
		}

		return arr[N-1] != Integer.parseInt(String.valueOf(target[N-1])) ? -1 : cnt;
	}
}
