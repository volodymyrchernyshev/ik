package org.vladc;

import org.junit.jupiter.api.Test;

public class SqlEscapeUtil {



    public static String escapeSql(String str){
        return str.replaceAll("[\\&\\*\\@\\[\\]\\{\\}\\^\\:\\=\\!\\/\\<\\>\\-\\(\\)\\%\\+\\?\\;\\~\\|]", "\\\\$0");
    }

    @Test
    public void test(){
        System.out.println(escapeSql("&*@[]{}^:=!/<>-()%+?;~|"));
    }
}
