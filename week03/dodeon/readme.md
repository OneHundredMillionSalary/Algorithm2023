# Problem
[2341. Maximum Number of Pairs in Array](https://leetcode.com/problems/maximum-number-of-pairs-in-array/)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- dict 형태를 만들어서 각 숫자마다 빈도에 대한 count를 계산한다.

# Approach
<!-- Describe your approach to solving the problem. -->
1. element가 하나라면 무조건 [0,1]로 리턴한다.
2. Counter 기능으로 각 숫자가 몇 번씩 나왔는지 계산한다.
3. Counter 결과를 순회하면서 2번 이상 나왔다면 cnt1에 카운트 한다.
4. 단, 4, 6, 8...등 4번 이상 나왔다면 2번 이상 수행하는 것이므로 // 연산의 결과를 더한다.
5. 홀수라면 남는 element가 반드시 존재하므로 % 연산의 결과를 cnt2에 더한다.
6. cnt1과 cnt2의 결과를 리스트로 반환한다.

# Complexity
## Time complexity
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
- 첫 번째 조건문(if len(nums) == 1:)은 O(1)
- n이 nums의 길이라면 Counter(nums)를 사용하여 temp 변수를 생성하는 부분은 O(n)
- for 루프는 dict(temp).values()에 대해 수행되므로 O(n)
- if 조건문은 O(1)
- cnt1, cnt2 변수에 대한 증가 연산은 O(1)
- 따라서, 전체 코드의 시간 복잡도는 O(n)

## Space complexity: 
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
- temp 변수는 Counter(nums)를 통해 생성되고 Counter 객체는 nums 리스트의 요소를 카운트하는 데 사용되므로 공간 복잡도는 O(n)
- cnt1, cnt2 변수는 단순 정수값을 저장하며 같은 크기의 메모리를 사용하므로 영향을 미치지 않는다.
- 따라서, 전체 코드의 공간 복잡도는 O(n)

# Code
```
from collections import Counter

class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        if len(nums) == 1:
            return [0, 1]

        temp = Counter(nums)

        cnt1 = 0
        cnt2 = 0
        for n in dict(temp).values():
            if n > 1:
                if n % 2 == 0:
                    cnt1 += n // 2
                else:
                    cnt1 += n // 2
                    cnt2 += 1
            else:
                cnt2 += 1

        return [cnt1, cnt2]
```

# Problem
[2342. Max Sum of a Pair With Equal Sum of Digits](https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- 자리수의 합계를 키로, 그에 해당하는 원본 값이 키를 밸류로 한 맵을 만든다.

# Approach
<!-- Describe your approach to solving the problem. -->
1. 입력값을 스트링으로 바꿔서 자리수를 나눈 뒤 합계를 구한다.
2. 중복되는 합계는 지우고 합계를 키 값으로 그에 해당하는 원본 키 값을 밸류로 넣는다.
3. 합계에 해당하는 키가 하나뿐이면 더할 수 없으므로 넘어간다.
4. 합계에 해당하는 키가 2개라면 합한다.
5. 합계에 해당하는 키가 3개 이상이라면 제일 큰 두 수만 뽑아 합한다.
6. 제일 큰 수를 반환한다.

# Complexity
## Time complexity
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
- nums의 길이를 n이라고 했을 때 n만큼 반복하므로 O(n)
- str(n), map(int, str(n)), sum(list(map(int, str(n))))은 각각 O(log(n))
- for key, value in dic.items()는 dic의 모든 키, 쌍을 최대 n번 반복한다.
- sorted(value, reverse=True)는 value의 길이에 비례하며 길이를 k라고 했을 때 O(klog(k))
- 따라서 전체 코드의 시간 복잡도는 O(n log(n) + n + nk log(k))

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
- dic은 최대 n개의 키를 가질 수 있으므로 O(n)
- 나머지 변수들은 상수의 공간복잡도를 가진다.
- 따라서 전체 공간복잡도는 O(n)

# Code
```
from collections import defaultdict

class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        dic = defaultdict(list)
        
        for n in nums:
            sumBydigits = sum(list(map(int, str(n))))
            dic[sumBydigits] += [n]        

        max = -1
        
        for key, value in dic.items():
            if len(value) == 1:
                continue
            elif len(value) > 2:
                value = sorted(value, reverse=True)[:2]
            
            result = sum(value)
            
            if result > max:
                max = result
        
        return max
```