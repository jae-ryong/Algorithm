package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888 {
    static int N;
    static int[] arr;
    static int[] operation;
    static int[] ch;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }
        ch = new int[N-1];
        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int L){
        if(L==N-1){
            int answer = arr[0];
            for(int i=0;i<arr.length-1;i++){
                if(ch[i] == 0){
                    answer += arr[i+1];
                }else if(ch[i] == 1){
                    answer -= arr[i+1];
                }else if(ch[i] == 2){
                    answer *= arr[i+1];
                }else if (ch[i] == 3){
                    if(answer >0){
                        answer /= arr[i+1];
                    }else{
                        answer *= -1;
                        answer /= arr[i+1];
                        answer *= -1;
                    }
                }
            }
            max = Math.max(max, answer);
            min = Math.min(min, answer);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operation[i] >0){
                ch[L] = i;
                operation[i]--;
                dfs(L+1);
                operation[i]++;
            }
        }
    }
}
