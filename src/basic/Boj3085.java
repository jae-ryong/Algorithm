package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3085 {
    static int N;
    static char[][] satang;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        satang = new char[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                satang[i][j] = s.charAt(j);
            }
        }

        // 가로
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                if(satang[i][j]!=satang[i][j+1]){
                    swap(i,j,0);
                    check();
                    swap(i,j,0);
                }
            }
        }

        // 세로
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                if(satang[i][j]!=satang[i+1][j]){
                    swap(i,j,1);
                    check();
                    swap(i,j,1);
                }
            }
        }

        System.out.println(max);

    }
    private static void swap(int i, int j, int type){
        if(type==0){
            char temp = satang[i][j];
            satang[i][j] = satang[i][j+1];
            satang[i][j+1] = temp;
        }else{
            char temp = satang[i][j];
            satang[i][j] = satang[i+1][j];
            satang[i+1][j] = temp;
        }
    }

    private static void check() {
        for(int i=0;i<N;i++){
            int count = 1;
            for(int j=0;j<N-1;j++){
                if(satang[i][j] == satang[i][j+1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        for(int j=0;j<N;j++){
            int count = 1;
            for(int i=0;i<N-1;i++){
                if(satang[i][j] == satang[i+1][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
    }
}
