# 2325. Decode the Message

[problem](https://leetcode.com/contest/weekly-contest-300/problems/decode-the-message/)

## submission

```python
class Solution:
    def decodeMessage(self, key: str, message: str) -> str:
        table = {}
        value = 97
        
        for k in key:
            if k not in table and k != " ":
                table[k] = value
                value += 1
                
        result = ""
            
        for m in message:
            if m == " ":
                result += m
            else:
                result += chr(table[m])
                
        return result
```

- 무작정 dictionary에 넣고 하나씩 확인한다.
- Runtime: 60 ms
- Memory Usage: 16.3 MB

## sample submission

```python
class Solution:
    def decodeMessage(self, key: str, message: str) -> str:
        decode = {}

        key = key.split()
        key = "".join(key)
        start = 97
 
        for s in key:
            if s not in decode:
                decode[s] = chr(start)
                start += 1

        message = list(message)
        for i in range(len(message)):
            if message[i] != " ":
                message[i] = decode[message[i]]

        return "".join(message)
```