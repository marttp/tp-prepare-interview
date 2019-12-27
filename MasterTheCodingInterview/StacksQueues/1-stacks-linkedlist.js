class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Stack {
  constructor() {
    this.bottom = null;
    this.top = null;
    this.length = 0;
  }

  peek() {
    return this.top;
  }

  push(value) {
    const newNode = new Node(value);
    if (this.length === 0) {
      this.top = newNode;
      this.bottom = newNode;
    } else {
      // If the value to the top
      // make direction to before level
      const holdingPointer = this.top;
      this.top = newNode;
      this.top.next = holdingPointer;
    }
    this.length++;
    return this;
  }

  pop() {
    if (!this.top) {
      return null;
    }
    // if (this.length === 1) {
    //   this.top = null;
    //   this.bottom = null;
    // } else {
    //   this.top = this.top.next;
    // }

    // If you on top: top.next == null
    if (this.top === this.bottom) {
      this.bottom = null;
    }

    this.top = this.top.next;
    this.length--;
    return this;
  }
}

const myStack = new Stack();
myStack.push('google');
myStack.push('udemy');
// console.log(myStack.peek());
myStack.push('discord');
myStack.push('test');
myStack.push('test2');
// console.log(myStack.peek());
myStack.pop();
console.log(myStack);

myStack.pop();
console.log(myStack);

myStack.pop();
console.log(myStack);

myStack.pop();
console.log(myStack);

myStack.pop();
console.log(myStack);
