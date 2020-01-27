const { NodeForSingly: Node } = require('./Node');

class SinglyLinkedList {
  constructor(value) {
    this.head = new Node(value);
    this.tail = this.head;
    this.length = 1;
  }

  // Insert tail
  append(value) {
    //Create
    const newNode = new Node(value);

    // Connected relation
    this.tail.next = newNode;
    // then move pointer
    this.tail = newNode;
    this.length++;
    return this;
  }

  // Insert head
  prepend(value) {
    //Create
    const newNode = new Node(value);
    newNode.next = this.head;
    this.head = newNode;
    this.length++;
    return this;
  }

  insert(index, value) {
    if (index >= this.length) {
      //   throw new Error('Insert the index over current length');
      // if more than current length. just insert last.
      return this.append(value);
    }
    //Create
    const newNode = new Node(value);
    const nodePointer = this.traverseToIndex(index - 1);
    newNode.next = nodePointer.next;
    nodePointer.next = newNode;
    this.length++;
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

  traverseToIndex(index) {
    let counter = 0;
    let nodePointer = this.head;
    // Next to the index
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
    this.length--;
    return this;
  }

  // Exercise reverse()
  // Take O(2n)
  reverse() {
    const tmpArray = [];
    let currentNodeForPrepare = this.head;
    while (currentNodeForPrepare !== null) {
      tmpArray.push(currentNodeForPrepare.value);
      currentNodeForPrepare = currentNodeForPrepare.next;
    }

    // pop value to create new LinkedList
    const newHeadValue = tmpArray.pop();
    const newSinglyLinkedList = new SinglyLinkedList(newHeadValue);
    // Iterate append
    for (let index = tmpArray.length - 1; index >= 0; index--) {
      const element = tmpArray[index];
      newSinglyLinkedList.append(element);
    }

    // Reference to new LinkedList
    this.head = newSinglyLinkedList.head;
    this.tail = newSinglyLinkedList.tail;
    return this;
  }

  // Take O(n)
  // reverse() {
  //   if (!this.head.next) {
  //     return this.head;
  //   }
  //   let first = this.head;
  //   this.tail = this.head;
  //   let second = first.next;

  //   while (second) {
  //     const temp = second.next;
  //     second.next = first;
  //     first = second;
  //     second = temp;
  //   }

  //   this.head.next = null;
  //   this.head = first;
  //   return this;
  // }
}

module.exports = SinglyLinkedList;
