package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] paper = new int[101][101];
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=x; j<x+10;j++){
                for(int k=y;k<y+10;k++){
                    paper[j][k]++;
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++){
                if(paper[i][j]>1) cnt+=paper[i][j]-1;
            }
        }
        System.out.println(100*N-cnt);
    }
}