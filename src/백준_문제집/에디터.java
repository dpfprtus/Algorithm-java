package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder word = new StringBuilder(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int cursor = word.length();
        for (int i = 0; i < M; i++) {
            String[] info = br.readLine().split(" ");

            if (info[0].equals("L")) {
                if(cursor == 0) continue;
                cursor--;
            } else if (info[0].equals("D")) {
                if(cursor == word.length()) continue;
                cursor++;
            } else if (info[0].equals("B")) {
                if(cursor == 0) continue;
                word.delete(cursor-1, cursor);
                cursor--;

            } else {
                word.insert(cursor, info[1]);
                cursor++;
            }
        }
        System.out.print(word);
    }
}
