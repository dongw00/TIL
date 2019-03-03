# enum class

## enum (JDK 1.5 이상)

- Class 처럼 보이게 하는 상수
- 새로운 enum을 선언하면, 내부적으로 enum class 기반의 새로운 Class가 만들어짐

### 1. enum 기본

- Class안에 선언하는 방법
- 따로 파일을 만들어서 선언하는 방법
- 클래스 밖에서 선언

```java
public enum Country {
    KOREA, JAPAN, UK, US, CHINA
}
```

#### 예제
```java
enum Nation {
    KOREA, JAPAN, UK, US, CHINA
}

public class Money {
    public String name;
    public Long balance;
    public Nation nation;

    public static void main(String[] args) {
        Money money = new Money();

        money.name = "달러";
        money.balance = 10.5;
        money.nation = Nation.KOREA;
    }
}
```

### 2. enum Method

1. values() : enum 모든 원소를 배열에 담아 순차적으로 반환한다.

```java
enum Nation {
    KOREA, JAPAN, UK, US, CHINA
}

public class Money {
    public String name;
    public Long balance;
    public Nation nation;

    public static void main(String[] args) {
        for (Nation nation : Nation.values()) {
            System.out.println(nation);
        }
    }
}
```

```text
KOREA
JAPAN
UK
US
CHINA
```

2. ordinal() : enum원소에 열거된 순서를 정수 값으로 변환한다.

```java
enum Nation {
    KOREA, JAPAN, UK, US, CHINA
}

public class Money {
    public String name;
    public Long balance;
    public Nation nation;

    public static void main(String[] args) {
        Money money = new Money();

        money.name = "달러";
        money.balance = 10.5;
        money.nation = Nation.KOREA;

        System.out.println(money.nation.ordinal());

        money.nation = Nation.US;
        System.out.println(money.nation.ordinal());
    }
}
```

```text
0
3
```

3. valueOf() : 주어진 param값과 enum값과 일치하는 이름을 갖는 원소를 반환한다.

```java
enum Nation {
    KOREA, JAPAN, UK, US, CHINA
}

public class Money {
    public static void main(String[] args) {
        Nation nation1 = Nation.JAPAN;
        Nation nation2 = Nation.valueOf("CHINA");

        System.out.println(nation1);
        System.out.println(nation2);
    }
}
```

```text
JAPAN
CHINA
```

### enum에 값을 써보기

```java
enum Nation {
    KOREA("원화"), JAPAN("엔화"),
    UK("파운드화"), US("달러"), CHINA("위안화")

    final private String name;

    /* Setter */
    private Nation(String name) {
        this.name = name;
    }

    /* Getter */
    private String getName() {
        return name;
    }
}

public class Money {
    public static void main(String[] args) {
        for (Nation nation : Nation.values()) {
            System.out.println(nation.getName());
        }
    }
}
```

```text
원화
엔화
파운드화
달러
위안화
```

### 같이 보면 좋을 자료 들

- [Java Enum 활용기 - 우아한형제들 기술블로그](http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html)
