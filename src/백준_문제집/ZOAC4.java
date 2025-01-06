package 백준_문제집;

import java.util.Scanner;

public class ZOAC4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int H = in.nextInt();
        int W = in.nextInt();
        int N = in.nextInt();
        int M = in.nextInt();

        //첫 번째 요소에 대해서는 거리두기 규칙을 적용할 필요가 없다.
        int a = (H-1)/(N+1)+1;
        int b = (W-1)/(M+1)+1;

        System.out.println(a*b);
    }

}
