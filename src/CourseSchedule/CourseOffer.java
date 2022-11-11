/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import Persona.Faculty.FacultyAssignment;
import Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {
    CourseSchedule courseSchedule;
    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyAssignment;

    public CourseOffer(Course c, CourseSchedule cs) {
        course = c;
        seatlist = new ArrayList<Seat>();
        courseSchedule = cs;
    }

    public void AssignAsTeacher(FacultyProfile fp) {
        facultyAssignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyAssignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    public void generatSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }
    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            // if the seat is empty,the seat will be released
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); // seat is already linked to course offer
        cl.registerStudent(sa); // coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {
        int sum = 0;
        // System.out.println(seatlist.size());
        // How many seats are occupied
        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }

    public Course getSubjectCourse() {
        return course;
    }

    public int getCreditHours() {
        return course.getCredits();
    }

    public void printCourseInformation(){
        course.printCourseInformation();
    }

}
