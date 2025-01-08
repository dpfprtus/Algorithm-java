package 백준_문제집;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 비밀번호발음하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> noun = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        while (true) {

            String testCase = br.readLine();
            String result = "";
            if(testCase.equals("end")) break;

            int nounFlag = 0;
            int mounFlag = 0;
            int previousFlag = 1;
            int aeiou = 0;
            char previous = '1';
            for (char a : testCase.toCharArray()) {

                if (a == previous) {
                    if(a != 'e' && a!='o') previousFlag++;

                }else{
                    previousFlag = 1;
                }
                previous = a;

                if(noun.contains(a)) {
                    nounFlag++;
                    mounFlag = 0;
                    aeiou = 1;
                } else{
                    nounFlag = 0;
                    mounFlag++;
                }

                if (nounFlag >= 3 || mounFlag >= 3 || previousFlag >= 2) {
                    result = "is not acceptable.";
                    break;
                }

            }

            if (aeiou == 0) {
                result = "is not acceptable.";
            }

            if (!result.equals("is not acceptable.")) {
                result = "is acceptable.";
            }
            bw.write("<"+testCase+"> "+result+"\n");






        }
        bw.flush();
        bw.close();
        br.close();

    }
}
