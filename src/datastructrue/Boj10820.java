package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line==null) break;
            int soCnt = 0;
            int daeCnt = 0;
            int numCnt = 0;
            int spaceCnt = 0;
            for(int i = 0; i < line.length(); i++){
                char c = line.charAt(i);
                if(c>='a' && c<='z'){
                    soCnt++;
                }else if(c>='A' && c<='Z'){
                    daeCnt++;
                }else if(c>='0' && c<='9'){
                    numCnt++;
                }else{
                    spaceCnt++;
                }
            }
            System.out.println(soCnt + " " + daeCnt + " " + numCnt + " " + spaceCnt);
        }
    }
}