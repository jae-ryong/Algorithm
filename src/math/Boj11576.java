package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int sum = 1;
        for(int i=arr.length-1;i>=0;i--){
            result += sum * arr[i];
            sum *= A;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        while(result != 0){
            list.add(result %B);
            result /= B;
        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+ " ");
        }
    }
}