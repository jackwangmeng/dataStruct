package com.wm.leecodes.employmanage;

import java.util.Random;

/**
 * @author wm
 * @Package com.wm.leecode.employmanage
 * @date 2020/9/1 16:18
 */
public class EmployeeTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 7500, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker",50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for (Employee e : staff){
            e.raiseSalry(5);
        }

        for (Employee e : staff){
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="+e.getHireDay());
        }

        Employee e = new Employee();
        Class cl = e.getClass();
        System.out.println(cl.getName());

        Random generator = new Random();
        Class cla = generator.getClass();
        String name = cla.getName();
        System.out.println(name);

        String className = "java.util.Random";
        Class clas = Class.forName(className);
    }
}
