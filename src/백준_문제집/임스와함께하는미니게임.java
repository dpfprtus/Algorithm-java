package 백준_문제집;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class 임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        String gameType = info[1];
        Set<String> set = new HashSet<>();

        int result = 0;

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        if (gameType.equals("Y")) {
            result = set.size();
        } else if (gameType.equals("F")) {
            if(set.size() >= 2){
                result = set.size()/2;
            }
        } else if (gameType.equals("O")) {
            if(set.size()>=3) result = set.size() / 3;

        }


        System.out.println(result);

    }
}
