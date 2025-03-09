package 백준_문제집;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 틱택토 {
    static int[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            char[] input = br.readLine().toCharArray();
            if(input[0] == 'e') break;
            int idx = 0;
            int oCount = 0;
            int xCount = 0;
            board = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input[idx++];
                    if(board[i][j] == 'O') oCount++;
                    else if(board[i][j] == 'X') xCount++;
                }
            }

            if (xCount == oCount + 1) {
                if (xCount + oCount == 9 && !bingo('O')) {
                    bw.write("valid\n");
                } else if (bingo('X') && !bingo('O')) {
                    bw.write("valid\n");
                } else {
                    bw.write("invalid\n");
                }
            } else if (xCount == oCount) {
                if (!bingo('X') && bingo('O')) {
                    bw.write("valid\n");
                } else{
                    bw.write("invalid\n");
                }
            } else{
                bw.write("invalid\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean bingo(char c) {
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
        }

        for (int i = 0; i < 3; i++) {
            if(board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
        }

        if(board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if(board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;
        return false;
    }


}
