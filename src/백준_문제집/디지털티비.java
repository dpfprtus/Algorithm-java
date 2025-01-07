package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 디지털티비 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        String answer = "";
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if(list.get(i).equals("KBS1")){
                break;
            }
            idx++;
        }
        list.remove(idx);
        list.add(0, "KBS1");
        answer = "1".repeat(idx)+"4".repeat(idx);
        idx = 0;

        for(int i = 0;i<n;i++){
            if(list.get(i).equals("KBS2")){
                break;
            }
            idx++;
        }


        answer += "1".repeat(idx)+"4".repeat(idx-1);



        System.out.println(answer);
    }
}
