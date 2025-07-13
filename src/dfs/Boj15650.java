package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
    static int N;
    static int M;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[M];
        dfs(1,0);
    }

    public static void dfs(int idx, int L){
        if(L==M){
            for(int i=0;i<ch.length;i++){
                System.out.print(ch[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=idx;i<=N;i++){
            ch[L] = i;
            dfs(i+1,L+1);
        }
    }
}