package 백준_문제집;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//단순히 앞에 키가 더 큰 사람이 몇명인제 세면 된다.
public class 줄세우기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            String[] numbers = br.readLine().split(" ");
            List<Integer> students = new ArrayList<>();
            for (int j = 1; j < numbers.length; j++) {
                students.add(Integer.parseInt(numbers[j]));
            }

            int count = 0;
            List<Integer> list = new ArrayList<>();

            for (Integer height : students) {
                int flag = 0;
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k) > height) {
                        count += list.size()- k;
                        list.add(k, height);
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) list.add(height);

            }

            bw.write(numbers[0] +" "+ count +"\n");

        }
        bw.flush();
        bw.close();
        br.close();


    }
}
