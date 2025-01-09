package 백준_문제집;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class 쿠키의신체측정 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        int heartX = 0;
        int heartY = 0;

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp[j];
            }
            if(heartX == 0){
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        heartX = i+1;
                        heartY = j;
                    }
                }
            }

        }
        int leftArm = 0;
        int rightArm = 0;
        int middle = 0;
        //팔 길이
        for (int i = heartY-1; i >= 0; i--) {
            if(map[heartX][i] == '*'){
                leftArm++;
            }
        }
        for (int i = heartY+1; i < n; i++) {
            if(map[heartX][i] == '*'){
                rightArm++;
            }
        }

        //허리 길이
        for (int i = heartX+1; i < n; i++) {
            if(map[i][heartY] == '*') {
                middle++;
            }
        }

        int leftLeg = 0;
        int rightLeg = 0;
        //다리 길이
        for (int i = heartX+middle+1; i <n; i++) {
            if (map[i][heartY - 1] == '*') {
                leftLeg++;
            }
        }
        for (int i = heartX+middle+1; i < n; i++) {
            if (map[i][heartY + 1] == '*') {
                rightLeg++;
            }
        }
        System.out.println(heartX+1+" "+(heartY+1));
        System.out.println(leftArm + " " + rightArm + " " + middle + " " + leftLeg + " " + rightLeg);

    }
}
