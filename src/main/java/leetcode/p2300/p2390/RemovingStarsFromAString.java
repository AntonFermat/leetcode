package leetcode.p2300.p2390;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        var sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
            } else sb.append(c);
        }
        return sb.toString();
    }
}
