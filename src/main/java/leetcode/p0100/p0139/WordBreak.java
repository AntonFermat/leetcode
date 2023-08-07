package leetcode.p0100.p0139;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0, new boolean[s.length()]);
    }

    private boolean helper(String s, List<String> wordDict, int index, boolean[] memo) {
        int len = s.length();
        if (index == len) return true;
        if (memo[index]) return false;
        for (var word : wordDict) {
            if (s.startsWith(word, index) && helper(s, wordDict, index + word.length(), memo)) {
                return true;
            }
        }
        memo[index] = true;
        return false;
    }

}
