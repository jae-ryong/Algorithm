package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14889 {
    static int N;
    static int[][] soccer;
    static int[] ch;
    static int[] ch2;
    static int start;
    static int link;
    static int[] startarr;
    static int[] linkarr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        soccer = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                soccer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ch = new int[N/2];
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int L) {
        if(L==N/2){
            boolean[] check = new boolean[N];
            for(int i: ch){
                check[i] = true;
            }
            startarr = new int[N/2];
            linkarr = new int[N/2];
            int k=0;
            int m=0;
            for(int i=0;i<check.length;i++){
                if(check[i]){
                    startarr[k++] = i;
                }else{
                    linkarr[m++] = i;
                }
            }
            ch2 = new int[2];
            start = 0;
            link = 0;
            startdfs(0,0);
            linkdfs(0,0);
            answer = Math.min(answer, Math.abs(start-link));
            return;
        }
        for(int i=idx; i<N; i++){
            ch[L] = i;
            dfs(i+1,L+1);
        }
    }

    private static void linkdfs(int idx, int L) {
        if(L==2){
            int a = ch2[0];
            int b = ch2[1];
            link += soccer[a][b];
            link += soccer[b][a];
            return;
        }
        for(int i=idx;i<N/2;i++){
            ch2[L] = linkarr[i];
            linkdfs(i+1,L+1);
        }
    }

    private static void startdfs(int idx, int L) {
        if(L==2){
            int a = ch2[0];
            int b = ch2[1];
            start += soccer[a][b];
            start += soccer[b][a];
            return;
        }
        for(int i=idx;i<N/2;i++){
            ch2[L] = startarr[i];
            startdfs(i+1,L+1);
        }
    }
}
