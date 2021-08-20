package outputTemplates;

import entities.Student;

public final class Outputer extends ShortOutputer {
    public void printAllStudentInfo(Student student, int val) {
        if (val == 1) {
            System.out.println("Time of report generation = " + timeOfReportGeneration.getTime());
            student.getAllInfo();
        } else {
            printShortStudentInfo(student);
        }
    }
}
