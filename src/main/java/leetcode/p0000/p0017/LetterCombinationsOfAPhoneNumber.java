package leetcode.p0000.p0017;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return List.of();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        var res = new ArrayList<String>();
        backtrack(digits, res, new StringBuilder(), 0);
        return res;
    }

    private final Map<Character, List<Character>> map = new HashMap<>();

    private void backtrack(String digits, List<String> res, StringBuilder sb, int index) {
        if (digits.length() == sb.length()) res.add(sb.toString());
        else {
            char d = digits.charAt(index);
            List<Character> list = map.get(d);
            for (char c : list) {
                sb.append(c);
                backtrack(digits, res, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
