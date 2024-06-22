package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780 {
    static int N;
    static int[][] paper;
    static int a = 0; // -1
    static int b = 0; // 0
    static int c = 0; // 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        papers(N,0,0);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void papers(int size, int x, int y){
        if(size==1){
            int gab = paper[x][y];
            if(gab==-1) a++;
            else if(gab==0) b++;
            else if(gab==1) c++;
            return;
        }
        if(!check(size,x,y)){
            papers(size/3,x,y);
            papers(size/3,x+size/3,y);
            papers(size/3,x+size/3 *2,y);

            papers(size/3,x,y+size/3);
            papers(size/3,x+size/3,y+size/3);
            papers(size/3,x+size/3*2,y+size/3);

            papers(size/3,x,y+size/3*2);
            papers(size/3,x+size/3,y+size/3*2);
            papers(size/3,x+size/3*2,y+size/3*2);
        }


    }

    private static boolean check(int size, int x, int y) {
        int aa=0;
        int ab=0;
        int ac=0;
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                int gab = paper[i][j];
                if(gab==-1) aa++;
                else if(gab==0) ab++;
                else if(gab==1) ac++;
            }
        }

        if(aa==size*size){
            a++;
            return true;
        }else if(ab==size*size){
            b++;
            return true;
        }else if(ac==size*size){
            c++;
            return true;
        }
        return false;
    }
}
