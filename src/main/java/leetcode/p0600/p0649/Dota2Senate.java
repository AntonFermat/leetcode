package leetcode.p0600.p0649;

import java.util.*;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        var list = new LinkedList<Character>();
        for (var c : senate.toCharArray()) list.add(c);
        return helper(list, 0, 0);
    }

    private String helper(LinkedList<Character> list, int bannedR, int bannedD) {
        int len = list.size();
        int countR = 0;
        for (var c : list) if (c == 'R') countR++;
        if (countR == len) return "Radiant";
        if (countR == 0) return "Dire";

        var newList = new LinkedList<Character>();
        for (var c : list) {
            if (c == 'R') {
                if (bannedR > 0) bannedR--;
                else {
                    bannedD++;
                    newList.add(c);
                }
            } else {
                if (bannedD > 0) bannedD--;
                else {
                    bannedR++;
                    newList.add(c);
                }
            }
        }
        return helper(newList, bannedR, bannedD);
    }
}
