package org.mathtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class DeleteConsecutiveRepeatElements {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Input:");
        String str = scanner.nextLine();
       /* String str =
                "aabcccbbad";*/
        String exp = "ab.*d.*e.*";
      //  System.out.println(isMatch(str, exp));
    //    System.out.println(isMatchDP(str, exp));
/*        Pattern compile = Pattern.compile("[a-z]{3,}");
        compile.matcher(str).ma
        String replace = str.replace("[a-z]{3,}", "");
        System.out.println(replace);*/

    //    String s = replaceRepeatStr(str);
      //  System.out.println(s);
        deleteConsecutiveRepeatElements(str);

    }

    public static void deleteConsecutiveRepeatElements(String str) {
        while(true) {
            Map<Integer, Integer> map = getRepeatAlphaPosition(str);
            if(map==null||map.size()==0){
                break;
            }
            str = delRepeatAlpha(str, map);
            System.out.println("->"+ str);
        }
    }

    private static String replaceRepeatStr(String str) {
        Map<Integer, Integer> map = getRepeatAlphaPosition(str);
        str = delRepeatAlpha(str, map);
        return str;
    }

    private static String delRepeatAlpha(String str, Map<Integer, Integer> map) {
        Set<Integer> eles = map.keySet();
        for (Integer ele : eles) {
            Integer cnt = map.get(ele);
            System.out.println(ele+"============"+cnt);
           str = str.replace(str.substring(ele, ele + cnt ), "");

        }
        return str;
    }


    private static Map<Integer, Integer> getRepeatAlphaPosition(String str) {
        Map<Integer,Integer> map=new HashMap<>();
        int len = str.length();
        int count=1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < len; i+=count) {
             count=1;
            for (int j = i+1; j < len; j++) {
                if(chars[i]==chars[j]){
                    count++;
                }else{
                    if(count>2){
                        map.put(i,count);
                    }
                    break;
                }
            }
        }
        return map;
    }


}
