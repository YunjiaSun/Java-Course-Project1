/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    String name;
    ArrayList<Department> departments;
    
    public College(String name) {
        this.name = name;
        departments = new ArrayList<Department>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void printRevenueByDepartment(String semester) { 
        System.out.println("The total revenue for college " + name + " for each college is: ");
        for (Department department: departments) {
            System.out.println("Department " + department.getName() + ": " + department.calculateRevenuesBySemester(semester));
        }
    }
}
