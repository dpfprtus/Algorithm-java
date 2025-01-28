package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class KCPC {

    static class Team{
        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //시간 순서대로 저장
        //여러번 제출 시 최고 점수 = 최종 점수
        //한 문제도 안 풀면 최종 점수 = 0

        //점수가 동일한 팀
        //1. 최종 점수가 같으면, 풀이 제출 횟수가 적은 팀이 높은 순위
        //2. 최정 점수가 같고, 제출 횟수도 같다면 마지막 제출 시간이 더 빠른 팀이 높은 순위
        //동시 제출x, 모든 팀이 한번은 풀이를 제출



        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            String[] info = br.readLine().split(" ");

            //팀의 개수
            int n = Integer.parseInt(info[0]);

            //문재 개수
            int k = Integer.parseInt(info[1]);

            //내 팀 id
            int t = Integer.parseInt(info[2]);

            //로그 갯수
            int m = Integer.parseInt(info[3]);

            Team[] teamList = new Team[n];

            for (int j = 0; j < m; j++) {
                info = br.readLine().split(" ");
                int teamId = Integer.parseInt(info[0]);
                int problemNum = Integer.parseInt(info[1]);
                int score = Integer.parseInt(info[2]);
                if (teamList[teamId - 1] == null) {
                    teamList[teamId - 1] = new Team();
                    teamList[teamId - 1].id = teamId;
                    teamList[teamId - 1].scoreList = new int[k + 1];
                }
                teamList[teamId - 1].scoreList[problemNum] = Math.max(score,
                        teamList[teamId - 1].scoreList[problemNum]);
                teamList[teamId-1].submitNum++;
                teamList[teamId-1].lastSubmit = j;
            }

            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int p = 1; p <= k; p++) {
                    teamList[j].totalScore += teamList[j].scoreList[p];
                }
            }


            Arrays.sort(teamList, (o1, o2) -> {
                if (o1.totalScore == o2.totalScore) {
                    if (o1.submitNum == o2.submitNum) {
                        return o1.lastSubmit - o2.lastSubmit;
                    }
                    return o1.submitNum - o2.submitNum;
                }
                return o2.totalScore - o1.totalScore;
            });

            for (int j = 0; j < n; j++) {

                if (teamList[j].id == t) {
                    bw.append(j + 1 +"\n");
                    break;
                }
            }


        }
        bw.flush();
        bw.close();
        br.close();

    }
}
