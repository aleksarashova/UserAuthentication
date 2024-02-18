package Students;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Aleksa", "Rashova", 6);
        Student s2 = new Student("Aleksa", "Simeonov", 3);
        Student s3 = new Student("Aleks", "Hristov", 5);

//        System.out.println(s1.equals(s2));

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

//        List<Student> sortedStudents = new ArrayList<>(students);
//        sortedStudents.sort((student1, student2) -> {
//            return Double.compare(student1.getGrade(), student2.getGrade());
//        });
//        Collections.reverse(sortedStudents);
//        sortedStudents.forEach((student) -> {
//            System.out.println(student.toString());
//        });
        Set<Student> uniqueStudents = new HashSet(students);
        for (Student uniqueStudent : uniqueStudents) {
            System.out.println(uniqueStudent.toString());
        }
    }
}
