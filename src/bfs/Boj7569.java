package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
    static class Point{
        int x, y,z;
        Point(int x, int y,int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int M;
    static int N;
    static int H;
    static int[] dx = {0,0,0,0,-1,1};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {1,-1,0,0,0,0};
    static Queue<Point> queue;
    static int[][][] tomato;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[N][M][H];
        visited = new boolean[N][M][H];
        queue = new LinkedList<>();

        int cnt = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    tomato[j][k][i] = Integer.parseInt(st.nextToken());
                    if(tomato[j][k][i]==1) {
                        queue.add(new Point(j,k,i));
                        visited[j][k][i] = true;
                        cnt++;
                    }else if(tomato[j][k][i]==-1) cnt++;
                }
            }
        }

        if(cnt==N*M*H){
            System.out.println(0);
        }else{
            bfs();
            int max = 0;
            boolean check = false;
            for(int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if(tomato[j][k][i]==0) check = true;
                        max = Math.max(max, tomato[j][k][i]);
                    }
                }
            }
            if(check) {
                System.out.println(-1);
            }else{
                System.out.println(max-1);
            }
        }
    }

    private static void bfs() {
        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i=0;i<6;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                int nz = a.z + dz[i];
                if(nx<0 || ny<0||nz<0 || nx>=N||ny>=M||nz>=H) continue;
                if(tomato[nx][ny][nz]==-1 || visited[nx][ny][nz]) continue;
                queue.add(new Point(nx,ny,nz));
                tomato[nx][ny][nz] = tomato[a.x][a.y][a.z]+1;
                visited[nx][ny][nz] = true;
            }
        }
    }
}
