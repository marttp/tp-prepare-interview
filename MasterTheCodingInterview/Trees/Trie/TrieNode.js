const ALPHABET_SIZE = 26;

class TrieNode {
  constructor() {
    this.isEndOfWord = false;

    let children = [];
    for (let index = 0; index < ALPHABET_SIZE; index++) {
      children.push(null);
    }

    this.children = children;
  }
}

module.exports = TrieNode;
