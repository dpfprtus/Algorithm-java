package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 랭킹전대기열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //매칭 가능한 방 x -> 새로운 방 생성 & 입장
        //입장 가능한 방 o -> 입장 & 정원 마감까지 대기(먼저 생성된 방 먼저)
        //풀방되면 시작
        //닉네임 중복 x

        String[] info = br.readLine().split(" ");
        int P = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        List<List<String[][]>> list = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            info = br.readLine().split(" ");
            String level = info[0];
            String nickname = info[1];

            if (list.isEmpty()) {
                String[] tmp = new String[]{level, nickname};
                List<String[][]> q = new ArrayList<>();
                q.add(new String[][]{tmp});
                list.add(q);
                continue;
            }

            int flag = 0;

            for (int j = 0; j < list.size(); j++) {
                int listLevel = Integer.parseInt(list.get(j).get(0)[0][0]);
                if (Integer.parseInt(level) <= listLevel + 10 && Integer.parseInt(level) >= listLevel - 10
                        && list.get(j).size() < m) {
                    String[] tmp = new String[]{level, nickname};
                    list.get(j).add(new String[][]{tmp});
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                List<String[][]> tmpQ = new ArrayList<>();
                tmpQ.add(new String[][]{{level, nickname}});
                list.add(tmpQ);
            }

        }
        int cnt = 0;
        for (List<String[][]> q : list) {
            int size = q.size();
            q.sort(Comparator.comparing(a -> a[0][1]));
            if (size < m) {
                bw.write("Waiting!\n");

            } else if (size == m) {
                bw.write("Started!\n");
            }
            for (int i = 0;i<q.size();i++) {
                String[] tmp = q.get(i)[0];
                bw.write(tmp[0] + " " + tmp[1]);
                if (i != q.size()-1) {
                    bw.write("\n");
                }
            }
            cnt++;
            if (cnt == list.size()) {
                break;
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
