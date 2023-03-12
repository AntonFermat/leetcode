fun strStr(haystack: String, needle: String): Int {
    return slidingWindow(haystack, needle)
}

fun slidingWindow(s1: String, s2: String): Int {
    val len1 = s1.length
    val len2 = s2.length
    if (len1 < len2) return -1
    for (i in 0..len1 - len2) {
        var j = 0
        while (j < len2) {
            if (s1[i + j] != s2[j]) break
            j++
        }
        if (j == len2) return i
    }
    return -1
}