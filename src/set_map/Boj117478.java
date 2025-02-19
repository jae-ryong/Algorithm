package set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj117478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = 1;
        Set<String> set = new HashSet<String>();
        while(len < s.length()) {
            for(int i=0;i+len<=s.length();i++) {
                String s1 = s.substring(i,i+len);
                set.add(s1);
            }
            len += 1;
        }
        set.add(s);
        System.out.println(set.size());
    }
}