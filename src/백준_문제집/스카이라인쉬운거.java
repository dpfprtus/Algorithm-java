package 백준_문제집;

import java.util.*;
import java.io.*;

public class 스카이라인쉬운거 {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] info = br.readLine().split(" ");
			int x = Integer.parseInt(info[0]);
			int y = Integer.parseInt(info[1]);
			list.add(new int[] {x, y});
		}
		list.sort(Comparator.comparingInt(a -> a[0]));

		//1. 그림자가 겹치는 경우 -> y가 다르면 다른 건물
		//2. 그림자가 안 겹치는 경우 -> 다른 건물


		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		for (int[] a : list) {
			while (!stack.isEmpty() && stack.peek() > a[1]) {
				stack.pop();
				cnt++;
			}

			if (!stack.isEmpty() && stack.peek() == a[1]) {
				continue;
			}
			//더 높은 빌딩이 경우
			stack.push(a[1]);
		}

		while (!stack.isEmpty()) {
			if (stack.peek() > 0) {

				cnt++;
			}
			stack.pop();
		}

		System.out.println(cnt);

	}
}
