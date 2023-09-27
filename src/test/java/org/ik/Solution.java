package org.ik;

import java.util.Arrays;

public class Solution {


    enum LogType {
        TEXT, DIGITS
    }

    static class Log {
        String id;
        String text;
        LogType type;
        String raw;

        public Log(String id, String text, LogType type, String raw) {
            this.id = id;
            this.text = text;
            this.type = type;
            this.raw = raw;
        }
    }

    public String[] reorderLogFiles(String[] logs) {

        return Arrays.stream(logs).map(l-> {
            String[] split = l.split("\\s", 2);

            boolean digit = Character.isDigit(split[1].toCharArray()[0]);
            return new Log(split[0], split[1], digit ? LogType.DIGITS: LogType.TEXT, l);
        }).sorted((o1, o2) -> {
            if(o1.type == o2.type){
                if(o1.type == LogType.TEXT){
                    int c = o1.text.compareTo(o2.text);
                    return c == 0 ? o1.id.compareTo(o2.id) : c;
                }
                return 0;
            } else {
                if(o1.type == LogType.TEXT){
                    return -1;
                }
                return 1;
            }
        }).map(l->l.raw).toArray(String[]::new);

    }
}

