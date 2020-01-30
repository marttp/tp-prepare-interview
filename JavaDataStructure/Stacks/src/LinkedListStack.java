import java.util.LinkedList;

public class LinkedListStack {
    private LinkedList<Employee> stack;

    public LinkedListStack() {
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        for (Employee employee : stack) {
            System.out.println(employee);
        }
    }
}
