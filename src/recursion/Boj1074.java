package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {
    static int N;
    static int r;
    static int c;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,N);
        hansu(size,r,c);
        System.out.println(count);
    }

    public static void hansu(int size, int r, int c) {
        if(size==1) return;

        if(r<size/2 && c<size/2){
            hansu(size/2,r,c);
        }else if(r<size/2 && c>=size/2){
            count += (size*size)/4;
            hansu(size/2,r,c-size/2);
        }else if(r>=size/2 && c<size/2){
            count += (size*size)/4 * 2;
            hansu(size/2,r-size/2,c);
        }else if(r>=size/2 && c>=size/2){
            count += (size*size)/4 * 3;
            hansu(size/2,r-size/2,c-size/2);
        }
    }
}
