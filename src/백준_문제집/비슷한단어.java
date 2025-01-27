package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class 비슷한단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 두 개의 단어가 같은 종류의 문자로 구성
        //2. 같은 문자는 같은 개수 만큼

        int N = Integer.parseInt(br.readLine());

        //첫 번째 단어
        String firstWord = br.readLine();

        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            String word = br.readLine();
            int[] wordCheck = new int[26];
            int cnt = 0;
            for (int j = 0; j < firstWord.length(); j++) {
                wordCheck[firstWord.charAt(j) - 'A']++;
            }

            for (int j = 0; j < word.length(); j++) {
                if (wordCheck[word.charAt(j) - 'A'] > 0) {
                    cnt++;
                    wordCheck[word.charAt(j) - 'A']--;
                }
            }

            if (word.length() == firstWord.length() && (firstWord.length() == cnt || firstWord.length() - 1 == cnt)) {
                answer++;
            } else if (word.length() - 1 == firstWord.length() && word.length() - 1 == cnt) {
                answer++;
            } else if (word.length() + 1 == firstWord.length() && word.length() == cnt) {
                answer++;
            }

        }
        System.out.print(answer);
    }
}
