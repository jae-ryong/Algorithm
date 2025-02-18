package set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> a : map.entrySet()){
            if(a.getValue() >= 2) cnt+=a.getValue();
        }
        System.out.println(A+B-cnt);
    }
}