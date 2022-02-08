/*
    Find the first non-Repeated Character in a string
    Developed by: Adrian Paz Alonso
    Script Date: 08-Feb-2022
    ALGORITHM
    String "a green apple"
    // convert to char array
    pass chars to Map and count the number that repeats->  { ch = count}
     for (var ch: chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

*/
package ca.adrian;

import java.util.HashMap;
import java.util.Map;

public class CharFinder {
    public static char findFirstNonRepeatedChar(String str){
        Map<Character, Integer> map = new HashMap<>();
        if (str == null)
         throw new IllegalStateException("String cannot be null");

        var chars = str.toCharArray();

        for (var ch: chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        // a green apple
        // ^
        for (var ch: chars){
            if (map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
