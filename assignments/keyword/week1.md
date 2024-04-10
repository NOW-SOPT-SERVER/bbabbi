# SOPT 34기 SERVER 1주차 🔑keyword🔑 과제

## 1️⃣ this와 this() 키워드

> this 는 참조변수, this()는 메소드

### 📌 생성자 this()
* 생성자에서 다른 생성자를 호출할 때 사용 (같은 클래스의 다른 생성자를 호출할 때 사용)
* 다른 생성자 호출 시 첫 줄에서만 사용 가능
* this() 메소드에 인수를 전달하면, 생성자 중에서 메소드 시그니처(메소드의 이름과 메소드의 원형에 명시되는 매개변수 리스트)가 일치하는 다른 생성자를 찾아 호출해줌.

### 📌 참조변수 this
* 인스턴스 자신을 가리키는 참조 변수
* 인스턴스 주소가 저장되어 있음

**🔽 example 🔽**
```
class Car {
  private String modelName;
  private int modelYear;
  private String color;
  private int maxSpeed;
  private int currentSpeed;
  
  Car(String modelName, int modelYear, String color, int maxSpeed) {
    this.modelName = modelName;
    this.modelYear = modelYear;
    this.color = color;
    this.maxSpeed = maxSpeed;
    this.currentSpeed = 0;
  }
  
  Car() {
    this("G90", 2021, "검정색", 200); // 생성자 호출
  }
  
}
```
* 매개변수 이름과 인스턴스 변수 이름이 동일한 경우!!  
  -> 인스턴스 변수 앞에 this 키워드를 붙여 구분한다.

Q. this 참조변수는 아무 때나 사용할 수 있나요?  
A. NOPE. 인스턴스 메소드 내에서만 사용할 수 있습니다. 클래스 메소드에서는 사용할 수 없습니다.  
인스턴스 메소드에서 사용할 수 있는 이유는 모든 인스턴스 메소드에 this 참조변수가 숨겨진 지역변수로 존재하고 있기 때문.


## 2️⃣ Java의 Generic 타입
> * 제네릭(Generic)은 class, **method에서 사용할 자료형을 나중에 확정**하는 기법
> * 제네릭을 사용할 때, 객체 생성 시 결정 되는 자료형 정보를 'T'로 대체
>   * 다이아몬드 연산자 < >를 통해 자료형을 전달
> ```
> class Camp<T> {
>   private T unit;
> 
>   public void set(T unit) {
>       this.unit = unit;
>   }
> 
>   public T get(){
>       return unit;
>   }
> }
> ```

### 📌 제네릭(Generic)이란?
데이터 형식에 의존하지 않고, **하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록** 하는 방법  
클래스나 메서드를 선언할 때가 아니라 ⭐️ 사용할 때 ⭐️(== 객체를 생성할 때 or 메서드를 호출할 때) 자료형을 정함

아래의 두 코드를 비교해보면, 제네릭을 이해하는 데 도움이 된다.

**제네릭을 사용하지 않는 코드**
```
class Camp {
    private Object unit; // ⭐️
    
    public void set(Object unit) {
        this.unit = unit;
    }
    
    public Object get() {
        return unit;
    }
}
```
+) ⭐️: Object로 설정한 이유는?  
-> 어떤 자식 클래스라도 받아들일 수 있도록  
-> 근데 이렇게 하면 꺼내올 때 **형변환이 필요**함.  
예를 들어, `Npc2 hUnit = (Npc2)human.get();`  

Q. 잘 작동하기만 하면 되는 거 아닌가?  
A. NOPE. 위와 같이 코드를 작성하면 컴파일러가 오류를 발견할 수가 없겠지?  
예를 들어서 개발자의 실수로 잘못된 타입으로 강제 변환하거나(위에서 말했다시피 Object로 지정할 경우 형변환이 필수임!)
타입에 맞지 않는 즉 다른 타입의 객체를 저장하게 되었을 때, 컴파일러는 문제가 있다는 점을 알아챌 수 없어!  
왜? Object는 Java에서 모든 클래스의 최상위 클래스이기 때문에 문법적 오류가 없거든.

**제네릭을 사용하는 코드**
```
class Camp<T> {
private T unit;

    public void set(T unit) {
        this.unit = unit;
    }
    
    public T get() {
        return unit;
    }
}
```

###  📌 제네릭(Generic)은 왜 필요할까? - 제네릭의 장점
* 중복된 코드의 결합 및 간소화
* 데이터를 가져올 때 형변환 없이 가져올 수 있음
* 데이터 대입 시 다른 자료형이 대입되는 것 방지 -> 강한 자료형 체크

### 🙌 제네릭 관련 변수 용어
|용어|대상|
|---|---|
|타입 매개변수(type parameter)|Camp<T>에서 T|
|타입 인수(type argument)|Camp<Npc>에서 Npc|
|매개변수화 타입(parameterized type)|Camp<Npc>|

⬇️ 타입 매개변수의 이름 규칙 ⬇️
* 보통 한 문자, 대문자로 이름을 지음
  * E : Element
  * K : Key
  * N : Number
  * T : Type
  * V : Value

### 📌 매개변수가 여러 개일 때도 제네릭을 쓸 수 있을까?
ㄴ 네.
```
class Camp<T1, T2> // ⭐️
 {
  private T1 param1;
  private T2 param2;
  
  public void set(T1 o1, T2 o2)
  {
    param1 = o1;
    param2 = 02;
  }
  
  public String toString() // 📌
  {
    return param1 + " & " + param2;
  }
}

public class Multiparameter
{
  public static void main(String[] args)
  {
    Camp<String, Integer> camp = new Camp<>(); // ⭐⭐️
    camp.set("Apple", 25);
    System.out.println(camp); // ⭐️⭐️⭐️
  }
}
```
 ⭐️ : < > 내부에 타입 매개변수는 하나일 필요 없음  
 ⭐️⭐️ : 앞쪽(좌변) < >에 데이터형 지정 후, 뒤쪽(우변)에는 생략  
 ⭐️⭐️⭐️ : 클래스에 📌 toString() method가 overriding으로 재정의 되어 있음. 따라서 method 내용이 출력된다.

### 📌 제네릭 메서드
```
class MyData
{
    public static <T> T showData(T data)
    {
        ...
    }
}
```

1) 제너릭 메서드의 'T'는 메서드 호출 시점에 결정된다.  
`MyData.<String>showData("Hello World");`
2) 타입 인수 생략이 가능하다. (생략된 인수는 매개변수로 들어온 데이터의 자료형으로 추론)  
`MyData.showData(1);`


## 3️⃣ final, static, static final
> **final** : 한 번 값이 정해지고 나면 값을 바꿀 수 없는 필드  
> **static** : 객체마다 가질 필요가 없는 공용으로 사용하는 필드 혹은 인스턴스 필드를 포함하지 않는 메소드   
> **static final** : 모든 영역에서 고정된 값으로 사용하는 상수


### 📌final
"지금 저장하는 값이 final이야" 즉, 앞으로 수정이 불가능해. 라고 기억하면 된다.
```
public class Shop {
  final int closeTime = 21; // 1) 선언과 동시에 값을 주는 방법
  final int openTime; // 2-1) 먼저 생성하고
  
  public Shop(int openTime) { // 2-2) 객체를 생성할 때 값을 주는 방법
    this.openTime = openTime;
  }
}
```
-> 지금 위의 코드는 가게를 닫는 시간을 고정하는 것!


### 📌static
* 객체를 생성하지 않고 사용할 수 있는 필드나 메서드를 생성할 때 활용
  * 필드나 메소드를 객체마다 다르게 가져야 한다 == 인스턴스로 생성
  * 공용 데이터에 해당한다 or 인스턴스 필드를 포함하지 않는 메소드를 선언해야한다 == static

* 어떻게 사용할까?
  * 그냥 static을 붙여주면 된다.

```
public class PlusClass {
  static int field1 = 15;
  
  static int plusMethod(int x, int y) { 
    this.field2 = 10; // <-- x
    this.method1(); // <-- x
    }
}

int ans1 = PlusClass.plusMethod(15,2); // 클래스이름.필드
int ans2 = PlusClass.field1 + 2;
```
* 단, this 키워드를 사용할 수는 없음
  * 정적 메소드는 클래스 레벨에서 작동하기 때문에 정적 메소드 내에서 인스턴스 필드, 메소드, this 키워드를 사용할 수 없음.
  * 정적 메소드는 객체 없이도 호출될 수 있기 때문에 this가 가리킬 실제 객체가 없음.

### 📌static final
> 상수를 선언할 때 사용

```
static fianal double PI = 3.141592;
```

* PI는 객체마다 저장될 필요가 없으며(static의 성질) + 여러 값을 가질 수 없다(final의 특징)

## 4️⃣ super, super()
> super는 참조변수, super()는 메소드

### 📌 super()
> 부모 클래스의 생성자를 호출할 때 사용

* this() 메소드는 같은 클래스의 다른 생성자를 호출할 때 사용한다.
* super() 메소드는 부모 클래스의 생성자를 호출할 때 사용한다.
  * 자식 클래스의 인스턴스를 생성하면 자식 클래스의 고유 멤버 뿐만 아니라 부모 클래스의 모든 멤버도 포함됨
  * 부모 클래스의 멤버를 초기화하기 위해서는 자식 클래스의 생성자에서 부모 클래스의 생성자까지 호출해야함
  * 부모 클래스의 생성자 호출은 모든 클래스의 부모 클래스인 Object 클래스 생성자까지 거슬러 올라가며 수행됨
  * 따라서 자바 컴파일러는 부모 클래스의 생성자를 명시적으로 호출하지 않는 모든 자식 클래스의 생성자 첫 줄에 자동으로 `super();` 를 추가하여
    부모 클래스의 멤버를 초기화할 수 있게 해줌.


### 📌 super
> 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조할 때 사용

* 인스턴스 변수의 이름과 지역 변수의 이름이 같은 경우 인스턴스 변수 앞에서 this 키워드를 사용하여 구분한다.
* 부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 super 키워드를 사용하여 구분한다.
  * 단, this처럼 super도 인스턴스 메소드에 한해서만 사용이 가능하고, 클래스 메소드에서는 사용할 수 없다.

## 5️⃣ SOLID 원칙
SOLID 원칙을 지키면 유지보수 및 확장에 용이한 SW 개발에 도움이 된다.

>객체지향 설계의 핵심 : **높은 응집도와 낮은 결합도**

> 1. SRP(Single Responsibility Principle) : 단일 책임 원칙
> 2. OCP(Open-Closed Principle) : 개방-폐쇄 원칙
> 3. LSP(Liskov Substitution Principle) : 리스코프 치환 원칙
> 4. ISP(Interface Segregation Principle) : 인터페이스 분리 원칙
> 5. DIP(Dependency Inversion Principle) : 의존 역전 원칙

### 📌 SRP(Single Responsibility Principle) - 단일 책임 원칙
* 하나의 클래스는 하나의 책임만을 가져야 한다.
* 클래스를 변경하는 이유는 단 하나만. 변경이 있을 때 파급효과가 적어야 한다.
  * 만약 이걸 지키지 않는 경우, 하나의 Responsibility를 변경하는데 다른 Responsibility와 관련된 코드에 영향을 미칠 수도 있다.
  * 결국 유지보수를 비효율적으로 만든다.

📌Responsibility
: SRP에서 이야기하는 Responsibility(책임)는 곧 기능에 해당한다.  
하나의 클래스가 수행할 수 있는 기능이 여러 개라면, 클래스 내부의 함수끼리 강한 결합을 가질 가능성이 높아지고, 이는 코드의 효율성을 떨어뜨린다.

### 📌 OCP(Open-Closed Principle) 개방-폐쇄 원칙
* 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
* 즉, 기존의 코드르 변경하지 않고 기능을 수정, 추가할 수 있도록 설계해야한다.
* 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현해야한다.


어떤 모듈의 기능을 수정할 때, 수정하려는 모듈을 이용하는 다른 모든 모듈을 수정한다면 유지 보수가 복잡해진다.  
따라서 OCP(개방-폐쇄 원칙)을 적용해서 기존 코드를 변경하지 않아도 기능을 수정 및 추가할 수 있게 해야한다.  
-> OCP를 지키지 않으면 객체지향 프로그래밍의 장점인 유연성, 재사용성, 유지보수성 등을 활용하지 못하게 된다.

Q. 그러면 기존의 코드를 변경하지 않고 어떻게 기능을 수정하거나 추가하나요?  
A. 상속(다형성)과 추상화(인터페이스)를 활용하면 된다.  
자주 변경하는 부분을 추상화해서 기존 코드를 수정하지 않고 기능을 확장할 수 있도록 하여 유연성을 살린다.  

### 📌 LSP(Liskov Substitution Principle) 리스코프 치환 원칙
* 하위 타입 객체는 상위 타입 객체에서 가능한 행위를 수행할 수 있어야 한다.
  * 즉, 상위 타입 객체를 하위 타입 객체로 대체하여도 정상적으로 동작해야 한다.
* 다형성에서 하위 클래스는 인터페이스의 규약을 다 지켜야 한다.
* 상속 관계에서는 꼭 일반화 관계(IS-A)가 성립해야 한다.
* 상속 관계가 아닌 클래스들을 상속관계로 설정하면, LSP 위반이다.

### 📌 ISP (Interface Segregation Principle) 인터페이스 분리 원칙
* 클라이언트는 자신이 사용하는 메소드에만 의존해야 한다.
* 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 한 개보다 낫다.
* 인터페이스는 해당 인터페이스를 사용하는 클라이언트를 기준으로 잘게 분리되어야 한다.

### 📌 DIP (Dependency Inversion Principle) 의존 역전 원칙
* 의존 관계를 맺을 때, 변하기 쉬운 구체적인 것 보다는 변하기 어려운 추상적인 것에 의존해야 한다
* 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다
* 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안된다
---

## 6️⃣ 스프링의 의존성 주입 방식
스프링은 모든 기능의 기반을 제어의 역전(IoC)과 의존성 주입(DI)에 두고 있다.

### 📌 제어의 역전(IoC, Inversion of Control)이란?
>외부에서 관리하는 객체를 가져와 사용하는 것

| 지금까지의 객체 생성 방식                                                                 | 제어의역전(IoC)                                                                        |
|--------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|
| 객체가 필요한 곳에서 직접 생성                                                              | 외부에서 관리하는 객체를 가져와 사용                                                              |
| ex) ` public class A { b = new B(); }`  <br/>class A에서 **new 키워드로 class B의 객체 생성** | ex) ` public class A { private B b; }`  <br/>코드에서 객체를 생성하지 않음, **어디선가 받아온 객체를 b에 할당** |

 ! 지금까지 객체를 생성했던 방식처럼 직접 생성하거나 제어하는 것이 아니라는 점이 특징 !  
> Q. 이게 spirng에서는 어떻게 나타나나요?  
A. 실제로 spirng은 spring container가 객체를 관리, 제공하는 역할을 해요.  
다시 말하자면, **스프링에서는 객체들을 관리하기 위해 IoC, 제어의 역전을 사용**합니다.  
그 역할을 해주는 게 스프링 컨테이너입니다.  
개발자가 직접 객체를 생성하고 의존성을 관리하는 대신, Spring 컨테이너가 이 작업을 대신 처리하는 것이죠.

### 📌 의존성 주입(DI, Dependency Injection)이란?
> 어떤 클래스가 다른 클래스에 의존한다는 것

**🔽 example 🔽**
```
public class A {
    // A에서 B를 주입 받음
    @Autowired
    B b;
}
```
* @Autowired : 스프링 컨테이너에 있는 Bean을 주입하는 역할
  * Bean : 스프링 컨테이너에서 관리하는 객체, 이 코드에서는 'B'가 Bean에 해당  
    -> 어렵다면 "**_스프링에서 제공해주는 객체_**"라고만 생각하자!
  * 스프링 컨테이너 : 스프링에서 제공되며, 빈을 생성하고 관리하는 역할을 함.
    -> 빈이 생성되고 소멸되기까지의 생명주기를 스프링 컨테이너에서 관리  


* 어렵게 생각할 거 없이 example 코드를 보면 객체를 따로 생성해준 부분이 보이지 않음
  * 그런데 B b;라고 선언하고 있음
  * 이게 바로 객체를 주입 받는 것

### 📌 DI의 4가지 방식 [#🔗]
[#🔗]: https://ittrue.tistory.com/227
> 1️⃣ 생성자 주입  
> 2️⃣ 수정자 주입  
> 3️⃣ 필드 주입  
> 4️⃣ 일반 메서드 주입

(스프링 공식 문서에서는 생성자 주입을 권장하고 있다고 함.  
의존 관계가 변경되지 않는 경우에는 생성자 주입을,  
의존 관계가 선택적이거나 변경 가능한 경우에는 수정자 주입을)

### [생성자 주입]
> 생성자를 통해 의존 관계를 주입받는 방법

생성자에 @Autowired를 하면 스프링 컨테이너에 @Component로 등록된 빈에서 생성자에 필요한 빈들을 주입한다.  
* Spring Container는 클래스가 생성될 때 `@Autowired`가 붙은 생성자를 찾아서  
-> **_해당 생성자의 파라미터 타입에 맞는 빈을 컨테이너에서 찾아 자동으로 주입_**

**생성자 주입의 특징**
* 생성자 호출 시점에 1번만 호출되는 것을 보장


* 불변과 필수 의존 관계에 사용  


* 생성자가 1개만 존재하는 경우 @Autowired를 생략해도 자동 주입됨 


* NPE(NullPointerException)를 방지할 수 있음  
    * NullPointException : 참조 변수가 아무런 객체도 가리키고 있지 않은 상태에서 그 변수를 사용하려고 하면 NPE 에러 발생
    * 왜 생성자 주입이 NPE를 방지할 수 있을까?  
    -> '필드 주입'이나 '수정자 주입'에 비해 생성자 주입은 객체가 생성될 때 모든 의존성이 채워져야 함.  
    -> 따라서 NPE를 방지할 수 있음

* 주입받을 필드를 final로 선언 가능


**🔽 example 🔽**
```
@Component
public class CoffeeService {
  private final MemberRepository memberRepository;
  private final CoffeeRepository coffeeRepository;
  
  @Autowired
  public CoffeeServiceImpl(MemberRepository memberRepository, CoffeeRepository coffeeRepository) {
    this.memberRepository = memberRepository;
    this.coffeeRepository = coffeeRepository;
  }
}
```

* CoffeService 클래스는 `MemberRepository`와 `CoffeeRepository` 두 개의 의존성을 가지고 있음
  * 두 의존성은 클래스의 생성자를 통해 주입되고 있음
  * 이 경우, `MemberRepository`와 `CoffeeRepository` 인터페이스 구현체를 스프링 컨테이너가 자동으로 찾아서 주입해줌

### [수정자 주입]
> Setter(필드 값을 변경하는 수정자 메서드)를 통해 의존 관계를 주입

@Component를 통해 실행하는 클래스를 스프링 빈으로 등록 -> 의존관계를 주입  
@Autowired가 있는 수정자들을 자동으로 의존관계를 주입  

**수정자 주입(Setter 주입)의 특징**  
* 선택과 변경 가능성이 있는 의존 관계에 사용  
  -> 필요에 따라 일부 의존성을 주입할 수도 있고, 주입하지 않을 수도 있음  
  -> 생성자 주입과 달리 객체 생성 후에도 의존성 변경 가능(단, 객체의 상태가 예기치 않게 변경될 수도 있긴 함)
* 자바 빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법
* set 필드명 메서드를 생성하여 의존 관계를 주입
* @Autowired를 입력하지 않으면 실행되지 않음


**🔽 example 🔽**
```
@Component
public class CoffeeService {
  private final MemberRepository memberRepository;
  private final CoffeeRepository coffeeRepository;
  
  @Autowired
  public setMemberRepository(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  
  @Autowired
  public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
    this.coffeeRepository = coffeeRepository;
  }
}
```
* CoffeService 클래스는 `MemberRepository`와 `CoffeeRepository` 두 개의 의존성을 가지고 있음
  * 각각의 의존성은 별도의 setter 메서드(`setMemberRepository`, `setCoffeeRepository`)를 통해 주입됨
* 수정자 주입을 사용할 때는 클래스의 필드를 final로 선언할 수 없음
  * 왜? -> 필드들이 객체 생성 시점에 주입되는 게 아니라 객체 생성 이후에 setter method를 통해 주입되기 때문


### [필드 주입]
> 필드에 @Autowired를 붙여서 바로 주입하는 방버


**필드 주입의 특징**
* 코드가 간결해짐  
  -> 왜? 생성자나 setter 메서드 없이 의존성을 주입할 수 있기 때문

* 단, 외부에서 변경이 불가능하며, 테스트하기 어려움
* DI 프레임워크가 없으면 아무것도 할 수 없음
* Application의 실제 코드와 상관없는 특정 테스트를 하고 싶을 때 사용
* 정상적으로 작동되게 하려면 setter가 필요함
* 의존관계를 필수적으로 넣지 않으려면 @Autowired(required=false) 옵션 처리를 통해 필수가 아님을 명시할 수 있음

**🔽 example 🔽**
```
@Component
public class CoffeeService {
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private CoffeeRepository coffeeRepository;
}
```
* 필드 선언에 직접 @Autowired를 입력해서 자동으로 의존성 주입
* Spring이 객체를 생성한 후 의존성을 주입하기 때문에 final 필드에 값을 할당할 수 없음.(final 사용 불가)

**필드 주입을 사용하지 않는 이유**
* 필드 주입을 하게 되면 DI 컨테이너 안에서만 작동 -> 순수 자바 코드로 테스트하기 어려움

### [일반 메서드 주입]
> 일반 메서드를 통해서 의존 관계를 주입하는 방법  
> 의존성 주입을 위한 특별한 메서드를 자유롭게 정의 가능

@Autowired 어노테이션은 모든 메서드에서 사용할 수 있기 때문에 일반 메서드 주입이 가능

**일반 메서드 주입의 특징**
* 한 번에 여러 필드를 주입받을 수 있음
* 일반적으로 사용하지는 않음


**🔽 example 🔽**
```
@Component
public class CoffeeService {
  private MemberRepository memberRepository;
  private CoffeeRepository coffeeRepository;
  
  @Autowired
  public void method(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
}
```
* @Autowired 어노테이션이 붙은 method 메서드가 의존성 주입의 대상이 된다.


**일반 메서드 주입을 사용하지 않는 이유**
* 필드 주입과 비슷하게 애매한 상황 발생 가능
* 여러 필드를 받을 것이라면 차라리 생성자 주입을 사용하는 것이 좋음


## 7️⃣ Java record
### Record
> JDK 14부터 제공(preview), 16부터 정식 제공
> 불변 객체를 쉽게 생성할 수 있도록 하는 클래스

### Record가 없다면?
불변 객체(immutable) 생성 시 다음과 같이 작성해야한다.
>1. 모든 필드에 final을 선언한다.
>2. 필드 값을 모두 포함한 생성자를 사용한다.
>3. 접근자 메서드 getter를 사용한다.
>4. 클래스의 상속을 제한하려면 클래스 레벨에도 final을 선언한다.

**🔽 example 🔽**
```
public class Student {
  private String name;
  private int age;
  
  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
}
```

### Record를 사용하면?
직접 구현하지 않아도 아래의 내용을 자동 생성할 수 있다.
> * 필드 캡슐화
> * 생성자 메서드
> * getters 메서드
> * equals 메서드
> * hashcode 메서드
> * toString 메서드


이유 : 컴파일 타임에 컴파일러가 코드를 추가해주기 때문

위에서의 예시로 살펴본 Student 객체를 구현하려면 다음과 같이 간단한 코드를 작성하면 된다.

**🔽 example 🔽**
```
public record Student(String name, int age) {
}
```

**🔽 example 🔽(생성자 재정의)**
```
public record Student(String name, int age) {
  public Student {
    if(age < 0) {
      throw new IllegalArgumentException("Age cannot be negative");
    }
  }
}
```
---
## 🔗 참고 자료 - keyword 별
**1️⃣ this와 this() 키워드**

🔗 [#1-1] 도서 - 자바의 정석 기초 / 🔗 [#1-2] 사이트 - tcp school

[#1-1]: https://m.yes24.com/Goods/Detail/85632276
[#1-2]: https://www.tcpschool.com/java/java_methodConstructor_this

**2️⃣ Java의 Generic 타입**


🔗 [#2] 도서 - 이재환의 자바 프로그래밍 입문 / 🔗 [#3] 블로그 - Stranger's LAB

[#2]: https://www.yes24.com/Product/Goods/102919240
[#3]: https://st-lab.tistory.com/153  

**3️⃣ final, static, static final**


🔗[#4] 블로그 - Go devlog

[#4]: https://gobae.tistory.com/3

**4️⃣super, super()**  

🔗[#5] 사이트 - tcp school

[#5]: https://www.tcpschool.com/java/java_inheritance_super


**5️⃣ SOLID 원칙**

🔗[#6] 강의 - (김영한) 스프링 핵심 원리 - 기본편

[#6]: https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8#curriculum

**6️⃣ 스프링의 의존성 주입 방식**

🔗[#7] 도서 - 스프링부트 3 백엔드 개발자되기 - 자바편 / 🔗[#8] 블로그 - IT is True

[#7]: https://www.yes24.com/Product/Goods/125668284
[#8]: https://ittrue.tistory.com/227

**7️⃣  Java record**

🔗[#9] 사이트 - Oracle 공식문서(Record) / 🔗[#10] 블로그 - 미스터포포

[#9]: https://docs.oracle.com/en/java/javase/14/language/records.html
[#10]: https://mr-popo.tistory.com/243
