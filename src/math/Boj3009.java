package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[1001];
        int[] b = new int[1001];
        for(int i=0; i<3 ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x]++;
            b[y]++;
        }
        int x = 0;
        int y = 0;
        for(int i=0; i<a.length;i++){
            if(a[i] == 1) x=i;
            if(b[i] == 1) y=i;
        }
        System.out.print(x + " " + y);
    }
}