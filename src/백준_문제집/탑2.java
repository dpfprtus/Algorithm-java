package 백준_문제집;

import java.io.*;
import java.util.*;

public class 탑2 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String[] info = br.readLine().split(" ");
		int[] tower = new int[N+1];
		int[] cnt = new int[N+1];
		int[] near = new int[N+1];
		for (int i = 1; i <= N; i++) {
			tower[i] = Integer.parseInt(info[i-1]);
			near[i] = -100000;
		}

		Stack<Integer> leftStack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			while (!leftStack.isEmpty() && tower[leftStack.peek()] <= tower[i]) {
				leftStack.pop();
			}
			cnt[i] += leftStack.size();
			if (cnt[i] != 0) {
				near[i] = leftStack.peek();
			}
			leftStack.push(i);
		}

		Stack<Integer> rightStack = new Stack<>();
		for (int i = N; i > 0; i--) {
			while (!rightStack.isEmpty() && tower[rightStack.peek()] <= tower[i]) {
				rightStack.pop();
			}
			cnt[i] += rightStack.size();
			if (!rightStack.isEmpty() && rightStack.peek()-i < i - near[i]) {
				near[i] = rightStack.peek();
			}
			rightStack.push(i);
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) {
				System.out.println(0);
			} else{
				System.out.println(cnt[i] + " " + near[i]);
			}
		}
	}
}
