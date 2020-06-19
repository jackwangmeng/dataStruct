package com.wm.audition;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNoRepetitionString {
    public static Character findFirstNoRepetitionString(String dest){
        Map<Character, Integer> strMap = new LinkedHashMap<Character, Integer>();
        for (Character c : dest.toCharArray()) {
            Integer count = strMap.get(c);
            if(count == null){
                strMap.put(c, 1);
            }else{
                strMap.put(c, ++count);
            }
        }
        for (Map.Entry<Character, Integer> entry : strMap.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        throw new RuntimeException("程序计算出错");
    }

    public static void main(String[] args) {
        int x = 1,y = 2,z = 3;
        System.out.println(y+z--/++x);
        System.out.println(findFirstNoRepetitionString("dda"));
    }
}