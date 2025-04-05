package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ListOfUniqueNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        int[] nums = new int[N+1];
        int maxNum = 0;
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(info[i-1]);
            maxNum = Math.max(maxNum, nums[i]);
        }

        boolean[] visited = new boolean[1000001];
        long answer = 0;
        int left = 1;
        int right = 0;
        while(left <= N){

            while (right <= N-1 && !visited[nums[right+1]]) {
                right++;
                visited[nums[right]] = true;
            }
            answer += (right-left)+1;
            visited[nums[left++]] = false;

        }

        System.out.println(answer);


    }
}
