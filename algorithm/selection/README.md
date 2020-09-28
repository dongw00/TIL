# Selection Algorithm

### Quick Select

Quick Select를 이용한 문제는 다음과 같은 경우에 주로 사용한다.

- n개에서 k등 찾기

```java
static int[] arr;

/* Quick Select */
private static int quickSelect(int start, int end, int k) {
  if (start <= end) {
    int pivot = partition(start, end);

    if (pivot == k)
      return arr[pivot];
    else if (pivot > k)
      return quickSelect(start, pivot - 1, k);
    else
      return quickSelect(pivot + 1, end, k);
  }
  return Integer.MIN_VALUE;
}

/* Quick Sorting과 같은 partition 절차를 거친다. */
private static int partition(int start, int end) {
  int pivot = start + new Random().nextInt(end - start + 1);

  swap(end, pivot);

  int i = start - 1;
  for (int j = start; j < end; j++) {
    if (arr[j] < arr[end]) {
      i++;
      swap(i, j);
    }
  }
  swap(i + 1, end);
  return i + 1;
}
```

- [K번째 수](https://www.acmicpc.net/problem/11004)