package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14888 {
    static int N;
    static int[] arr;
    static int[] operation;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        operation = new int[4];
        for(int i=0;i<4;i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,N-1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int L, int Dep){
        if(L==Dep){
            boolean ck = true;
            for(int i=0;i<4;i++){
                if(operation[i]!=0) ck = false;
            }

            if(ck){
                int sum = arr[0];
                for(int i=0;i<list.size();i++){
                    switch (list.get(i)) {
                        case 0:
                            sum += arr[i+1];
                            break;
                        case 1:
                            sum -= arr[i+1];
                            break;
                        case 2:
                            sum *= arr[i+1];
                            break;
                        case 3:
                            if(sum>0){
                                sum /= arr[i+1];
                            }else{
                                sum = Math.abs(sum);
                                sum /= arr[i+1];
                                sum *= -1;
                            }
                            break;
                    }
                }
                max = Math.max(max,sum);
                min = Math.min(min,sum);
            }
            return;
        }
        for(int i=0;i<4;i++){
            operation[i]--;
            list.add(i);
            dfs(L+1,Dep);
            list.remove(list.size()-1);
            operation[i]++;
        }
    }
}
