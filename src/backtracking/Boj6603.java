package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6603 {
    static int N;
    static int[] arr;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            ch = new int[6];
            dfs(0,0);
            System.out.println();
        }
    }

    public static void dfs(int idx, int L) {
        if(L==6){
            for(int i:ch){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=idx;i<N;i++){
            ch[L] = arr[i];
            dfs(i+1,L+1);
        }
    }
}

