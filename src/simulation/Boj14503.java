package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * 1. 작동 멈출때까지 while
 * 2. 4칸 돌면서(반시계 방향) 빈칸 확인 for문
 * - 현재 칸의 주변 4칸중 청소되지 않은 빈칸이 없는 경우
 * - 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
 * */
public class Boj14503 {

    static int[][] map;
    static int N;
    static int M;
    static int x,y,d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                cnt++;
            }
            boolean check = false;
            // 현재 칸의 주변 칸 중 청소되지 않은 빈 칸이 있는 경우
            for(int i=0;i<4;i++) {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    check = true;
                    break;
                }

            }
            // 현재 칸의 주변 칸 중 청소되지 않은 빈 칸이 없는 경우
            if(!check) {

                int nx = x + dx[(d + 2) % 4];
                int ny = y + dy[(d + 2) % 4];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny]==1) {
                    break;
                } else {
                    x = nx;
                    y = ny;
                }
            }
        }
        System.out.println(cnt);
    }
}