package entities;

import java.util.*;

public class Student {

    private String name;
    private Curriculum curriculum;
    private Calendar startDate;
    private List<Course> courses;
    private int workTimeFrom;
    private int workTimeTo;
    private Date endOfCourseDate;

    public Student(String name, Curriculum curriculum, Calendar startDate, List<Course> courses,
                   int workTimeFrom, int workTimeTo) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.courses = courses;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
        this.endOfCourseDate = calculateEndOfCoursesDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getWorkTimeFrom() {
        return workTimeFrom;
    }

    public void setWorkTimeFrom(int workTimeFrom) {
        this.workTimeFrom = workTimeFrom;
    }

    public int getWorkTimeTo() {
        return workTimeTo;
    }

    public void setWorkTimeTo(int workTimeTo) {
        this.workTimeTo = workTimeTo;
    }

    public Date getEndOfCourseDate() {
        return endOfCourseDate;
    }

    public void getAllCourses() {
        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    public int getSummaryDurationOfCourses() {
        int coursesDuration = 0;
        for (Course c : courses) {
            coursesDuration += c.getDuration();
        }
        return coursesDuration;
    }

    public Date calculateEndOfCoursesDate() {
        Calendar tempCalendar = new GregorianCalendar();
        tempCalendar.set(Calendar.YEAR, startDate.get(Calendar.YEAR));
        tempCalendar.set(Calendar.MONTH, startDate.get(Calendar.MONTH));
        tempCalendar.set(Calendar.DAY_OF_MONTH, startDate.get(Calendar.DAY_OF_MONTH));
        tempCalendar.set(Calendar.MINUTE, 0);
        tempCalendar.set(Calendar.SECOND, 0);
        tempCalendar.add(Calendar.HOUR, 1);

        int durationOfCourses = getSummaryDurationOfCourses();
        while (durationOfCourses > 0) {
            while (tempCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    tempCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                tempCalendar.set(Calendar.HOUR_OF_DAY, workTimeFrom);
                tempCalendar.add(Calendar.DAY_OF_WEEK, 1);
            }

            if (tempCalendar.get(Calendar.HOUR_OF_DAY) > workTimeTo - 1) {
                tempCalendar.add(Calendar.DAY_OF_MONTH, 1);
                tempCalendar.set(Calendar.HOUR_OF_DAY, workTimeFrom);
            }

            tempCalendar.add(Calendar.HOUR_OF_DAY, 1);
            durationOfCourses--;
        }

        return tempCalendar.getTime();
    }

    public void printAllInfo() {
        String format = String.format("Name: %s \nCurriculum: %s \nStart date: %s \nWork tome: from %s " +
                "to: %s \n Total duration of all courses (hours): %s \n Approximate end time of courses: %s\n" +
                "Courses of %s:",getName(), getCurriculum().getDescription(), getStartDate().getTime(),
                getWorkTimeFrom(), getWorkTimeTo(), getSummaryDurationOfCourses(), getEndOfCourseDate(), getName());
        System.out.println(format);
        getAllCourses();
    }
}
