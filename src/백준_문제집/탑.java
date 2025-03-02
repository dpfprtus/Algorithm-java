package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];
        int[] answer = new int[N];
        answer[0] = 0;
        String[] info = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(info[i]);
        }

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0,top[0]});
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < top[i]) {
                stack.pop();
            }
            if(!stack.isEmpty())answer[i] = stack.peek()[0]+1;
            stack.add(new int[]{i, top[i]});
        }
        for(int a : answer) System.out.print(a+" ");
    }
}
