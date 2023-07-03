package leetcode.p0800.p0859;

import java.util.HashSet;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        var sarr = s.toCharArray();
        int prev = -1;
        var set = new HashSet<Character>();
        boolean count2 = false;
        for (int i = 0; i < s.length(); i++) {
            if (sarr[i] != goal.charAt(i)) {
                if (prev == -1) prev = i;
                else {
                    char tmp = sarr[prev];
                    sarr[prev] = sarr[i];
                    sarr[i] = tmp;
                    return goal.equals(new String(sarr));
                }

            }
            if (!count2 && !set.add(s.charAt(i))) count2 = true;
        }

        return prev == -1 && count2;
    }
}
