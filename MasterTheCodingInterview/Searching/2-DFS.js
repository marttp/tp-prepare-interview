const { BinarySearchTree } = require('./core');

const tree = new BinarySearchTree();
tree.insert(9);
tree.insert(4);
tree.insert(6);
tree.insert(20);
tree.insert(170);
tree.insert(15);
tree.insert(1);

console.log("DFSpre", tree.DFTPreOrder());
console.log("DFSin", tree.DFTInOrder());
console.log("DFSpost", tree.DFTPostOrder());
