package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //짝수 개의 0과 짝수 개의 1로 구성 -> 4의 배수,
        String s = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            } else{
                oneCnt++;
            }
        }

        char[] charArr = s.toCharArray();
        int tmp = 0;
        for (int i = 0; i < charArr.length; i++) {

            if (charArr[i] == '1') {
                charArr[i] = '2';
                tmp++;
            }
            if(tmp == oneCnt/2) break;

        }
        tmp = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {

            if (charArr[i] == '0') {
                charArr[i] = '3';
                tmp++;
            }
            if(tmp == zeroCnt / 2 ) break;

        }
        for (char a : charArr) {
            if(a == '2' || a == '3') continue;
            bw.write(a);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
