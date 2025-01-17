package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //요구사항
        //1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
        //2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.

        //풀이
        //최적화 -> 결정 문제

        //지방의 수
        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        //예산 요청
        String[] info = br.readLine().split(" ");
        int[] budgets = new int[N];
        long right = -1;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(info[i]);
            right = Math.max(right, budgets[i]);
        }

        //총 예산
        long totalBudget = Integer.parseInt(br.readLine());

        //출력 : 배정된 예산들 중 최댓값
        long left = 0;


        while (left <= right) {

            long mid = (left + right)/2;

            long sumNum = 0;

            for (int i = 0; i < N; i++) {
                if (budgets[i] <= mid) {
                    sumNum += budgets[i];
                } else{
                    sumNum += mid;
                }
            }

            if (sumNum <= totalBudget) {
                left = mid + 1;

            } else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }


}
