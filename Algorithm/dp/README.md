# 동적 계획법(Dynamic Programming)

큰 문제를 작은 문제로 나눠서 푸는 알고리즘이다.
코딩테스트에서 자주 출제되는 알고리즘 기법이다.

### DP 속성

1. Overlapping Subproblem (부분 문제가 겹친다.)
2. Optimal Substructure (최적 부분 구조)

### Overlapping Subproblem

대표적인 예로 피보나치 수를 들 수 있다.
Fn = Fn-1 + Fn-2

여기서 Fn을 큰 문제로 생각하고, 우측 항에 있는 Fn-1, Fn-2를 작은 문제로 나눈다고 생각하면 된다.

### Optimal Substructure

문제의 정답을 작은 문제의 정답을 합하는 것으로 구할 수 있다.
위의 예에서 작은 문제로 쪼갠 우측항의 Fn-1 + Fn-2로 큰 문제인 Fn의 값을 구할 수 있다.

### 그렇다면 어떻게 해야하는 가?

DP는 Optimal Substructure를 만족하기 때문에 작은 문제로 큰 문제의 정답을 구할 수 있다.
이때, 작은 문제의 정답을 메모해둔다. (코드에서는 배열로써 구현함)

```java
int memo[100];
public int fibonacci(int n) {
    if (n == 0 || n == 1)
        return 1;
    else {
        if (memo[n] > 0)
            return memo[n];
        memo[n] = fibonacci(n-1) + fibonacci(n-2);
        return memo[n];
    }
}
```

### 그런데 DP를 풀 때 어떤 방식으로 접근해야하는 가?

1. Top-Down
2. Bottom-Up

### Top-Down

1. 큰 문제를 작은 문제로 나눈다.
F(n-1), F(n-2)로 나눈다.

2. 작은 문제를 푼다.
F(n-1) + F(n-2)

> 재귀호출을 하는 방식으로 푼다.

### Bottom-Up

1. 문제를 크기가 작은 문제부터 차례대로 쓴다.
2. 문제의 크기를 조금씩 크게 만들면서 문제를 푼다.
3. 작은 문제를 풀면서 큰 문제의 답을 구한다.

```java
int d[100];
public int fibonacci(int n) {
    d[0] = 0;
    d[1] = 1;
    for (int i = 2; i <= n; i++) {
        d[i] = d[i - 1] + d[i - 2];
    }
    return d[n];
}
```

- 1463번 [1로 만들기](https://www.acmicpc.net/problem/1463)

> [참고자료](https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787315353&proxyReferer=https%3A%2F%2Fwww.google.com%2F)

<br >

- 11726번 [2xn 타일링](https://www.acmicpc.net/problem/11726)
- 11727번 [2xn 타일링2](https://www.acmicpc.net/problem/11727)

<br >

- 9095번 [1,2,3 더하기](https://www.acmicpc.net/problem/9095)
- 15988번 [1,2,3 더하기3](https://www.acmicpc.net/problem/15988)

<br >

- 11052번 [카드 구매하기](https://www.acmicpc.net/problem/11052)
- 16194번 [카드 구매하기2](https://www.acmicpc.net/problem/16194)

<br >

- 10844번 [쉬운 계단 수](https://www.acmicpc.net/problem/10844)
- 11057번 [오르막 수](https://www.acmicpc.net/problem/11057)
- 2193번 [이친수](https://www.acmicpc.net/problem/2193)
- 2156번 [포도주 시식](https://www.acmicpc.net/problem/2156)

> 마지막 오는 숫자를 케이스로 나눠서 푸는 문제

<br >

- 11053번 [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
- 14002번 [가장 긴 증가하는 부분 수열4](https://www.acmicpc.net/problem/14002)
- 11722번 [가장 긴 감소하는 부분 수열](https://www.acmicpc.net/problem/11722)
- 11054번 [가장 긴 바이토닉 부분 수열](https://www.acmicpc.net/problem/11054)
- 1912번 [연속합](https://www.acmicpc.net/problem/1912)
- 1699번 [제곱수의 합](https://www.acmicpc.net/problem/1699)

- 2293번 [동전 1](https://www.acmicpc.net/problem/2293)
- 2294번 [동전 2](https://www.acmicpc.net/problem/2294)

> 동전 2는 DP와 BFS로 풀 수 있는 문제이다. 두 가지 방법으로 풀어보는 것을 추천한다.