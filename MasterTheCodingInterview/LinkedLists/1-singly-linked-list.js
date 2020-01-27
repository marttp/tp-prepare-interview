const SinglyLinkedList = require('./SinglyLinkedList');

const myLinkedList = new SinglyLinkedList(10);
myLinkedList.append(5);
myLinkedList.append(16);
myLinkedList.prepend(1);
// myLinkedList.insert(2, 99);
// myLinkedList.remove(2);
myLinkedList.reverse();
console.log(myLinkedList.getList());
