class Solution2325 {

    fun makeKey(key: String): MutableMap<Char, Char> {
        var alphabet = "abcdefghijklmnopqrstuvwxyz"
        var keyMap : MutableMap<Char, Char> = mutableMapOf()
        var alphaIndex = 0
        for (k in key) {
            if (k.isLetter() && !keyMap.containsKey(k)){
                keyMap[k] = alphabet[alphaIndex]
                alphaIndex += 1
            }
        }
        return keyMap
    }

    fun decodeMessage(key: String, message: String): String {
        var keyMap = makeKey(key)
        var result = ""
        for (m in message){
            result += keyMap.getOrDefault(m, ' ')
        }
        return result
    }
}


fun main(){
    val solution = Solution2325()
    assert(solution.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv") == "this is a secret")
    assert(solution.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb") == "the five boxing wizards jump quickly")
//    assert( == 1)
}
