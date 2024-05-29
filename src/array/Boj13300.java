package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] room = new int[6][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            room[x-1][y] += 1;
        }

        int cnt = 0;
        for(int i=0; i<6;i++){
            if(room[i][0]%K==0){
                cnt += room[i][0] / K;
            }else{
                cnt += room[i][0] / K + 1;
            }

            if(room[i][1]%K==0){
                cnt += room[i][1] / K;
            }else{
                cnt += room[i][1] / K + 1;
            }
        }

        System.out.println(cnt);
    }
}