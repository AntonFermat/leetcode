package leetcode.p0600.p0661

class SolutionKt {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> =
        Array(img.size) { r ->
            IntArray(img[0].size) { c ->
                Array(9) { i -> img.getOrNull(r + i / 3 - 1)?.getOrNull(c + i % 3 - 1) }
                    .filterNotNull()
                    .average().toInt()
            }
        }
}

