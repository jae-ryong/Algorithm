package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562 {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T;
    static int N;
    static int[][] chess;
    static Queue<Point> queue;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            chess = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            queue.add(new Point(x1,y1));
            chess[x1][y1] = 1;
            //여기서 나이트 얼마나 걸리는 구하는 로직
            while(!queue.isEmpty()){
                Point a = queue.poll();
                for(int i=0;i<8;i++){
                    int  nx = a.x + dx[i];
                    int  ny = a.y + dy[i];
                    if(nx<0||ny<0||nx>=N||ny>=N) continue;
                    if(chess[nx][ny]>=1) continue;
                    queue.add(new Point(nx,ny));
                    chess[nx][ny] = chess[a.x][a.y] + 1;
                }
            }
            System.out.println(chess[x2][y2]-1);
        }
    }

}
