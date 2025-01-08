package 백준_문제집;

import java.io.*;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        boolean[] set = new boolean[21];

        for (int i = 0; i < m; i++) {

            String[] order = br.readLine().split(" ");


            if(order[0].equals("add")){
                int num = Integer.parseInt(order[1]);
                set[num] = true;
            } else if (order[0].equals("remove")) {
                int num = Integer.parseInt(order[1]);
                set[num] = false;

            } else if (order[0].equals("toggle")) {
                int num = Integer.parseInt(order[1]);
                if(set[num]){
                    set[num] = false;
                    continue;
                }
                set[num] = true;
            } else if (order[0].equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set[j] = true;
                }

            } else if (order[0].equals("empty")) {
                set = new boolean[21];
            } else if (order[0].equals("check")) {
                int num = Integer.parseInt(order[1]);
                if(set[num]){
                    writer.write("1\n");

                    continue;
                }
                writer.write("0\n");


            }
        }
        writer.flush();
        br.close();
        writer.close();
    }
}
