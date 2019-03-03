# Builder 패턴

매개변수가 많아질 경우 해당 Class의 객체를 생성을 신축성 있게 처리하지 못하는데,
생성자(Constructor)의 매개변수가 많을 때 어떻게 해야하는지 살펴보겠습니다.

## 해결방법

### 1. 텔레스코핑 생성자 패턴(Telescoping Constructor)

첫 번째로 `텔레스코핑 생성자 패턴`이 있다.
생성자를 Overloading하여 사용하는 방법이다.

```java
public class Info {
    private final String name;
    private final int age;
    private final float height;

    public Info(String name, int age, float height) {
        this(name, age, height);
    }

    public Info(String name, int age, float height) {
        this(name, age, 0);
    }
}
```

### 2. JavaBeans 패턴

해당 패턴은 생성자 호출 후 Setter 메소드를 이용해서 각각의 값을 지정합니다.
> Getter, Setter 클래스라고 생각하면 됩니다.

```java
public class Info {
    private final String name;
    private final int age;
    private final float height;

    public Info() { }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setHeight(float height) { this.height = height; }
}
```

이 패턴은 자칫 코드가 길어질 수 있는 객체 생성이 간단하며 가독성이 좋다.
그런데 큰 단점이 존재한다. 객체 생성 할 때 해당 `객체가 완전하게 생성됨`(Freezing)을 보장할 수 없다.

ex) Info Class의 객체 생성 시 name, age, height의 값들이 세팅되어야 하지만, 컴파일러는 이를 검사할 수 없기때문에 값을 빠트리고 객체를 생성할 수 있다.

### 3. Builder 패턴

이 글에서 핵심적으로 알아볼 패턴이다. 앞에서 소개한 Telescoping Constructor 패턴과 Java Beans 패턴을 결합한 것이 Builder 패턴이다.

객체를 생성할 때 필수 매개변수를 갖는 생성자를 얻어낸 후 나머지 필드는 Setter 메소드로 값을 셋팅한다.
그리고 마지막으로 build 메소드를 호출하여 immutable(불변) 객체를 생성한다.
> Immutable 객체는 객체 생성 후 상태가 변하지 않는다.

```java
public class Info {
    private final String name;
    private final int age;
    private final float height;

    public static class Builder {
        private final String name;
        private final int age;
        private final float height;
        private final String job;
        private final String address;

        /* 필수 생성자 */
        public Builder(String name, int age, float height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        /* 나머지 값 builder로 생성 */
        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Info build() {
            return new Info(this);
        }
    }

    public Info(Builder builder) {
        name = builder.name;
        age = builder.age;
        job = builder.job;
        address = builder.address;
    }
}
```

`Builder Class`의 Setter 메소드를 통해 **나머지 값 필드를 생성**하고 생성자에서 Info Class의 생성자를 호출하여 값을 셋팅한다.

```java
Info info = new Info.Builder("홍길동", 25, 180.4)
                        .job("학생")
                        .address("서울특별시")
                        .build();
```

### 참고자료

- [Effective Java 생성자의 매개변수가 많을 때](https://using.tistory.com/71)