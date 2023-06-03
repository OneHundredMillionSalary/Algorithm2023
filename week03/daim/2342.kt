import java.util.*

class Solution2342 {
    // Max Sum of a Pair With Equal Sum of Digits
    fun maximumSum(nums: IntArray): Int {
        /*
        합의 값을 key로 하는 dict를 만들고, value는 우선순위큐로 생성한다.
        각 우선순위큐에는 합이 key가 되는 값들이 들어가 있다.
        nums를 모두 순회하고 dict을 순회하면서 queue의 크기가 2 이상인 경우만
        가장 큰 값 2개를 더해서 지금까지 계산한 maxValue와 비교해서 가장 큰 값을 반환한다.
        * */
        var sumKeyDict = mutableMapOf<Int, PriorityQueue<Int>>()
        nums.forEach { v ->
            val value = numSplitToList(v).sum()
            var queue = sumKeyDict.getOrDefault(value, PriorityQueue<Int>(reverseOrder()))
            queue.add(v)
            if (queue.size == 1) sumKeyDict.set(value, queue)
        }
        var maxValue = -1
        sumKeyDict.forEach { sumKey, queue ->
            if (2 <= queue.size){
                maxOf(maxValue, (queue.poll() + queue.poll())).also { maxValue = it }
            }
        }
        return maxValue
    }
    fun numSplitToList(num: Int): MutableList<Int> {
        val digits = mutableListOf<Int>()
        var n = num
        while (n > 0) {
            val digit = n % 10
            digits.add(0, digit)  // 자릿수 값을 리스트의 맨 앞에 추가
            n /= 10
        }
        return digits
    }

}

fun main() {
    val solution = Solution2342()
    assert(solution.maximumSum(intArrayOf(18, 43, 36, 13, 7)) == 54)
    assert(solution.maximumSum(intArrayOf(10,12,19,14)) == -1)
}
