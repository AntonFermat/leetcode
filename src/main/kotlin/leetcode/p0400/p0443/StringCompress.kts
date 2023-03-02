fun compress(chars: CharArray): Int {
    var res = 0
    var count = 1
    var prev = chars[0]
    for (i in 1 until chars.size) {
        val cur = chars[i]
        if (prev != cur) {
            res = compress(chars, prev, count, res)
            count = 0
            prev = cur
        }
        count++
    }
    return compress(chars, prev, count, res)
}

fun compress(chars: CharArray, prev: Char, count: Int, res: Int): Int {
    var res = res
    chars[res++] = prev
    if (count > 1) {
        for (d in count.toString().toCharArray()) {
            chars[res++] = d
        }
    }
    return res
}