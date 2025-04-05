package 백준_문제집;

import java.util.*;
import java.io.*;

public class 공유기설치 {
    static int[] visited,home;
    static int answer = 0;
    static int N,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);

        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int maxLen = home[N - 1] - home[0]+1;
        int left = 1;
        int right = maxLen;

        while (left < right) {
            int mid = (left+right) / 2;

            if (cal(mid) < C) {
                right = mid;
            } else{
                left = mid+1;
            }
        }


        System.out.println(left-1);

    }

    static int cal(int len) {
        int cnt = 1;
        int location = home[0];
        for (int i = 1; i < N; i++) {
            if (location + len <= home[i]) {
                cnt++;
                location = home[i];
            }
        }
        return cnt;
    }
}
