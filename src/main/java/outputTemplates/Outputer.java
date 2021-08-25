package outputTemplates;

import entities.Student;

import java.util.Calendar;

import static java.lang.Math.abs;

public final class Outputer {

    Calendar timeOfReportGeneration = Calendar.getInstance();

    public void printShortStudentInfo(Student student) {
        System.out.print(student.getName() + " (" + student.getCurriculum().getDescription() +
                ") ");
        if(student.getEndOfCourseDate().getTime() < timeOfReportGeneration.getTime().getTime())
        {
            int day = timeOfReportGeneration.get(Calendar.DAY_OF_MONTH)-student.getEndOfCourseDate().getDate();
            int hour = timeOfReportGeneration.get(Calendar.HOUR_OF_DAY)-student.getEndOfCourseDate().getHours();
            System.out.print("Training complete. " + day + " days " + hour +" hours have passed since the end ");
        }
        else{
            int day = abs(timeOfReportGeneration.get(Calendar.DAY_OF_MONTH)-student.getEndOfCourseDate().getDay());
            int hour = abs(timeOfReportGeneration.get(Calendar.HOUR_OF_DAY)-student.getEndOfCourseDate().getHours());
            System.out.print("Training is not finished. " + day + " days " + hour +" hours are left until the end ");
        }
    }

    public void printAllStudentInfo(Student student, int val) {
        if (val == 1) {
            System.out.println("Time of report generation = " + timeOfReportGeneration.getTime());
            student.printAllInfo();
        } else {
            printShortStudentInfo(student);
        }
    }
}
