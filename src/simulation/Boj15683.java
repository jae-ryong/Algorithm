package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15683 {
    static int N;
    static int M;
    static class Point{
        int x, y, cctvNum;
        Point(int x, int y, int cctvNum){
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }
    }
    static int zeroCnt = Integer.MAX_VALUE;
    static ArrayList<Point> list = new ArrayList<Point>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0 && map[i][j]<6) list.add(new Point(i,j,map[i][j]));
            }
        }
        dfs(0,map);
        System.out.println(zeroCnt);
    }

    private static void dfs(int L, int[][] map) {
        if(L==list.size()){
            int cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0) cnt++;
                }
            }
            zeroCnt = Math.min(cnt,zeroCnt);
            return;
        }
        Point a = list.get(L);
        int x = a.x;
        int y = a.y;
        int cctvNum = a.cctvNum;
        if(cctvNum==1){
            int[][] copymap = copy(map);
            left(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            top(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            right(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            bottom(copymap,x,y);
            dfs(L+1,copymap);
        }else if(cctvNum==2){
            int[][] copymap = copy(map);
            left(copymap,x,y);
            right(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            top(copymap,x,y);
            bottom(copymap,x,y);
            dfs(L+1,copymap);
        }else if(cctvNum==3){
            int[][] copymap = copy(map);
            left(copymap,x,y);
            top(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            top(copymap,x,y);
            right(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            right(copymap,x,y);
            bottom(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            left(copymap,x,y);
            bottom(copymap,x,y);
            dfs(L+1,copymap);
        }else if(cctvNum==4){
            int[][] copymap = copy(map);
            right(copymap,x,y);
            left(copymap,x,y);
            top(copymap,x,y);
            dfs(L+1,copymap);


            copymap = copy(map);
            right(copymap,x,y);
            bottom(copymap,x,y);
            top(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            left(copymap,x,y);
            right(copymap,x,y);
            bottom(copymap,x,y);
            dfs(L+1,copymap);

            copymap = copy(map);
            top(copymap,x,y);
            bottom(copymap,x,y);
            left(copymap,x,y);
            dfs(L+1,copymap);
        }else if(cctvNum==5){
            int[][] copymap = copy(map);
            top(copymap,x,y);
            bottom(copymap,x,y);
            left(copymap,x,y);
            right(copymap,x,y);
            dfs(L+1,copymap);
        }
    }

    private static void bottom(int[][] copymap, int x, int y) {
        for(int i=x;i<N;i++){
            if (copymap[i][y] == 6) break;
            if (copymap[i][y] == 0) copymap[i][y] = -1;
        }
    }

    private static void right(int[][] copymap, int x, int y) {
        for (int i = y; i < M; i++) {
            if (copymap[x][i] == 6) break;
            if (copymap[x][i] == 0) copymap[x][i] = -1;
        }
    }

    private static void top(int[][] copymap, int x, int y) {
        for (int i = x; i >= 0; i--) {
            if (copymap[i][y] == 6) break;
            if (copymap[i][y] == 0) copymap[i][y] = -1;
        }
    }

    private static void left(int[][] copymap,int x,int y) {
        for (int i = y; i >= 0; i--) {
            if (copymap[x][i] == 6) break;
            if (copymap[x][i] == 0) copymap[x][i] = -1;
        }
    }

    private static int[][] copy(int[][] map) {
        int[][] tmp = new int[N][M];
        for(int i=0;i<N;i++){
            tmp[i] = map[i].clone();
        }
        return tmp;
    }


}
