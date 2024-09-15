package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16897 {
    static int[][] gaeran;
    static int N;
    static int maxCnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //[][0]은 내구도, [][1]은 무게
        gaeran = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gaeran[i][0] = Integer.parseInt(st.nextToken());
            gaeran[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(maxCnt);
    }

    public static void dfs(int idx, int brokeCnt){
        if(idx == N) {
            maxCnt = Math.max(maxCnt, brokeCnt);
            return;
        }

        // 다 깨졌거나 들고 있는 계란의 내구도가 작은 경우
        if(brokeCnt == N-1 || gaeran[idx][0]<=0){
            dfs(idx+1,brokeCnt);
            return;
        }

        int nCnt = brokeCnt;
        for(int i=0;i<N;i++){
            // 현재 들고 있는 경우
            if(i==idx) continue;
            // 이미 깨진 계란인 경우
            if(gaeran[i][0]<=0) continue;

            hitegg(idx,i);

            if(gaeran[i][0]<=0) brokeCnt++;
            if(gaeran[idx][0]<=0) brokeCnt++;

            dfs(idx+1,brokeCnt);

            restoreegg(idx,i);
            brokeCnt = nCnt;

        }

    }

    public static void hitegg(int standard, int end){
        gaeran[standard][0] -= gaeran[end][1];
        gaeran[end][0] -= gaeran[standard][1];
    }

    public static void restoreegg(int standard, int end){
        gaeran[standard][0] += gaeran[end][1];
        gaeran[end][0] += gaeran[standard][1];
    }
}
