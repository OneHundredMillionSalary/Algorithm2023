import java.util.LinkedList
import java.util.Queue

// 다 못품 ㅠㅠ
class Solution2327 {
    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        // 퍼뜨리는 자의 정보 (남은 delay날, 남은 forget날)
        var spoilersQueue: Queue<MutableList<Int>> = LinkedList()
        spoilersQueue.add(mutableListOf(delay, forget))

        var tempQueue: Queue<MutableList<Int>> = LinkedList()
        var awarePeopleCount = spoilersQueue.size
        var day = 0
//        print("\nDay : ${day} - $awarePeopleCount\n")
        var dayChanged = false
        // 비밀을 모르는 사람이 남아있고, 비밀을 기억하는 사람이 남아있는 경우만 진행
        while (day <= n && spoilersQueue.isNotEmpty()){
            print("\n${day+1}일이 시작")
            var spoiler = spoilersQueue.poll()
            // 잊어버리고 말았습니다.
            if (spoiler[1] == 0) {
                awarePeopleCount -=1
                continue
            }
            // delay가 0인 것은 스포해도 된다는 의미
            if (spoiler[0] == 0) {
                awarePeopleCount += 1
                spoiler[1] -= 1 // 기억할 수 있는 남은 나들
                tempQueue.add(mutableListOf(delay, forget))
                if (0 <= spoiler[1]) {
                    tempQueue.add(spoiler)
                }
            } else {
                spoiler[0] -= 1 // 비밀을 퍼뜨리는 걸 참을 수 있는 날들
                spoiler[1] -= 1 // 기억할 수 있는 남은 나들
                if (0 <= spoiler[1]) {
                    tempQueue.add(spoiler)
                }
            }
            if (spoilersQueue.isEmpty() && tempQueue.isNotEmpty()){
                dayChanged = true
                spoilersQueue = tempQueue
                tempQueue = LinkedList()
            }
            if (dayChanged) {
                day += 1
                print("Day : ${day} - $awarePeopleCount\n")
                dayChanged = false
            }
        }
        return awarePeopleCount
    }
}

fun main(){
    // 3,0,2,6,8,1,7,9,4,2,5,5,0
    var solution = Solution2327()
    print("\n")
    print(solution.peopleAwareOfSecret(6,2,4)) // 5
    print("\n")
}
