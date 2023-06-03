class Solution2341 {
    /*
    굳이 nums의 각 요소들의 count를 셀 필요가 없다.
    짝이 맞으면 키를 삭제하고, 짝이 아니면 1을 집어넣는다.
    최종적으로 nums를 모두 순회하였을 때 vDict에 남는 keys의 수가 짝이 되지 못한 num의 수이다.
    */
    fun numberOfPairs(nums: IntArray): IntArray {
        var vDict = mutableMapOf<Int, Int>()
        var pairCount = 0
        nums.forEach { v ->
            var count = vDict.getOrDefault(v, 0)
            if (count == 0) {
                vDict.set(v, 1)
            } else {
                vDict.remove(v)
                pairCount += 1
            }
        }
        return intArrayOf(pairCount, vDict.keys.size)
    }
}

fun main() {
    val solution = Solution2341()
    assert(solution.numberOfPairs(intArrayOf(1, 3, 2, 1, 3, 2, 2)).contentEquals(intArrayOf(3, 1)))
    assert(solution.numberOfPairs(intArrayOf(1,1)).contentEquals(intArrayOf(1,0)))
    assert(solution.numberOfPairs(intArrayOf(0)).contentEquals(intArrayOf(0,1)))
}
