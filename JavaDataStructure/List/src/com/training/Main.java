package com.training;

import com.training.doublylinkedlist.EmployeeDoublyLinkedList;
import com.training.integerlinkedlist.IntegerLinkedList;
import com.training.singlylinkedlist.EmployeeLinkedList;

public class Main {

    public static void main(String[] args) {
//        DemoList.runList();
//        runSinglyLinkedList();
//        runDoublyLinkedList();
        runIntegerLinkedList();
    }

    private static void runSinglyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.getSize());

        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }

    private static void runDoublyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();
        System.out.println(list.getSize());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        list.printList();
        System.out.println(list.getSize());
        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());
        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());
    }

    private static void runIntegerLinkedList() {
        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(3);
        list.printList();
        list.insertSorted(2);
        list.printList();
        list.insertSorted(1);
        list.printList();
        list.insertSorted(4);
        list.printList();
    }
}
