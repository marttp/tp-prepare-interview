const { NodeForDoubly: Node } = require('./Node');

class DoublyLinkedList {
  constructor(value) {
    this.head = new Node(value);
    this.tail = this.head;
    this.length = 1;
  }

  append(value) {
    const newNode = new Node(value);
    this.tail.next = newNode;
    newNode.previous = this.tail;
    this.tail = newNode;
    this.length++;
    return this;
  }

  prepend(value) {
    const newNode = new Node(value);
    newNode.next = this.head;
    this.head.previous = newNode;
    this.head = newNode;
    this.length++;
    return this;
  }

  insert(index, value) {
    if (index >= this.length) {
      return this.append(value);
    }
    const newNode = new Node(value);

    const nodePointer = this.traverseToIndex(index - 1);
    const holderNode = nodePointer.next;

    newNode.next = holderNode;
    holderNode.previous = newNode;

    nodePointer.next = newNode;
    newNode.previous = nodePointer;

    this.length++;
    return this;
  }

  traverseToIndex(index) {
    let counter = 0;
    let nodePointer = this.head;
    while (counter !== index) {
      nodePointer = nodePointer.next;
      counter++;
    }
    return nodePointer;
  }

  remove(index) {
    const nodePointer = this.traverseToIndex(index - 1);
    let deleteNode = nodePointer.next;
    nodePointer.next = deleteNode.next;
    deleteNode.next.previous = nodePointer;
    this.length--;
    return this;
  }

  getList() {
    const array = [];
    let currentNode = this.head;
    while (currentNode !== null) {
      array.push(currentNode);
      currentNode = currentNode.next;
    }
    return array;
  }
}

module.exports = DoublyLinkedList;
