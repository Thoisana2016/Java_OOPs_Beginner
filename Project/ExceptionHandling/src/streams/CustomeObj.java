package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    String name;
    char grade;
    int roll;
    Student(String name, char grade, int roll){
        this.name = name;
        this.grade = grade;
        this.roll = roll;
    }
}
public class CustomeObj {

    public static void main(String[] args) {
        List<Student> students  = Arrays.asList(
                new Student("Jane", 'A', 12),
                new Student("Joe",'A', 17),
                new Student("Chandler", 'C', 13),
                new Student("Rachel", 'C', 21),
                new Student("Monica",'B',23),
                new Student("Ross", 'B', 11)
        );
        List<String>  higherGradeStudent = students.stream().filter(n -> n.grade == 'C')
                .map(s -> s.name +" - "+s.roll)
                .collect(Collectors.toList());
        System.out.println(higherGradeStudent);
    }

}
