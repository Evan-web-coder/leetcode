package ll.com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // 使用 Comparator 自定义排序（按姓名排序）
        Collections.sort(people, new NameComparator());

        System.out.println(people);
    }

    public static class NameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            // 按名字升序排序
            return p1.getName().compareTo(p2.getName());
        }
    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}
