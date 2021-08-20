import entities.CURRICULUM;
import entities.Course;
import entities.Student;
import outputTemplates.Outputer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentCoursesApplication {
    public static void main(String[] args) {
        CURRICULUM Java = new CURRICULUM("Java developer");
        ArrayList<Course> courses = new ArrayList<>();
        Course javaCourse = new Course("Java Course", 8);
        Course gitCourse = new Course("git", 5);
        courses.add(javaCourse);
        courses.add(gitCourse);
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.YEAR, 2021);
        Student student = new Student("Oleg", Java, calendar,
                courses, 10, 18);
        Outputer outputer = new Outputer();
        System.out.println("--------Full report-------------");
        outputer.printAllStudentInfo(student, 1);
        System.out.println("--------Short report-------------");
        outputer.printShortStudentInfo(student);
    }
}
