package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if('a' <= c && c <= 'z') {
                char m = (char)(c+13);
                if(m>122) {
                    m -= 122;
                    m += 96;
                    sb.append(m);
                }
                else sb.append(m);
            }else if('A' <= c && c <= 'Z') {
                char m = (char)(c+13);
                if(m>90) {
                    m -= 90;
                    m += 64;
                    sb.append(m);
                }
                else sb.append(m);
            } else{
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}