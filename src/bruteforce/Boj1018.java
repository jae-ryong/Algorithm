package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    static char[] line1 = new char[]{'W','B','W','B','W','B','W','B'};
    static char[] line2 = new char[]{'B','W','B','W','B','W','B','W'};
    static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new char[N][M];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i+7 < N; i++) {
            for(int j = 0; j+7 < M; j++) {
                min = Math.min(min,check(i,j));
            }
        }
        System.out.println(min);
    }

    public static int check(int x, int y) {
        int cnt1= 0;
        int cnt2 = 0;
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if(i%2==0){
                    if(chess[i][j]!=line1[j-y]) cnt1++;
                }else{
                    if(chess[i][j]!=line2[j-y]) cnt1++;
                }
            }
        }

        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if(i%2==0){
                    if(chess[i][j]!=line2[j-y]) cnt2++;
                }else{
                    if(chess[i][j]!=line1[j-y]) cnt2++;
                }
            }
        }

        return Math.min(cnt1,cnt2);
    }
}
