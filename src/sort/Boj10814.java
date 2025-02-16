package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10814 {
    static class Member{
        int age;
        String name;
        Member(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> mb = new ArrayList<Member>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            mb.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(mb, new Comparator<Member>(){
            public int compare(Member m1, Member m2){
                return m1.age - m2.age;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mb.size(); i++){
            sb.append(mb.get(i).age + " " + mb.get(i).name + "\n");
        }
        System.out.println(sb);
    }
}