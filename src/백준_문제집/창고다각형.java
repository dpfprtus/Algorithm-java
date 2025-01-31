package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class 창고다각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 오목한 부분x
        //2. 면적이 가장 작은 창고를 만들어야 함.
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = 0;
        int max_x = 0, max_y = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arr[L] = H;
            start = Math.min(L, start);
            end = Math.max(L, end);
            if (max_y < H) {
                max_y = H;
                max_x = L;
            }
         }
        int answer = max_y;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{start, arr[start]});
        for (int i = start+1; i <= max_x; i++) {
            if(arr[i] == 0) continue;
            int[] peek = stack.peek();
            if (peek[1] <= arr[i]) {
                answer += (i - peek[0]) * peek[1];
                stack.pop();
                stack.add(new int[]{i, arr[i]});
            }
        }

        stack.clear();
        stack.add(new int[]{end, arr[end]});
        for (int i = end-1; i >= max_x; i--) {
            if(arr[i] == 0) continue;
            int[] peek = stack.peek();
            if (peek[1] <= arr[i]) {
                answer += (peek[0] - i) * peek[1];
                stack.pop();
                stack.add(new int[]{i, arr[i]});
            }
        }
        System.out.print(answer);
    }
}
