class Solution2351 {

    fun repeatedCharacter(s: String): Char {
        var charDict = mutableMapOf<Char, Int>()
        s.forEach {
            if (charDict.containsKey(it)){
                return it
            } else {
                charDict.put(it, 1)
            }
        }
        return 't'
    }
}

fun main() {
    var solution = Solution2351()
    print(solution.repeatedCharacter("abccbaacz"))
    print(solution.repeatedCharacter("abcdd"))
}
