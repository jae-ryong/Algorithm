package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1038 {
    static int N;
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N>=0 && N<=10){
            System.out.println(N);
            return;
        }else if(N>=1023){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<10;i++){
            dfs(i,0);
        }
        Collections.sort(list);
        System.out.println(list.get(N));
    }

    public static void dfs(long n,int idx){
        if(idx>10) return;

        list.add(n);
        for(int i=0;i<n%10;i++){
            dfs(n*10+i,idx+1);
        }
    }
}
