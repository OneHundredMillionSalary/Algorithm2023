import java.util.PriorityQueue

class Solution2335 {
    fun fillCups(amount: IntArray): Int {
        var count = 0
        // 최대값을 뽑아내는 큐
        val maxQueue = PriorityQueue<Int>(reverseOrder())
        amount.forEach {
            maxQueue.add(it)
        }

        while (maxQueue.peek() != 0){
            val max = maxQueue.poll()
            var secondMax = maxQueue.poll()
            maxQueue.add(max - 1)
            if (secondMax != 0) { secondMax -=1 }
            maxQueue.add(secondMax)
            count += 1
        }
        return count
    }
}

fun main(){
    // 3,0,2,6,8,1,7,9,4,2,5,5,0
    var solution = Solution2335()
    print("\n")
    print(solution.fillCups(intArrayOf(5,4,4))) // 7
    print(solution.fillCups(intArrayOf(5,0,0))) // 5
    print(solution.fillCups(intArrayOf(1,4,2))) // 4
    print("\n")
}
