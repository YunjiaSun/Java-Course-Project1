/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Degree.Degree;
import Employer.EmployerDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {
    String name;
    CourseCatalog courseCatalog;
    PersonDirectory personDirectory;
    StudentDirectory studentDirectory;
    FacultyDirectory facultyDirectory;
    EmployerDirectory employerDirectory;
    Degree degree;

    HashMap<String, CourseSchedule> masterCourseCatalog;

    public Department(String n) {
        name = n;
        masterCourseCatalog = new HashMap<String, CourseSchedule>();
        courseCatalog = new CourseCatalog(this);
        studentDirectory = new StudentDirectory(this); // pass the department object so it stays linked to it
        personDirectory = new PersonDirectory();
        facultyDirectory = new FacultyDirectory(this);
        degree = new Degree("MSIS");
    }

    public void addCoreCourse(Course c) {
        degree.addCoreCourse(c);
    }

    public void addElectiveCourse(Course c) {
        degree.addElectiveCourse(c);
    }

    public String getName() {
        return name;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentDirectory;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultyDirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {
        CourseSchedule cs = new CourseSchedule(semester, courseCatalog);
        masterCourseCatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {
        return masterCourseCatalog.get(semester);
    }

    public CourseCatalog getCourseCatalog() {
        return courseCatalog;
    }

    public Course newCourse(String n, String nm, int cr) {
        Course c = courseCatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {
        CourseSchedule css = masterCourseCatalog.get(semester);

        if (css != null)
            return css.calculateTotalRevenues();
        else
            return 0;
    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentDirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = masterCourseCatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);
    }

    public void printDepartmentInfo() {
        System.out.println(" ====== Department Information ====== ");
        System.out.println("Department " + name + " provides degree " + degree);
        System.out.println(" ====== Course Information ====== ");
        courseCatalog.printCourseCatalog();
        System.out.println(" ====== Student Information ====== ");
        studentDirectory.printStudentDirectory();
        System.out.println(" ====== Teacher Information ====== ");
        facultyDirectory.printFacultyDirectory();
    }
}
