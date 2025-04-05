package 백준_문제집;

import java.util.*;
import java.io.*;

public class 좋다 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] info = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(info[i]);
        }

        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while(left != right){
                int num = nums[i];
                if(left == i)left++;
                else if(right == i) right--;
                int sum = nums[left] + nums[right];

                if(left == right) break;

                if (sum == num) {
                    cnt++;
                    break;
                } else if (sum > num) {
                    right--;
                } else{
                    left++;
                }
            }
        }
        System.out.println(cnt);
    }


}
