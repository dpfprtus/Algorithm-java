package 백준_문제집;

import java.util.*;
import java.io.*;

public class 비슷한단어2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        int maxCnt = 0;
        String answer = "";
        String answer2 = "";
        for (int i = 0; i < N-1; i++) {
            String str1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                String str2 = list.get(j);
                int cnt = 0;
                int size = Math.min(str1.length(), str2.length());
                for (int k = 0; k < size; k++) {
                    if(str1.charAt(k) == str2.charAt(k)){
                        cnt++;
                        continue;
                    }
                    break;
                }
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    answer = str1;
                    answer2 = str2;
                }
            }


        }
        System.out.println(answer);
        System.out.println(answer2);

    }
}
