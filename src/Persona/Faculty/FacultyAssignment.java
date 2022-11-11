/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.Faculty;

import CourseSchedule.CourseOffer;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    double traceRating;
    CourseOffer courseOffer;
    FacultyProfile facultyProfile;

    public FacultyAssignment(FacultyProfile fp, CourseOffer co) {
        courseOffer = co;
        facultyProfile = fp;
    }

    public double getRating() {
        return traceRating;
    }

    public void seProfRating(double r) {
        traceRating = r;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public void printCourseInformation(){
        courseOffer.printCourseInformation();
    }

}
