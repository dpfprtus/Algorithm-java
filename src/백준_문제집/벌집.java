package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 1;

        long first = 1;
        long multiple = 6;

        while(true){

            if(n <= first ){
                break;
            }
            first = first + multiple;
            multiple += 6;
            answer++;
        }

        System.out.println(answer);

    }
}
