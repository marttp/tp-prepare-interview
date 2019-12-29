class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  insert(value) {
    //Code here
    if (this.root === null || this.root === undefined) {
      this.root = new Node(value);
    } else {
      let currentNode = this.root;
      while (true) {
        if (value < currentNode.value) {
          if (!currentNode.left) {
            currentNode.left = new Node(value);
            return;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if (!currentNode.right) {
            currentNode.right = new Node(value);
            return;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
  }

  lookup(value) {
    if (this.root === null || this.root === undefined) {
      return null;
    }
    let currentNode = this.root;
    while (currentNode) {
      if (currentNode.value === value) {
        console.log(`found data`);
        return currentNode;
      } else if (value < currentNode.value) {
        currentNode = currentNode.left;
      } else if (value > currentNode.value) {
        currentNode = currentNode.right;
      }
    }
    console.log(`${value} not found in BST`);
    return null;
  }

  // remove
}

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
// traverse(tree.root, 'infix');
console.log(JSON.stringify(tree.lookup(30)));

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