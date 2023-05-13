
// https://leetcode.com/problems/spiral-matrix-iv/description/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution2326 {

    private fun resetDirection(rNc: MutableList<Int>, curIndex: Int): Int {
        var curIndex = curIndex
        if (curIndex == 0) {
            rNc[0] = rNc[0] * -1
            curIndex = 1
        } else {
            rNc[1] = rNc[1] * -1
            curIndex = 0
        }
        return curIndex
    }

    private fun checkRange(curR: Int, curC: Int, lastR: Int, lastC: Int): Boolean {
        return 0 <= curR && curR < lastR && 0 <= curC && curC < lastC
    }

    private fun back(rNc: MutableList<Int>, curIndex: Int, curR: Int, curC: Int): List<Int> {
        var prevC = curC
        var prevR = curR
        if (curIndex == 0) {
            prevC = curC - rNc[0]
        } else {
            prevR = curR - rNc[1]
        }
        return listOf(prevR, prevC)
    }

    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        var curIndex = 0  // 가로 방향부터 시작
        var rNc = mutableListOf(1, 1) // row(가로방향), colum(세로방향)을 의미하고 1이면 증가, -1이면 감소를 의미한다.
        val arr = Array(m) { IntArray(n) { -1 } }  // 아무도 지나지 않은 모든 길 -1로 표시
        var curR = 0
        var curC = 0
        arr[curR][curC] = head!!.`val` // 초기값 세팅
        var node = head
        while (true) {
            if (node?.next == null) break
            if (curIndex == 0) curC += rNc[0] else curR += rNc[1]
            if (checkRange(curR, curC, m, n)) {
                // 지나가지 않은 길
                if (arr[curR][curC] == -1) {
                    node = node.next
                    arr[curR][curC] = node!!.`val`
                    continue
                }
            }
            // 지나간 길 혹은 범위 초과
            var result: List<Int> = back(rNc, curIndex, curR, curC)
            curR = result[0]
            curC = result[1]
            curIndex = resetDirection(rNc, curIndex)

        }
        return arr
    }
}

fun main(){
    // 3,0,2,6,8,1,7,9,4,2,5,5,0
    var solution = Solution2326()
    var arr = intArrayOf(3,0,2,6,8,1,7,9,4,2,5,5,0)
    var head = ListNode(arr[0])
    var curr = head
    for (i in 1 until arr.size) {
        curr.next = ListNode(arr[i])
        curr = curr.next!!
    }
    solution.spiralMatrix(3, 5, head)


    arr = intArrayOf(0,1,2)
    head = ListNode(arr[0])
    curr = head
    for (i in 1 until arr.size) {
        curr.next = ListNode(arr[i])
        curr = curr.next!!
    }
    solution.spiralMatrix(1, 4, head)
    
    arr = intArrayOf(515,942,528,483,20,159,868,999,474,320,734,956,12,124,224,252,909,732)
    head = ListNode(arr[0])
    curr = head
    for (i in 1 until arr.size) {
        curr.next = ListNode(arr[i])
        curr = curr.next!!
    }
    solution.spiralMatrix(4, 5, head)
}
