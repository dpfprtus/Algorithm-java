package 백준_문제집;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class 영단어암기는괴로워 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1. 자주 나오는 단어일수록 앞에 배치한다.
        //2. 해당 단어의 길이가 길수록 앞에 배치한다.
        //3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다

        //4. 길이가 M이상인 것만 암기

        //입력: 소문자, 10자 이하
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            if(str.length() < M) continue;
            wordFrequency.put(str, wordFrequency.getOrDefault(str, 0) + 1);

        }
        TreeSet<String> set = new TreeSet<>((a,b)->{
            
            //빈도수 비교
            int freqCompare = wordFrequency.get(b).compareTo(wordFrequency.get(a));
            if(freqCompare != 0) return freqCompare;

            //단어 길이 비교
            int lengthCompare = Integer.compare(b.length(), a.length());
            if(lengthCompare !=0) return lengthCompare;

            
            //알파벳 비교
            return a.compareTo(b);
        });

        set.addAll(wordFrequency.keySet());
        for (String a : set) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
