package test;

import java.util.ArrayList;
import java.util.List;

public class Mask {
    public void str(String s){
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='@'){
                index = i;
                break;
            }
        }
        String str = "";
        List<Character> list = new ArrayList<>();
        String mark = "MASK";
        for (int i = 0; i < s.length(); i++) {
            if (i<index){
                list.add(s.charAt(i));
                list.add(mark.charAt(i%4));
            }else{
                list.add(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        System.out.println(stringBuilder);
    }
}
