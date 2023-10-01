package leetcode.p0500.p0557;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).map(w -> new StringBuilder(w).reverse().toString()).collect(Collectors.joining(" "));
    }
}
