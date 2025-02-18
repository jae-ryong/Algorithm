package set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int cnt = 0;

        for(int i=0;i<N;i++) {
            map.put(br.readLine(),1);
        }

        for(int i=0;i<M;i++) {
            String name = br.readLine();
            map.put(name,map.getOrDefault(name, 0)+1);
            if(map.get(name)==2) {
                cnt++;
                list.add(name);
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for(String i : list) {
            System.out.println(i);
        }
    }
}