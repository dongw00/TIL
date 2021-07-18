# Fundamental

## 입 출력

- 2557번 [Hello World](https://www.acmicpc.net/problem/2557)
- 11718번 [그대로 출력하기](https://www.acmicpc.net/problem/11718)

  <br >

## 사칙 연산

### 덧셈 연산

- 1000번 [A+B](https://www.acmicpc.net/problem/1000)
- 2558번 [A+B -2](https://www.acmicpc.net/problem/2558)
- 10950번 [A+B -3](https://www.acmicpc.net/problem/10950)
- 10951번 [A+B -4](https://www.acmicpc.net/problem/10951)
- 10952번 [A+B -5](https://www.acmicpc.net/problem/10952)
- 10953번 [A+B -6](https://www.acmicpc.net/problem/10953)
- 11021번 [A+B -7](https://www.acmicpc.net/problem/11021)
- 11022번 [A+B -8](https://www.acmicpc.net/problem/11022)
- 15552번 [빠른 A+B](https://www.acmicpc.net/problem/15552)

### 나머지 연산

> 참고 : A+B % N = (A % N) + (B % N), (A-B) % N = ((A % N) - (B % N) + N)

- 10430번 [나머지](https://www.acmicpc.net/problem/10430)

<br >

## 자료형

### BigInteger

- 10757번 [큰 수 A+B](https://www.acmicpc.net/problem/10757)
  > 참고 : [Java Scanner와 BigInteger 사용하기](https://www.acmicpc.net/blog/view/3)

### Buffer

- 15552번 [빠른 A+B](https://www.acmicpc.net/problem/15552)

<br >

## 최대공약수, 최소공배수

> 유클리드 호제법활용 GCD: 재귀함수, LCM = g(a/g)(b/g)

재귀함수를 이용한 GCD 계산

```java
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    gcd(b, a % b);
}
```

```java
int lcm(int a, int b) {
    return a * b / gcd(a, b);
}
```

- 2609번 [최대공약수와 최소공배수](https://www.acmicpc.net/problem/2609)
- 1934번 [최소공배수](https://www.acmicpc.net/problem/1934)
- 9613번 [GCD 합](https://www.acmicpc.net/problem/9613)

<br >

## 확장 유클리드 알고리즘

기존 유클리드 호재법이 A, B의 최대공약수를 구할 때 O(max(logA, logB))만의 시간이 걸린다.

`확장 유클리드 알고리즘`은 최대공약수 뿐만 아니라, 정수해를 가지는 부정방적식 Ax+Bx=C가 있다고 했을때 `A, B의 최대공약수`를 구함과 동시에 이 방식식을 만족하는 `x, y값`들을 찾는다.

해가 존재하려면 C가 GCD(A, B)의 배수여야 한다.

<br >

## 소수, 에라토스테네스의 체

`소수` : 약수가 1과 자기자신밖에 없는 수 <br >
N이 소수가 되려면, **2보다 크거나 같고**, **root N보다 작거나 같은 자연수로 나누어 떨어지면 안된다.**

```java
bool prime(int n) {
  for (int i = 0; i * i <= n; i++) {
    if (n % i == 0)
      return false;
  }
  return true;
}
```

시간복잡도 : O(root N)

- 1978번 [소수 찾기](https://www.acmicpc.net/problem/1978)

`에라토스테네스의 체` : 1부터 N까지 범위 안에 들어있는 모든 소수를 구하려면 에라토스테네스의 체를 쓰면된다.

![](https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif)

```java
/* 100까지의 소수*/
void eratos() {
  boolean[] chk = new boolean[101];
  chk[0] = chk[1] = true;
  for (int i = 2; i * i <= n; i++) {
    if (chk[i])
      continue;
    for (int j = i * 2; j <= n; j += i)
      chk[j] = true;
  }
}
```

- 1929번 [소수 구하기](https://www.acmicpc.net/problem/1929)

> 안쪽 for문의 j값은 N 범위에 따라 i\*i or i+i로 바꿔준면 된다. (int 범위)
