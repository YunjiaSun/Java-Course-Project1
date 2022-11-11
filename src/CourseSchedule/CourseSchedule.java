/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {
    CourseCatalog courseCatalog;
    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        courseCatalog = cc;
        schedule = new ArrayList<CourseOffer>();
    }

    public CourseOffer newCourseOffer(String n) {
        Course c = courseCatalog.getCourseByNumber(n);
        if (c == null)
            return null;
        CourseOffer co;
        co = new CourseOffer(c,this);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {
            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        // how many courses will be offered
        for (CourseOffer co : schedule) {
            sum = sum + co.getTotalCourseRevenues();
        }
        return sum;
    }

    public String getSemester(){
        return semester;
    }

}
