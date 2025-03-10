package set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String method = st.nextToken();
            if(method.equals("enter")) {
                map.put(name, method);
            }else{
                map.remove(name);
            }
        }
        List<String> list = new ArrayList<>();
        map.forEach((k, v) -> {
            list.add(k);
        });
        Collections.sort(list,(a,b)-> b.compareTo(a));

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}