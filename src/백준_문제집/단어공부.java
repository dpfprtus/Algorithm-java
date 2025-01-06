package 백준_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toLowerCase();

        Map<Character,Integer> dic = new HashMap<>();

        for (char c : input.toCharArray()) {

            if(!dic.containsKey(c)){
                dic.put(c,1);
            }else{
                dic.put(c,dic.get(c)+1);
            }
        }

        int answer = 0;
        Character result = 'A';
        for(Map.Entry<Character,Integer> entry : dic.entrySet()){
            Integer tmp = entry.getValue();
            if (tmp > answer) {
                answer = tmp;
                result = entry.getKey().toString().toUpperCase().charAt(0);
            } else if (tmp == answer) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
