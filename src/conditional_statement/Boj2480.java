package conditional_statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int[] arr = new int[3];
        int[] ch = new int[7];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            ch[arr[i]] += 1;
        }

        int max2 = 0;
        int idx = 0;
        for(int i=1;i<7;i++){
            max2 = Math.max(max2, ch[i]);
            if(ch[i]==2) idx = i;
        }
        if(max2 == 3){
            System.out.println(10000 + max * 1000);
        }else if(max2 == 2){
            System.out.println(1000 + idx * 100);
        }else{
            System.out.println(max * 100);
        }

    }
}
