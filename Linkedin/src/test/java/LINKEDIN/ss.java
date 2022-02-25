package LINKEDIN;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ss {
    public static void main(String[] args) {
        String s = "a2d2z4";
        System.out.println(xyz(s));
    }

    public static String xyz(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length - 1; i = i + 2) {

            map.put(s.charAt(i), Integer.parseInt(String.valueOf(s.charAt(i + 1))));
        }
        map.forEach((x, y) -> {
//            sb.append(x);
            IntStream.range(0, y).forEach(a -> sb.append(x));
        });
        System.out.println(map);
        System.out.println(sb.toString());
        return sb.toString();
    }
}
