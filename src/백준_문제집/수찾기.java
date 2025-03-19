package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수찾기 {
	static int N,M;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String[] info = br.readLine().split(" ");
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(info[i]);
		}
		Arrays.sort(nums);

		M = Integer.parseInt(br.readLine());
		int[] checkNums = new int[M];
		info = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			checkNums[i] = Integer.parseInt(info[i]);
			System.out.println(binarySearch(checkNums[i]));
		}
	}

	public static int binarySearch(int n) {
		int left = 0;
		int right = N-1;
		while (left <= right) {
			int mid = (left+right) / 2;
			if(nums[mid] == n) return 1;
			if (nums[mid] < n) {
				left = mid+1;
			} else{
				right = mid-1;
			}
		}
		return 0;
	}
}
