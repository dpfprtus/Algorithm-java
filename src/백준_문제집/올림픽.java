package 백준_문제집;

import java.io.*;

public class 올림픽 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");

        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        int result = 1;

        int[] golldArray = new int[N];
        int[] silverArray = new int[N];
        int[] blonzeArray = new int[N];


        for (int i = 0; i < N; i++) {
            info = br.readLine().split(" ");
            int country = Integer.parseInt(info[0]);
            int gold = Integer.parseInt(info[1]);
            int silver = Integer.parseInt(info[2]);
            int blonze = Integer.parseInt(info[3]);

            golldArray[country-1] = gold;
            silverArray[country-1] = silver;
            blonzeArray[country-1] = blonze;

        }

        for (int i = 0; i < N; i++) {
            if(i == K-1) continue;
            if (golldArray[i] > golldArray[K - 1]) {
                result++;
            } else if (golldArray[i] == golldArray[K - 1]) {
                if (silverArray[i] > silverArray[K - 1]) {
                    result++;
                } else if (silverArray[i] == silverArray[K - 1]) {
                    if (blonzeArray[i] > blonzeArray[K - 1]) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
