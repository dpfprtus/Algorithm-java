package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class 스위치켜고끄기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //남학생 : 스위치 번호가 본인 수의 배수 -> 스위치 상태 변경
        //여학생 : 본인 번호 중심으로 좌우 대칭이면서 가장 많은 번호 포함 -> 스위치 상태 반전(구간은 항상 홀수)
        int n = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");

        int[] switches = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            switches[i] = Integer.parseInt(info[i-1]);
        }

        int studentNum = Integer.parseInt(br.readLine());
        List<int[]> tmp = new ArrayList<>();

        for (int i = 0; i < studentNum; i++) {
            info = br.readLine().split(" ");
            int sex = Integer.parseInt(info[0]);
            int num = Integer.parseInt(info[1]);
            tmp.add(new int[]{sex,num});

        }

        for (int[] order : tmp) {
            if (order[0] == 1) {
                for (int i = order[1]; i < n+1; i+=order[1]) {
                        if (switches[i] == 0) {
                            switches[i] = 1;
                        } else{
                            switches[i] = 0;
                    }
                }
            } else{
                int startIdx = order[1]-1;
                int endIdx = order[1]+1;
                switches[order[1]] = switches[order[1]] == 1 ? 0 : 1;

                while (startIdx > 0 && endIdx < n + 1) {
                    if (switches[startIdx] != switches[endIdx]) break;
                    switches[endIdx] = switches[endIdx] == 1 ? 0 : 1;
                    switches[startIdx] = switches[startIdx] == 1 ? 0 : 1;
                    startIdx--;
                    endIdx++;

                }

            }
        }

        int cnt = 1;
        for(int i = 1;i<n+1;i++) {

            if(cnt == 20 || i == n){
                bw.write(switches[i] + "\n");
                cnt = 1;
                continue;
            }
            bw.write(switches[i] + " ");
            cnt++;
        }
        bw.flush();
        bw.close();
        br.close();
        //출력 : 한 줄에 20개씩 출력(빈칸 포함)

    }
}
