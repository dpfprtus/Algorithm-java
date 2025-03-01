package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int N = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = -1;

            if (N == 1) {
                System.out.println("1 1");
                continue;
            }
            int[] alphabet = new int[26];
            for (int j = 0; j < str.length(); j++) {
                alphabet[str.charAt(j) - 'a']++;
            }

            for (int j = 0; j < str.length(); j++) {
                if(alphabet[str.charAt(j)-'a'] < N) continue;
                int cnt = 1;
                for (int k = j + 1; k < str.length(); k++) {
                    if (str.charAt(j) == str.charAt(k)) {
                        cnt++;
                    }
                    if (cnt == N) {
                        min = Math.min(min, k - j + 1);
                        max = Math.max(max, k - j + 1);
                        break;
                    }
                }
            }

            if (max == -1 || min == Integer.MAX_VALUE) {
                System.out.println("-1");
            }else{
                System.out.println(min + " " + max);

            }
        }
    }
}
