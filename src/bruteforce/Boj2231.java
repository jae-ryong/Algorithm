package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        for(int i=0;i<N;i++){
            if(bunhaehab(i, N)){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    public static boolean bunhaehab(int n, int mocpho){
        boolean check = false;
        int result = n;
        int sum = 0;
        while(result != 0){
            sum += result%10;
            result /= 10;
        }
        sum += n;
        if(sum==mocpho) check = true;
        return check;
    }
}
