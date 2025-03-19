package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;

public class 숫자카드2 {
	static int N;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		String[] info = br.readLine().split(" ");
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(info[i]);

		}
		Arrays.sort(nums);
		int M = Integer.parseInt(br.readLine());
		info = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(info[i]);
			int flag = binarySearch2(a) - binarySearch(a);
			bw.write(flag+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static int binarySearch(int n) {
		int left = 0;
		int right = N;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] >= n) {
				right = mid;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}

	public static int binarySearch2(int n) {
		int left = 0;
		int right = N;
		while (left < right) {
			int mid = (left+right) / 2;
			if (nums[mid] > n) {
				right = mid;
			} else{
				left = mid + 1;
			}
		}
		return left;
	}
}
