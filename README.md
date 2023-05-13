# Algorithm2023
> 주 1회 진행하는 알고리즘 코드를 공유하기 위한 레파지토리이다.

<br/>

## 우리들의 소소한 규칙 🗒
- 각 주차별로 폴더를 생성한다
- week뒤에 띄어쓰기 없이 각 주차를 표시한다.(외자리수 주차는 0_으로 표기한다)
- 각 주차별 폴더에는 본인의 개인 폴더를 생성하여 readme에 솔루션을 정리한다.
- 문제는 각 주차별 폴더의 readme에 정리한다.
- 문제는 각자가 원하는 언어로 푼다.
- 격주 온/오프라인 모임을 진행한다(짝수차수 : 오프라인, 홀수차수 : 온라인)
- 공유하는 시간에는 각자 자기가 작성한 솔루션을 설명한다.
- **문제는 LeetCode의 Contest 300주차부터 시작한다.([link](https://leetcode.com/contest))**
- **스크럼 마스터**가 2주의 스터디를 주관한다.
  - 스크럼 마스터는 맡은 주에는 가능하면 무조건 참석하도록 한다.
  - 온라인 : 링크생성
  - 오프라인 : 장소예약
  - 그 외 : 스터디 주관, 참여독려, Contest 문제 ReadMe정리, LGTM 업데이트
 - 참여독려를 위한 LGTM(칭찬스티커)
   - 온라인 참석 : 1개
   - 오프라인 참석 : 3개
   - 문제 난이도 점수 : 이지 - 1개, 미디엄 - 2개, 하드 - 5개
- 스크럼 마스터 순서
  - 다임(5/13, 5/20)
  - 채은
  - 도현
  - 보미
  - 도던
  - 헌진

<br/>

## 연혁

<img src="https://badgen.net/badge/release/1.0.0/green" title="2023 스터디 시작"/>

```
🏃‍♀️ 2023-04-29  >   이력서 업데이트 (다임, 헌진, 도던, 채은)
😽 2023-05-06  >   온라인 킥오프 (다임, 헌진, 도현)
```
<br/>

<br/>


## 2023년 참여자 (5/6 update version)
- [다임](https://github.com/histuckyi)
- [헌진](https://github.com/KimHunJin)
- [채은](https://github.com/YChaeeun)
- [도던](https://github.com/sojeongw)
- [도현](https://github.com/DohyunYoun)

<br/>

---

<br/>

> ## 참고 
> Algorithm 2020 [repository](https://github.com/OneHundredMillionSalary/Algorithm) <br/>
> Algorithm 2021 [repository](https://github.com/OneHundredMillionSalary/Algorithm2021) <br/>
> Algorithm 2022 [repository](https://github.com/OneHundredMillionSalary/Algorithm2022) <br/>

<details> <summary>문제 생성 스크립트</summary>

```js
function main() {
  const start = 1761;
  const week = 4;
  let problem = "";
  
  problem +=`## Week ${dayOfString(week)}\n`
  for (let i=0; i<8; i++){
    problem += `### \uD83D\uDC40 [${start + i}](https://leetcode.com/problemset/all/?search=${start + i}&page=1)\n`;
    problem += "####\n[solution]()\n####\n";
  }
  
  console.log(problem);
}

function dayOfString(num) {
  if (num < 9) {
    return '0' + num;
  }

  return num;
}

main();
```
</details>
