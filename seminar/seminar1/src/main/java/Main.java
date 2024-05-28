import org.sopt.classes.Person;

public class Main {
    public void main(String[] args) {
        //Person 클래스의 객체 생성
        Person person = new Person();
        //Person 클래스 내부 메소드 호출
        person.walk();

        Person person = new Person("도소현", 24, "female");

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        System.out.println(person.getName());

        System.out.println(person.getName()); //결과 : 도소현

        person.setName("서팟장");

        System.out.println(person.getName());

        person.name;
    }

}
