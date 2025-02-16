package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2 {
    static int answer = 0;
    static String tmp1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 문자열 뒤에 A추가
        //2. 문자열 뒤에 B추가 -> 문자열 반전
        //S->T 가능?

        tmp1 =  br.readLine();
        String tmp2 = br.readLine();

        dfs(tmp2);
        System.out.print(answer);
    }

    public static void dfs(String str2) {

        if (tmp1.length() == str2.length()) {
            if (tmp1.equals(str2)) {
                answer = 1;
            }
            return;
        }

        int length = str2.length();

        if (str2.charAt(0) == 'B'){
            dfs(new StringBuilder(str2.substring(1)).reverse().toString());
        }

        if (str2.charAt(length - 1) == 'A') {
            dfs(str2.substring(0,length-1));
        }

    }

}
