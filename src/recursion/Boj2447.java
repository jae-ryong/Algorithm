package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2447 {
    static int N;
    static char[][] star;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        star = new char[N][N];
        stars(N,0,0,false);
        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void stars(int size, int x, int y, boolean check){
        if(check){
            for(int i=x;i<x+size;i++){
                for(int j=y;j<y+size;j++){
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(size == 1){
            star[x][y] = '*';
            return;
        }


        int count = 0;
        int plus = size/3;
        for(int i=x;i<x+size;i+=plus){
            for(int j=y;j<y+size;j+=plus){
                count++;
                if(count==5){
                    stars(plus,i,j,true);
                }else {
                    stars(plus, i, j, false);
                }
            }
        }
    }

}
