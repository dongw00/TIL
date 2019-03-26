# Divide and Conquer (분할 정복)

용어 그대로 분할한 다음 정복한다는 뜻을 가진 기법이다.

분할 단계에서는 주어진 문제를 `여러 부분 문제`로 나누게 되는데,

이때, 문제의 크기가 작아질수록 풀기 쉬워지는 성질을 이용한다.

작아진 부분 문제들을 합쳐나가 최종적으로 답을 구하면 된다.

보통 `Divide and Conquer`에 관한 문제를 해결할때 재귀함수를 이용하는데,

대표적으로 분할 정복을 이용한 알고리즘으로 `병합 정렬(Merge Sort)`, `이분 탐색(Binary Search)`, `거듭제곱 연산` 등이 있다.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/1024px-Merge_sort_algorithm_diagram.svg.png)

- [종이의 개수](https://www.acmicpc.net/problem/1780)
- [쿼드트리](https://www.acmicpc.net/problem/1992)
- [K번째 수](https://www.acmicpc.net/problem/11004)