package com.solarexsoft.test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by houruhou on 2019/9/2.
 * Desc:
 */
public class PatternMain {
    public static void main(String[] args) {
        String str1 = "我是Qdljczwk_1865，我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我为好友哦。hb.icarbonx.com/plan/download?info=cuHBI4mf%2BBqAY44DZaFCYBoTekYpDQliKQoaSc6sPC8%3D";
        String pattern = ".*我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我会好友哦。.*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str1);
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
//        String str2 = "我是李四，我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我会好友哦。hb.icarbonx.com/plan/download?info=XCF1mJTWBN%2BrtrwLpqGndg%3D%3D%0A";
        String str2 = "我是Qdljczwk_1865，我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我会好友哦。hb.icarbonx.com/plan/download?info=XCF1mJTWBN%2BrtrwLpqGndg%3D%3D%0A";
        matcher = regex.matcher(str2);
        matches = matcher.matches();
        System.out.println("me matches = " + matches);
        String tmp = "我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我会好友哦。";
        boolean aContains = str1.contains(tmp);
        boolean bContains = str2.contains(tmp);
        System.out.println("a = " + aContains);
        System.out.println("b = " + bContains);
        char[] chars = str1.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println("\n-------------------\n");
        char[] chars1 = str2.toCharArray();
        for (char c : chars1) {
            System.out.print(c);
        }
        System.out.println("\n------------------------\n");
        String tmp1 = "我是Qdljczwk_1865，我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我为好友哦。";
        String tmp2 = "我是Qdljczwk_1865，我在health buddy，邀你和我一起发现更多与你相似的人，一起改变自己生活点滴，成就更好的自己！快来下载吧！长按并复制这段话，打开app可以直接添加我会好友哦。";
        System.out.println("euqals = " + tmp1.equals(tmp2));
        int len1 = tmp1.length();
        int len2 = tmp2.length();
        System.out.println("len1 = " + len1 + ",len2 = " + len2);
        char[] tmp1Chars = tmp1.toCharArray();
        char[] tmp2Chars = tmp2.toCharArray();
        for (int i = 0; i < tmp1Chars.length; i++) {
            char tmp1Char = tmp1Chars[i];
            char tmp2Char = tmp2Chars[i];
            if (tmp1Char == tmp2Char) {
                System.out.println("== " + tmp1Char);
            } else {
                System.out.println(tmp1Char + " != " + tmp2Char);
            }
        }
    }
}
