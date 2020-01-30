package com.training.integerlinkedlist;

public class IntegerNode {
    private Integer value;
    private IntegerNode next;

    public IntegerNode(Integer value) {
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public void setNext(IntegerNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }
    public IntegerNode getNext() {
        return next;
    }

    public String toString() {
        return value.toString();
    }
}
