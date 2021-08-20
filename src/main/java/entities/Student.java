package entities;

import java.util.*;

public class Student {

    private String name;
    private CURRICULUM curriculum;
    private Calendar start_date;
    private ArrayList<Course> courses;
    private int workTimeFrom;
    private int workTimeTo;
    private Date endOfCourseDate;

    public Student(String name, CURRICULUM curriculum, Calendar start_date, ArrayList<Course> courses,
                   int workTimeFrom, int workTimeTo) {
        this.name = name;
        this.curriculum = curriculum;
        this.start_date = start_date;
        this.courses = courses;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
        this.endOfCourseDate = getEndOfCoursesDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CURRICULUM getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(CURRICULUM curriculum) {
        this.curriculum = curriculum;
    }

    public Calendar getStart_date() {
        return start_date;
    }

    public void setStart_date(Calendar start_date) {
        this.start_date = start_date;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
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
            System.out.println(c.getCourseInfo());
        }
    }

    public int getSummaryDurationOfCourses() {
        int coursesDuration = 0;
        for (Course c : courses) {
            coursesDuration += c.getDuration();
        }
        return coursesDuration;
    }

    public Date getEndOfCoursesDate() {
        Calendar tempCalendar = new GregorianCalendar();
        tempCalendar.set(Calendar.YEAR, start_date.get(Calendar.YEAR));
        tempCalendar.set(Calendar.MONTH, start_date.get(Calendar.MONTH));
        tempCalendar.set(Calendar.DAY_OF_MONTH, start_date.get(Calendar.DAY_OF_MONTH));
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

    public void getAllInfo() {
        System.out.println(getName() + "\n" + getCurriculum().getCURRICULUM() +
                "\nStart date: " + getStart_date().getTime() +
                "\nWork time: From " + getWorkTimeFrom() + " to " + getWorkTimeTo() +
                "\nTotal duration of all courses (hours): " + getSummaryDurationOfCourses() +
                "\nApproximate end time of courses: " + getEndOfCourseDate() +
                "\nCourses of " + getName() + ":");
        getAllCourses();
    }
}
