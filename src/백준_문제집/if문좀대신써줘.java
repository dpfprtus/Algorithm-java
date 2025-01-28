package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//이분탐색
public class if문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        String[][] title = new String[N][2];

        for (int i = 0; i < N; i++) {
            info = br.readLine().split(" ");
            String word = info[0];
            String nums = info[1];
            title[i][0] = word;
            title[i][1] = nums;
        }

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N-1;
            int mid = 0;
            while (left <= right) {

                mid = (left + right) / 2;
                int target = Integer.parseInt(title[mid][1]);
                if (num > target) {
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
            bw.write(title[left][0]+"\n");
        }
        
        
        bw.flush();
        bw.close();
        br.close();
    }
}
