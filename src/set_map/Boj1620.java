package set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map1.put(name,String.valueOf(i+1));
            map2.put(String.valueOf(i+1),name);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            String s = br.readLine();
            if(map1.containsKey(s)){
                sb.append(map1.get(s)).append('\n');
            }else{
                sb.append(map2.get(s)).append('\n');
            }
        }
        System.out.println(sb);
    }
}