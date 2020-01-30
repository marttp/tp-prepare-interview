package array;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        this.queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (this.back == this.queue.length) {
            Employee[] newArray = new Employee[2 * this.queue.length];
            System.arraycopy(this.queue, 0, newArray, 0, this.queue.length);
            this.queue = newArray;
        }
        this.queue[this.back] = employee;
        this.back++;
    }

    public Employee remove() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        // Get
        Employee employee = this.queue[this.front];
        // Delete
        this.queue[this.front] = null;
        this.front++;
        // Reset index when queue empty
        if (this.size() == 0) {
            this.front = 0;
            this.back = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return this.queue[this.front];
        }
    }

    public int size() {
        return this.back - this.front;
    }

    public void printQueue() {
        for(int i = this.front; i < this.back; ++i) {
            System.out.println(this.queue[i]);
        }

    }
}
