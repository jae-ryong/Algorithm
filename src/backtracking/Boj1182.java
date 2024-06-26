package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182 {
    static int N;
    static int S;
    static int[] ch;
    static boolean[] checked;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            ch = new int[i+1];
            dfs(0,0,i+1);
        }
        System.out.println(cnt);
    }

    public static void dfs(int idx, int L, int R){
        if(L==R){
            int sum = 0;
            for(int a : ch){
                sum += a;
            }
            if(sum == S) cnt++;
            return;
        }
        for(int i=idx; i<N;i++){
            ch[L] = arr[i];
            dfs(i+1,L+1,R);
        }
    }
}

