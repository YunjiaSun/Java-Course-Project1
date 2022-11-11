/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.print.attribute.standard.MediaSize.Engineering;

import java.util.*;

import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //assign value to semester
        String spring2022 = "Spring 2022";

        // creat a object to College
        College collegeOfEngineering = new College("College of Engineering");

        // creat three objects to Department
        Department is = new Department("Information Systems");
        Department dam = new Department("Data Architecture and Management");
        Department ses = new Department("Software Engineering Systems");

        // call "founction add" to add the three departments into College
        collegeOfEngineering.addDepartment(is);
        collegeOfEngineering.addDepartment(dam);
        collegeOfEngineering.addDepartment(ses);


        // department is
        // creat 13 objects to Person ( 3 teachers 10 students )
        Person michael = is.getPersonDirectory().newPerson("101", "Michael");
        Person sunny = is.getPersonDirectory().newPerson("102", "Sunny");
        Person jasper = is.getPersonDirectory().newPerson("103", "Jasper");

        Person summer = is.getPersonDirectory().newPerson("001", "Summer");
        Person alex = is.getPersonDirectory().newPerson("002", "Alex");
        Person robin = is.getPersonDirectory().newPerson("003", "Robin");
        Person xiaoming = is.getPersonDirectory().newPerson("003", "Xiaoming");
        Person piggy = is.getPersonDirectory().newPerson("004", "Piggy");
        Person nova = is.getPersonDirectory().newPerson("005", "Nova");
        Person rocky = is.getPersonDirectory().newPerson("006","Rocky");
        Person lucy = is.getPersonDirectory().newPerson("007","Lucy");
        Person xiaohuang = is.getPersonDirectory().newPerson("008", "Xiaohuang");
        Person xiaoyang = is.getPersonDirectory().newPerson("009", "Xiaoyang");

        //creat three objects to FacultyProfile and put the three teacher into FacultyProfile
        FacultyProfile michaelTeacher = is.getFacultyDirectory().newFacultyProfile(michael);
        FacultyProfile sunnylTeacher = is.getFacultyDirectory().newFacultyProfile(sunny);
        FacultyProfile jasperTeacher = is.getFacultyDirectory().newFacultyProfile(jasper);

        //creat three objects to StudentProfile and put the ten Student into StudentProfile
        StudentProfile summerProfile = is.getStudentDirectory().newStudentProfile(summer);
        StudentProfile alexProfile = is.getStudentDirectory().newStudentProfile(alex);
        StudentProfile robinProfile = is.getStudentDirectory().newStudentProfile(robin);
        StudentProfile xiaomingProfile = is.getStudentDirectory().newStudentProfile(xiaoming);
        StudentProfile piggyProfile = is.getStudentDirectory().newStudentProfile(piggy);
        StudentProfile novaProfile = is.getStudentDirectory().newStudentProfile(nova);
        StudentProfile rockyProfile = is.getStudentDirectory().newStudentProfile(rocky);
        StudentProfile lucyProfile = is.getStudentDirectory().newStudentProfile(lucy);
        StudentProfile xiaohuangProfile = is.getStudentDirectory().newStudentProfile(xiaohuang);
        StudentProfile xiaoyangProfile = is.getStudentDirectory().newStudentProfile(xiaoyang);

        //creat a object to CourseSchedule and build the relationship with the department
        CourseSchedule isSpring2022 = is.newCourseSchedule(spring2022);

        //creat three objects to Course and build the relationship with CourseCatelog&Department
        Course info5100 = is.getCourseCatalog().newCourse("App Eng", "info 5100", 4);
        Course info7390 = is.getCourseCatalog().newCourse("Data Science", "info 7390", 4);
        Course info6350 = is.getCourseCatalog().newCourse("Web Development", "info 6350", 4);

        //creat three objects to CourseOffer and build the relationship with CourseSchedule
        CourseOffer offerInfor5100 = isSpring2022.newCourseOffer(info5100.getCourseNumber());
        CourseOffer offerInfor7390 = isSpring2022.newCourseOffer(info7390.getCourseNumber());
        CourseOffer offerInfor6350 = isSpring2022.newCourseOffer(info6350.getCourseNumber());

        //teacher and CourseOffer have 1 to 1 relationship so need to assign twice
        offerInfor5100.AssignAsTeacher(michaelTeacher);
        michaelTeacher.AssignAsTeacher(offerInfor5100);

        offerInfor7390.AssignAsTeacher(sunnylTeacher);
        sunnylTeacher.AssignAsTeacher(offerInfor7390);

        offerInfor6350.AssignAsTeacher(jasperTeacher);
        jasperTeacher.AssignAsTeacher(offerInfor6350);

        //creat a arraylist to CourseOffer
        ArrayList<CourseOffer> isCourseOffers = new ArrayList<>();

        //add the three courses to arraylist
        isCourseOffers.add(offerInfor5100);
        isCourseOffers.add(offerInfor7390);
        isCourseOffers.add(offerInfor6350);

        for (CourseOffer courseOffer: isCourseOffers) {
            if (courseOffer == null) {
                continue;
            }


            courseOffer.generatSeats(10);

            //creat objects to CourseLoad and build the relationship with StudentProfile
            CourseLoad summerCourseLoad = summerProfile.newCourseLoad(spring2022);
            CourseLoad alexCourseLoad = alexProfile.newCourseLoad(spring2022);
            CourseLoad robinCourseload = robinProfile.newCourseLoad(spring2022);
            CourseLoad xiaomingCourseload = xiaomingProfile.newCourseLoad(spring2022);
            CourseLoad piggyCourseload = piggyProfile.newCourseLoad(spring2022);
            CourseLoad novaCourseload = novaProfile.newCourseLoad(spring2022);
            CourseLoad rockyCourseload = rockyProfile.newCourseLoad(spring2022);
            CourseLoad lucyCourseload = lucyProfile.newCourseLoad(spring2022);
            CourseLoad xiaohuangCourseload = xiaohuangProfile.newCourseLoad(spring2022);
            CourseLoad xiaoyangCourseload = xiaoyangProfile.newCourseLoad(spring2022);

            //register student in class
            summerCourseLoad.newSeatAssignment(courseOffer);
            alexCourseLoad.newSeatAssignment(courseOffer);
            robinCourseload.newSeatAssignment(courseOffer);
            xiaomingCourseload.newSeatAssignment(courseOffer);
            piggyCourseload.newSeatAssignment(courseOffer);
            novaCourseload.newSeatAssignment(courseOffer);
            rockyCourseload.newSeatAssignment(courseOffer);
            lucyCourseload.newSeatAssignment(courseOffer);
            xiaohuangCourseload.newSeatAssignment(courseOffer);
            xiaoyangCourseload.newSeatAssignment(courseOffer);
        }

        // department dam
        Person felix = dam.getPersonDirectory().newPerson("104", "Felix");
        Person amber = dam.getPersonDirectory().newPerson("105", "Amber");
        Person luna = dam.getPersonDirectory().newPerson("106", "Luna");
        FacultyProfile felixTeacher = dam.getFacultyDirectory().newFacultyProfile(felix);
        FacultyProfile amberTeacher = dam.getFacultyDirectory().newFacultyProfile(amber);
        FacultyProfile lunaTeacher = dam.getFacultyDirectory().newFacultyProfile(luna);

        Person xiaozhu = dam.getPersonDirectory().newPerson("010", "Xiaozhu");
        Person yangyang = dam.getPersonDirectory().newPerson("011", "Yangyang");
        Person zhuzhu = dam.getPersonDirectory().newPerson("012", "Zhuzhu");
        Person lily = dam.getPersonDirectory().newPerson("013", "Lily");
        Person joy = dam.getPersonDirectory().newPerson("014", "Joy");
        Person joe = dam.getPersonDirectory().newPerson("015", "Joe");
        Person leo = dam.getPersonDirectory().newPerson("016", "Leo");
        Person ross = dam.getPersonDirectory().newPerson("017", "Ross");
        Person apple= dam.getPersonDirectory().newPerson("019", "Apple");
        Person anna = dam.getPersonDirectory().newPerson("020", "Anna");

        StudentProfile xiaozhuProfile = dam.getStudentDirectory().newStudentProfile(xiaozhu);
        StudentProfile yangyangProfile = dam.getStudentDirectory().newStudentProfile(yangyang);
        StudentProfile zhuzhuProfile = dam.getStudentDirectory().newStudentProfile(zhuzhu);
        StudentProfile lilyProfile = dam.getStudentDirectory().newStudentProfile(lily);
        StudentProfile joyProfile = dam.getStudentDirectory().newStudentProfile(joy);
        StudentProfile joeProfile = dam.getStudentDirectory().newStudentProfile(joe);
        StudentProfile leoProfile = dam.getStudentDirectory().newStudentProfile(leo);
        StudentProfile rossProfile = dam.getStudentDirectory().newStudentProfile(ross);
        StudentProfile appleProfile = dam.getStudentDirectory().newStudentProfile(apple);
        StudentProfile annaProfile = dam.getStudentDirectory().newStudentProfile(anna);

        CourseSchedule damSpring2022 = dam.newCourseSchedule(spring2022);

        Course damg7245 = dam.getCourseCatalog().newCourse("Big-Data Systems and Intelligence Analytics", "DAMG 7245", 4);
        Course damg7275 = dam.getCourseCatalog().newCourse("Advanced Database Management Systems", "DAMG 7275", 4);
        Course damg7350 = dam.getCourseCatalog().newCourse("Systems and Cybersecurity Fundamentals", "DAMG 7350", 4);

        CourseOffer offerDamg7245 = damSpring2022.newCourseOffer(damg7245.getCourseNumber());
        CourseOffer offerDamg7275 = damSpring2022.newCourseOffer(damg7275.getCourseNumber());
        CourseOffer offerDamg7350 = damSpring2022.newCourseOffer(damg7350.getCourseNumber());

        offerDamg7245.AssignAsTeacher(felixTeacher);
        felixTeacher.AssignAsTeacher(offerDamg7245);

        offerDamg7275.AssignAsTeacher(amberTeacher);
        amberTeacher.AssignAsTeacher(offerDamg7275);

        offerDamg7350.AssignAsTeacher(lunaTeacher);
        lunaTeacher.AssignAsTeacher(offerDamg7350);

        ArrayList<CourseOffer> damgCourseOffers = new ArrayList<>();

        damgCourseOffers.add(offerDamg7245);
        damgCourseOffers.add(offerDamg7275);
        damgCourseOffers.add(offerDamg7350);

        for (CourseOffer courseOffer: damgCourseOffers) {
            if (courseOffer == null) return;
            courseOffer.generatSeats(10);

            CourseLoad xiaozhuCourseLoad = xiaozhuProfile.newCourseLoad(spring2022);
            CourseLoad yangyangCourseLoad = yangyangProfile.newCourseLoad(spring2022);
            CourseLoad zhuzhuCourseload = zhuzhuProfile.newCourseLoad(spring2022);
            CourseLoad lilyCourseload = lilyProfile.newCourseLoad(spring2022);
            CourseLoad joyCourseload = joyProfile.newCourseLoad(spring2022);
            CourseLoad joeCourseload = joeProfile.newCourseLoad(spring2022);
            CourseLoad leoCourseload = leoProfile.newCourseLoad(spring2022);
            CourseLoad rossCourseload = rossProfile.newCourseLoad(spring2022);
            CourseLoad appleCourseload = appleProfile.newCourseLoad(spring2022);
            CourseLoad annaCourseload = annaProfile.newCourseLoad(spring2022);

            xiaozhuCourseLoad.newSeatAssignment(courseOffer); //register student in class
            yangyangCourseLoad.newSeatAssignment(courseOffer);
            zhuzhuCourseload.newSeatAssignment(courseOffer);
            lilyCourseload.newSeatAssignment(courseOffer);
            joyCourseload.newSeatAssignment(courseOffer);
            joeCourseload.newSeatAssignment(courseOffer);
            leoCourseload.newSeatAssignment(courseOffer);
            rossCourseload.newSeatAssignment(courseOffer);
            appleCourseload.newSeatAssignment(courseOffer);
            annaCourseload.newSeatAssignment(courseOffer);
        }


        // department ses
        Person dora = ses.getPersonDirectory().newPerson("107", "Dora");
        Person orange = ses.getPersonDirectory().newPerson("108", "Orange");
        Person bob = ses.getPersonDirectory().newPerson("109", "Bob");
        FacultyProfile doraTeacher = ses.getFacultyDirectory().newFacultyProfile(dora);
        FacultyProfile orangeTeacher = ses.getFacultyDirectory().newFacultyProfile(orange);
        FacultyProfile bobTeacher = ses.getFacultyDirectory().newFacultyProfile(bob);

        Person ann = ses.getPersonDirectory().newPerson("021", "Ann");
        Person jan = ses.getPersonDirectory().newPerson("022", "Jan");
        Person joanne = ses.getPersonDirectory().newPerson("023", "Joanne");
        Person joanna = ses.getPersonDirectory().newPerson("024", "Joanna");
        Person mingming = ses.getPersonDirectory().newPerson("025", "Mingming");
        Person nana = ses.getPersonDirectory().newPerson("026", "Nana");
        Person tina = ses.getPersonDirectory().newPerson("027", "Tina");
        Person tony = ses.getPersonDirectory().newPerson("028", "Tony");
        Person zoe = ses.getPersonDirectory().newPerson("029", "Zoe");
        Person qing = ses.getPersonDirectory().newPerson("030", "Qing");

        StudentProfile annProfile = ses.getStudentDirectory().newStudentProfile(ann);
        StudentProfile janProfile = ses.getStudentDirectory().newStudentProfile(jan);
        StudentProfile joanneProfile = ses.getStudentDirectory().newStudentProfile(joanne);
        StudentProfile joannaProfile = ses.getStudentDirectory().newStudentProfile(joanna);
        StudentProfile mingmingProfile = ses.getStudentDirectory().newStudentProfile(mingming);
        StudentProfile nanaProfile = ses.getStudentDirectory().newStudentProfile(nana);
        StudentProfile tinaProfile = ses.getStudentDirectory().newStudentProfile(tina);
        StudentProfile tonyProfile = ses.getStudentDirectory().newStudentProfile(tony);
        StudentProfile zoeProfile = ses.getStudentDirectory().newStudentProfile(zoe);
        StudentProfile qingProfile = ses.getStudentDirectory().newStudentProfile(qing);

        CourseSchedule sesSpring2022 = ses.newCourseSchedule(spring2022);

        Course damg7290 = ses.getCourseCatalog().newCourse("Data Warehousing and Business Intelligence", "DAMG 7290", 4);
        Course csye6200 = ses.getCourseCatalog().newCourse("Concepts of Object-Oriented Design", "CSYE 6200", 4);
        Course csye7200 = ses.getCourseCatalog().newCourse("Big-Data System Engineering Using Scala", "CSYE 7200", 4);

        CourseOffer offerDamg7290 = sesSpring2022.newCourseOffer(damg7290.getCourseNumber());
        CourseOffer offerCsye6200 = sesSpring2022.newCourseOffer(csye6200.getCourseNumber());
        CourseOffer offerCsye7200 = sesSpring2022.newCourseOffer(csye7200.getCourseNumber());

        offerDamg7290.AssignAsTeacher(doraTeacher);
        doraTeacher.AssignAsTeacher(offerDamg7290);

        offerCsye6200.AssignAsTeacher(orangeTeacher);
        orangeTeacher.AssignAsTeacher(offerCsye6200);

        offerCsye7200.AssignAsTeacher(bobTeacher);
        bobTeacher.AssignAsTeacher(offerCsye7200);

        ArrayList<CourseOffer> sesCourseOffers = new ArrayList<>();

        sesCourseOffers.add(offerDamg7290);
        sesCourseOffers.add(offerCsye6200);
        sesCourseOffers.add(offerCsye7200);

        for (CourseOffer courseOffer: sesCourseOffers) {
            if (courseOffer == null) return;
            courseOffer.generatSeats(10);

            CourseLoad annCourseLoad = annProfile.newCourseLoad(spring2022);
            CourseLoad janCourseLoad = janProfile.newCourseLoad(spring2022);
            CourseLoad joanneCourseload = joanneProfile.newCourseLoad(spring2022);
            CourseLoad joannaCourseload = joannaProfile.newCourseLoad(spring2022);
            CourseLoad mingmingCourseload = mingmingProfile.newCourseLoad(spring2022);
            CourseLoad nanaCourseload = nanaProfile.newCourseLoad(spring2022);
            CourseLoad tinaCourseload = tinaProfile.newCourseLoad(spring2022);
            CourseLoad tonyCourseload = tonyProfile.newCourseLoad(spring2022);
            CourseLoad zoeCourseload = zoeProfile.newCourseLoad(spring2022);
            CourseLoad qingCourseload = qingProfile.newCourseLoad(spring2022);

            annCourseLoad.newSeatAssignment(courseOffer); //register student in class
            janCourseLoad.newSeatAssignment(courseOffer);
            joanneCourseload.newSeatAssignment(courseOffer);
            joannaCourseload.newSeatAssignment(courseOffer);
            mingmingCourseload.newSeatAssignment(courseOffer);
            nanaCourseload.newSeatAssignment(courseOffer);
            tinaCourseload.newSeatAssignment(courseOffer);
            tonyCourseload.newSeatAssignment(courseOffer);
            zoeCourseload.newSeatAssignment(courseOffer);
            qingCourseload.newSeatAssignment(courseOffer);
        }

        //is calculate revenues
        int isTotal = is.calculateRevenuesBySemester(spring2022);
        System.out.println("Total for IS: " + isTotal);

        //dam calculate revenues
        int DamTotal = dam.calculateRevenuesBySemester(spring2022);
        System.out.println("Total for DAMG: " + DamTotal);

        //ses calculate revenues
        int sesTotal = ses.calculateRevenuesBySemester(spring2022);
        System.out.println("Total for SES: " + sesTotal);

        //college print out the revenues by table
        collegeOfEngineering.printRevenueByDepartment(spring2022);

        is.printDepartmentInfo();


    }
}
