package 백준_문제집;

import java.io.*;

public class 덩치 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dong = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            dong[i][0] = Integer.parseInt(info[0]);
            dong[i][1] = Integer.parseInt(info[1]);
        }

        for (int i = 0; i < N; i++) {
            int order = 1;
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                if(dong[i][0] < dong[j][0] && dong[i][1] < dong[j][1]) order++;
            }
            bw.write(order+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
