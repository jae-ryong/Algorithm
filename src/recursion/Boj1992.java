package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1992 {
    static int N;
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N][N];
        for(int i = 0; i < N; i++){
            String a = br.readLine();
            for(int j = 0; j < N; j++){
                tree[i][j] = a.charAt(j)-'0';
            }
        }
        quardtree(N,0,0);
        System.out.println(sb);
    }

    public static void quardtree(int size, int r, int c){
        if(size ==1){
            sb.append(tree[r][c]);
            return;
        }
        if(!check(size, r,c)){
            sb.append('(');
            quardtree(size/2,r,c); //왼쪽위
            quardtree(size/2,r,c+size/2); // 오른쪽 위
            quardtree(size/2,r+size/2, c); // 왼쪽 아래
            quardtree(size/2, r+size/2,c+size/2); // 오른쪽 아래
            sb.append(')');
        }else{
            sb.append(tree[r][c]);
            return;
        }
    }

    public static boolean check(int size, int r, int c){
        int a = tree[r][c];
        for(int i=r;i<size+r;i++){
            for(int j=c;j<size+c;j++){
                if(a!=tree[i][j]) return false;
            }
        }
        return true;
    }
}
