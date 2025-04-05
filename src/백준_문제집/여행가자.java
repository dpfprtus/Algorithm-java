package 백준_문제집;

import java.util.*;
import java.io.*;

public class 여행가자 {
    static int[] parent;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int flag = 0;
        int a = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            int b = Integer.parseInt(st.nextToken());
            if(!isSameParent(a, b)){
                flag = 1;
            }
            a = b;
        }

        if(flag == 1){
            System.out.println("NO");
        } else{
            System.out.println("YES");
        }

    }

    static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA != parentB) {
            if (parentA < parentB) {
                parent[parentB] = parentA;
            } else{
                parent[parentA] = parentB;
            }
        }
    }

    static boolean isSameParent(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        return parentA == parentB;
    }

    static int findParent(int a) {

        if (a == parent[a]) {
            return a;
        } else{
            return parent[a] = findParent(parent[a]);
        }
    }
}
