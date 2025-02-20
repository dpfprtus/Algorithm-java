package 백준_문제집;

import java.io.*;

public class 줄세우기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            String[] info  = br.readLine().split(" ");
            int[] nums = new int[21];
            for (int j = 0; j < 21; j++) {
                nums[j] = Integer.parseInt(info[j]);
            }

            int answer = 0;
            for (int j = 1; j < 21; j++) {
                int cnt = 0;
                for (int k = 1; k < j; k++) {
                    if(nums[j] < nums[k]){
                        cnt++;
                    }
                }
                answer += cnt;
            }
            System.out.println(nums[0] + " " + answer);

        }
    }
}
