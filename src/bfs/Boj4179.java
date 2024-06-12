package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int R;
    static int C;
    static Queue<Point> queue1;
    static Queue<Point> queue2;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] bullVisited;
    static boolean[][] jihunVisited;
    static int[][] bull;
    static int[][] jihun;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bullVisited = new boolean[R][C];
        jihunVisited = new boolean[R][C];
        bull = new int[R][C];
        jihun = new int[R][C];
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        for(int i = 0; i < R; i++){
            String a = br.readLine();
            for(int j = 0; j < C; j++){

                if(a.charAt(j)=='#'){
                    bullVisited[i][j] = true;
                    jihunVisited[i][j] = true;
                    bull[i][j] = -1;
                    jihun[i][j] = -1;
                }else if(a.charAt(j)=='J'){
                    jihunVisited[i][j] = true;
                    bullVisited[i][j] = true;
                    jihun[i][j] = 1;
                    bull[i][j] = -1;
                    queue2.add(new Point(i, j));
                }else if(a.charAt(j)=='F'){
                    jihunVisited[i][j] = true;
                    bullVisited[i][j] = true;
                    bull[i][j] = 1;
                    jihun[i][j] = -1;
                    queue1.add(new Point(i, j));
                }
            }
        }

        // 불 bfs
        while(!queue1.isEmpty()){
            Point a = queue1.poll();
            for(int i=0;i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
                if(bullVisited[nx][ny] || bull[nx][ny]==-1 || bull[nx][ny]>0) continue;
                queue1.add(new Point(nx, ny));
                bull[nx][ny] = bull[a.x][a.y] + 1;
                bullVisited[nx][ny] = true;
            }
        }
        // 지훈 bfs
        while (!queue2.isEmpty()){
            Point a = queue2.poll();
            for(int i=0;i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0 || nx>=R || ny>=C) {
                    answer = jihun[a.x][a.y];
                    System.out.println(answer);
                    return;
                }
                if(jihunVisited[nx][ny] || jihun[nx][ny]==-1 || jihun[nx][ny]>0 || ( bull[nx][ny] != 0 && bull[nx][ny]<=jihun[a.x][a.y] + 1)) continue;
                queue2.add(new Point(nx, ny));
                jihun[nx][ny] = jihun[a.x][a.y] + 1;
                jihunVisited[nx][ny] = true;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
