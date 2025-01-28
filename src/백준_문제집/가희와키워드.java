package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        //Map 자료구조 -> keyword : 갯수
        //keyword 갯수가 1인 것만 카운팅
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }
        int cnt = map.size();
        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(",");

            for (String s : strArr) {
                if(map.get(s) == null) continue;
                if (map.get(s) == 1) {
                    map.put(s, 0);
                    cnt--;
                }
            }
            System.out.println(cnt);
        }
    }
}
