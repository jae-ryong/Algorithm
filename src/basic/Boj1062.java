package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj1062 {
    static int N;
    static int K;
    static int[] arr;
    static String[] words;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K<5){
            System.out.println(0);
            return;
        }else if(K==26){
            System.out.println(N);
            return;
        }

        arr = new int[26];
        arr['a'-'a'] = 1;
        arr['c'-'a'] = 1;
        arr['i'-'a'] = 1;
        arr['t'-'a'] = 1;
        arr['n'-'a'] = 1;
        words = new String[N];
        for(int i=0;i<N;i++){
            String word = br.readLine();
            word = word.replace("anta","");
            word = word.replace("tica","");
            words[i] = word;
        }
        dfs(0,0);
        System.out.println(max);
    }

    public static void dfs(int idx,int L){
        if(L==K-5){
            int cnt = 0;
            for(int i=0;i<words.length;i++){
                boolean flag = true;
                for(int j=0;j<words[i].length();j++){
                    if(arr[words[i].charAt(j)-'a']==0){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            max = Math.max(max,cnt);
            return;
        }

        for(int i=idx;i<26;i++){
            if(arr[i]==0){
                arr[i] = 1;
                dfs(i+1,L+1);
                arr[i] = 0;
            }
        }
    }
}
