/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseCatalog;

import Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    Department department;
    String lastUpdated;
    ArrayList<Course> courseList;

    public CourseCatalog(Department d) {
        courseList = new ArrayList<Course>();
        department = d;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public Course newCourse(String n, String nm, int cr) {
        Course c = new Course(n, nm, cr);
        courseList.add(c);
        return c;
    }

    public Course getCourseByNumber(String n) {
        for (Course c : courseList) {
            if (c.getCourseNumber().equals(n))
                return c;
        }
        return null;
    }

    public void printCourseCatalog() {
        for (Course c : courseList) {
            c.printCourseInformation();
        }
    }
}