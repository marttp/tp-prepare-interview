const BinarySearchTree = require('./BinarySearchTree');

const tree = new BinarySearchTree();
tree.insert(9);
tree.insert(4);
tree.insert(6);
tree.insert(20);
tree.insert(170);
tree.insert(15);
tree.insert(1);

// ! Traverse by Andrea
// JSON.stringify(traverse(tree.root))

// function traverse(node) {
//   const tree = { value: node.value };
//   tree.left = node.left === null ? null : traverse(node.left);
//   tree.right = node.right === null ? null : traverse(node.right);
//   return tree;
// }


// ! Traverse by Me
traverse(tree.root, 'infix');
// console.log(JSON.stringify(tree.lookup(30)));

function traverse(node, traverseOptions = 'postfix') {
  if (node) {
    const { value } = node;
    switch (traverseOptions) {
      case 'prefix':
        console.log(JSON.stringify(value));
        traverse(node.left, traverseOptions);
        traverse(node.right, traverseOptions);
        break;
      case 'infix':
        traverse(node.left, traverseOptions);
        console.log(JSON.stringify(value));
        traverse(node.right, traverseOptions);
        break;
      case 'postfix':
      default:
        traverse(node.left, traverseOptions);
        traverse(node.right, traverseOptions);
        console.log(JSON.stringify(value));
        break;
    }
  }
}