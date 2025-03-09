package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 숫자고르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums1 = new int[N];

        for (int i = 1; i <= N; i++) {
            nums1[i-1] = i;
        }

        int[] nums2 = new int[N];
        for (int i = 0; i < N; i++) {
            nums2[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tmp = nums2[i];
            int cnt = 0;
            while (cnt <= N && tmp != nums1[i]) {
                tmp = nums2[tmp-1];
                if(tmp == nums1[i]) break;
                cnt++;
            }
            if (tmp == nums1[i]) {
                answer++;
                list.add(nums1[i]);
            }
        }
        System.out.println(answer);
        for (int a : list) {
            System.out.println(a);
        }

    }
}
