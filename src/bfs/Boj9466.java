package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9466 {
    static int T;
    static int N;
    static boolean[] visited;
    static int[] arr;
    static int count;
    static boolean[] done;
    /*
    * 1. 혼자 팀을 하고 싶은 사람은 팀을 이룰 수 없다
    * 2. 팀을 이루기 위해서는 서로 이루어야한다
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            done = new boolean[N+1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(i == arr[i]){
                    done[i] = true;
                    count++;
                }
            }

            for(int i=1; i<=N; i++) {
                dfs(i);
            }
            System.out.println(N-count);
        }

    }

    static void dfs(int i) {
        if(visited[i]){
            done[i] = true;
            count++;
        } else{
            visited[i] = true;
        }

        if(!done[arr[i]]){
            dfs(arr[i]);
        }

        visited[i] = false;
        done[i] = true;
    }
}
