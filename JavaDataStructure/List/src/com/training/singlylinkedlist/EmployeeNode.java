package com.training.singlylinkedlist;

import com.training.Employee;

public class EmployeeNode {

    /**
     * Linked List
     * each node has data, next pointer
     */
    private Employee employee;
    private EmployeeNode next;


    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public String toString() {
        return employee.toString();
    }
}
