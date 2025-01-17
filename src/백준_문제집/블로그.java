package 백준_문제집;

import java.io.*;
import java.util.*;

public class 블로그 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();

        String[] info = br.readLine().split(" ");

        int N = Integer.parseInt(info[0]);
        int X = Integer.parseInt(info[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] list = new int[N];
        int[] prefxSum = new int[N+1];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        //누적합
        for (int i = 0; i < N; i++) {
            prefxSum[i + 1] = prefxSum[i] + list[i];
        }


        int sum = 0;
        int maxNum = 0;

        for (int i = 1; i <= N - X+ 1; i++) {
            sum = prefxSum[i+X-1] - prefxSum[i-1];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxNum = Math.max(maxNum, sum);
        }

        if (maxNum == 0) {
            bw.write("SAD");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        bw.write(maxNum + "\n");
        bw.write(map.get(maxNum)+"");
        bw.flush();
        bw.close();
        br.close();

    }
}

