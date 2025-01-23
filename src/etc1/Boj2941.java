package etc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");

        String word = br.readLine();
        int cnt = 0;
        for (int i = 0; i < word.length(); ) {
            if(i+3<=word.length() && list.contains(word.substring(i,i+3))){
                i+=3;
                cnt++;
            }else if(i+2 <=word.length() && list.contains(word.substring(i,i+2))){
                i+=2;
                cnt++;
            }else{
                i++;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}