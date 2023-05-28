package google;/*
Design a logger system that receives a stream of messages along with their timestamps.
 Each unique message should only be printed at most every 10 seconds
 (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).

 Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

Explanation
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
 */

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    static class Logger {
        int interval = 10;
        Map<String, Integer> map = new HashMap<>();

        public Logger() {
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer currTime = map.get(message);
            if (currTime != null) {
                if (currTime + interval <= timestamp) {
                    map.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Logger obj = new Logger();
        System.out.println(obj.shouldPrintMessage(1, "foo"));
        System.out.println(obj.shouldPrintMessage(2, "bar"));
        System.out.println(obj.shouldPrintMessage(3, "foo"));
        System.out.println(obj.shouldPrintMessage(8, "bar"));
        System.out.println(obj.shouldPrintMessage(10, "foo"));
        System.out.println(obj.shouldPrintMessage(11, "foo"));
    }
}