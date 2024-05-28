package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String room = br.readLine();
        int[] set = new int[10];
        for(int i = 0; i < room.length(); i++){
            if(room.charAt(i)-'0'==6){
                set[9] += 1;
            }else{
                set[room.charAt(i)-'0'] += 1;
            }
        }
        int max = 0;
        int idx = 0;
        for(int i = 0; i < 9; i++){
            if(set[i]>max){
                max = set[i];
                idx = i;
            }
        }
        int answer = 0;
        if(set[9]%2 == 0) answer = set[9]/2;
        else answer = set[9]/2 + 1;
        if(max >= answer){
            System.out.println(set[idx]);
        }else{
            System.out.println(answer);
        }
    }
}