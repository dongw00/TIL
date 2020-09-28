# Stack

## Stack이란?
FILO(First-In Last-Out) 먼저 들어간 원소는 나중에 나오는 자료구조입니다.

Stack에서 자주 사용하는 메소드는 3가지가 있습니다.
1. Push (삽입)
```java
stk.push('10');
stk.push('20');
```
2. Pop (삭제)
```java
while (!stk.isEmpty()) {
  stk.pop();
}

```
3. Top (상위 값)
```java
stk.peek();
```

### 유형

1. 후위 표기식

- 피연산자 : 바로 출력
- 사칙연산 : 스택이 비어있는 경우, 스택의 top보다 우선순위가 높을 경우
- 괄호 : (일 경우 push, )일 경우 (을 만날 때 까지 pop

- 1918번 [후위 표기식](https://www.acmicpc.net/problem/1918)

### 문제

- 9012번 [괄호](https://www.acmicpc.net/problem/9012)
- 2493번 [탑](https://www.acmicpc.net/problem/2493)

