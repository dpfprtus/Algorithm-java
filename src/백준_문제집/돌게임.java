package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //상근 1개 시작
        //상근 3개 시작

        if(n % 2 == 0){
            System.out.println("CY");
        } else{
            System.out.println("SK");
        }

    }

}
