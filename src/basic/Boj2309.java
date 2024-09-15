package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2309 {
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        dfs(0,0);
    }

    public static void dfs (int idx, int L){
        if(L==7){
            int hap = 0;
            for(int i=0; i<9; i++){
                if(visited[i]){
                    hap += arr[i];
                }
            }
            if(hap==100){
                for(int i=0; i<9; i++){
                    if(visited[i]){
                        System.out.println(arr[i]);
                    }
                }
                System.exit(0);
            }
            return;
        }
        for(int i=idx; i<9; i++){
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, L+1);
                visited[i] = false;
            }
        }
    }
}
