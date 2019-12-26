package com.training.demolists;

import com.training.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoList {
    public static void runList() {
        List<Employee> employeeList = new ArrayList<>();

        /**
         * Vector is thread safe
         * List<Employee> employeeList = new Vector<>();
         */

        Random random = new Random();
        employeeList.add(new Employee("Mart", "Test", random.nextInt()));
        employeeList.add(new Employee("Michael", "Test", 1));
        employeeList.add(new Employee("Jackson", "Test", random.nextInt()));
        employeeList.forEach(employee -> {
            System.out.println(employee.toString());
        });
//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee : employeeArray) {
//            System.out.println(employee);
//        }
        System.out.println(employeeList.contains(new Employee("Michael", "Test", 1)));
        System.out.println(employeeList.indexOf(new Employee("Michael", "Test", 1)));
    }
}
