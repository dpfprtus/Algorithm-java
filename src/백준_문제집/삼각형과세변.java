package 백준_문제집;

import java.io.*;

class 삼각형과세변 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            String[] numbers = br.readLine().split(" ");

            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);

            if(a == 0 && b == 0 && c == 0){
                break;
            }

            int maxNum = Math.max(Math.max(a, b), c);
            int sum = a+b+c;

            if(sum-maxNum <= maxNum){
                bw.write("Invalid\n");
                continue;
            }

            if (a == b && b == c) {
                bw.write("Equilateral\n");
                continue;
            }

            if (a != b && b != c && c != a) {
                bw.write("Scalene\n");
                continue;
            }
            bw.write("Isosceles\n");

        }
        br.close();
        bw.flush();
        bw.close();
    }
}
