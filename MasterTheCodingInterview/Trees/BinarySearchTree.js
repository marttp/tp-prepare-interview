const Node = require('./Node');

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
  remove(value) {
    if (this.root === null || this.root === undefined) {
      return null;
    }

    let currentNode = this.root;
    let parentNode = null;

    while (currentNode) {
      if (value < currentNode.value) {
        parentNode = currentNode;
        currentNode = currentNode.left;
      } else if (value > currentNode.value) {
        parentNode = currentNode;
        currentNode = currentNode.right;
      } else if (value === currentNode.value) {
        // * No right child
        if (currentNode.right === null) {
          // * In this case: working on left node
          if (parentNode === null) {
            this.root = currentNode.left;
          } else {
            if (parentNode.value > currentNode.value) {
              // if parent > current value, make current left child a child of parent
              parentNode.left = currentNode.left;
            } else if (parentNode.value < currentNode.value) {
              // if parent < current value, make left child a right child of parent
              parentNode.right = currentNode.left;
            }
          }
        } else if (currentNode.right.left === null) {
          // * Right child doesn't have left child
          // * In this case: working on the right of right node
          currentNode.right.left = currentNode.left;
          if (parentNode === null) {
            this.root = currentNode.right;
          } else {
            //if parent > current, make right child of the left the parent
            if (currentNode.value < parentNode.value) {
              parentNode.left = currentNode.right;
              //if parent < current, make right child a right child of the parent
            } else if (currentNode.value > parentNode.value) {
              parentNode.right = currentNode.right;
            }
          }
        } else {
          // * Right child  have left child
          // * In this case: working on the left of right node
          //find the Right child's left most child
          let leftmost = currentNode.right.left;
          let leftmostParent = currentNode.right;
          while (leftmost.left !== null) {
            leftmostParent = leftmost;
            leftmost = leftmost.left;
          }

          //Parent's left subtree is now leftmost's right subtree
          leftmostParent.left = leftmost.right;
          leftmost.left = currentNode.left;
          leftmost.right = currentNode.right;

          if (parentNode === null) {
            this.root = leftmost;
          } else {
            if (currentNode.value < parentNode.value) {
              parentNode.left = leftmost;
            } else if (currentNode.value > parentNode.value) {
              parentNode.right = leftmost;
            }
          }
        }
        return true;
      }
    }
    console.log(`${value} not found in BST`);
    return null;
  }
}

module.exports = BinarySearchTree;
