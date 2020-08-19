# Design pattern

## Design pattern?
객체지향 설계는 재설계 없이 or 재설계를 최소화하면서 요구 사항의 변화를 쉽게 수용할 수 있도록 만들어준다.

객체지향 설계를 하다보면, 이전에 비슷한 상황에서 사용했던 설계를 재사용하는 경우가 종종 발생한다.

반복적으로 사용되는 설계는 클래스, 객체의 구성, 객체 간 메시지 흐름에서 일정한 패턴을 갖는다. 이러한 것을 `디자인 패턴`이라 한다.

### Design pattern 이점

- 상황에 맞는 설계를 빠르게 적용할 수 있다.
- 각 패턴의 장단점을 통해서 설계를 선택하는데 도움을 얻을 수 있다.
- 설계 패턴에 이름을 붙임으로써 문서화, 유지보수에 이점이 있다.

## 전략(Strategy) 패턴

한 과일 매장에서 상황에 따른 가격 할인 정책을 적용하고 있을떄, '첫 손님 할인', '덜 신선한 과일 할인'이 있다.

### 전략 패턴 적용 전

```java
public class Calculator {
    public int calculate(boolean firstGuest, List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            if (firstGuest)
                sum += (int) item.getPrice() * 0.9;  // 첫 손님 할인
            else if (!item.isFresh())
                sum += (int) item.getPrice() * 0.8;  // 덜 신선한 과일 할인
            else
                sum += item.getPrice();
        }
        return sum;
    }
}
```

해당 코드에서는 아래와 같은 문제점을 가지고 있다.

- 서로 다른 계산 정책이 존재해, 정책이 추가될수록 복잡하다.

### 전략 패턴 적용 후

```java
public class Calculator {
    private DiscountStrategy discountStrategy;

    public Calculator(DiscountStragegy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public int calculate(List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            sum += discountStrategy.getDiscountPrice(item);
        }
        return sum;
    }
}
```

```java
public interface DiscountStrategy {
    int getDiscountPrice(Item item);
}
```

```java
public class FirstGuestDiscountStrategy implements DiscountStrategy {

    @Override
    public int getDiscountPrice(Item item) {
        return (int) item.getPrice() * 0.9;
    }
}
```

```java
public class LastGuestDiscountStrategy implements DiscountStrategy {

    @Override
    public int getDiscountPrice(Item item) {
        return (int) item.getPrice() * 0.8;
    }
}
```

```java
public class Main {
    private DiscountStrategy discountStrategy;

    public void onFirstGuestButtonClick() {
        strategy = new FirstGuestDiscountStrategy();
    }

    public void onLastGuestButtonClick() {
        strategy = new LastGuestDiscountStrategy();
    }

    public void onCalculatorButtonClick() {
        Calculator cal = new Calculator(strategy);
        int price = cal.calculate(items);
    }
}
```