# Problem
[2357. Make Array Zero by Subtracting Equal Amounts](https://leetcode.com/contest/weekly-contest-304/problems/make-array-zero-by-subtracting-equal-amounts/)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- 중복을 제거하고 소팅해서 차례로 element를 뺀다.

# Approach
<!-- Describe your approach to solving the problem. -->
1. 인풋의 중복을 제거하고 소팅한다.
2. 제일 큰 수가 0이라면 0을 리턴한다.
3. 숫자가 하나만 있으면 연산이 1번만 이루어지므로 1을 리턴한다.
4. 인풋을 순회하면서 현재 값이 0보다 크다면 나머지 element로부터 뺄셈한다.
5. 뺀 결과가 음수가 아니면서 모두 계산할 때까지 반복한다.

# Complexity
## Time complexity
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
- nums의 길이를 n이라고 했을 때 sorted()는 O(nlogn)
- newNums[len(newNums)-1]는 O(1)
- newNums의 길이를 n이라고 했을 때 이중 for문이 들어가므로 O(n^2)

## Space complexity
- 길이를 n이라고 했을 때 newNums, resultNums는 O(n)
- maxNum, count는 O(1)

# Code
```
from functools import reduce

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        newNums = sorted(set(nums))
        maxNum = newNums[len(newNums)-1]
        
        if maxNum == 0:
            return 0
        if len(newNums) == 1:
            return 1
        
        count = 0
        
        for curr in newNums:
            if curr > 0:
                count += 1
                resultNums = []
                
                for n in newNums:
                    if n - curr > 0:
                        resultNums.append(n - curr)
        
        return count
```

# Problem
[2358. Maximum Number of Groups Entering a Competition](https://leetcode.com/contest/weekly-contest-304/problems/maximum-number-of-groups-entering-a-competition/)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
## Time complexity
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

## Space complexity

# Code
```

```