package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder result = new StringBuilder();
        int bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));

            if (result.length() >= bombLen) {
                boolean isBoomb = true;
                for (int j = 0; j < bombLen; j++) {
                    if (result.charAt(result.length() - bombLen + j) != bomb.charAt(j)) {
                        isBoomb = false;
                        break;
                    }
                }
                if (isBoomb) {
                    result.delete(result.length() - bombLen, result.length());
                }
            }
        }

        if (result.length() == 0) {
            System.out.println("FRULA");
        } else{
            System.out.println(result);
        }

    }
}
