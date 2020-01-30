/* Trie */

class Node {
  constructor() {
    this.keys = new Map();
    this.end = false;
  }
  setEnd() {
    this.end = true;
  }
  isEnd() {
    return this.end;
  }
}

class Trie {
  constructor() {
    this.root = new Node();
  }

  add(input, node = this.root) {
    if (input.length == 0) {
      // Set the last element node as End node
      node.setEnd();
      return;
    } else if (!node.keys.has(input[0])) {
      // Set the key
      // Then remove first element for recursive
      // Slide to next node
      node.keys.set(input[0], new Node());
      return this.add(input.substr(1), node.keys.get(input[0]));
    } else {
      // Then remove first element for recursive
      // Slide to next node
      return this.add(input.substr(1), node.keys.get(input[0]));
    }
  }

  isContainWord(word) {
    let node = this.root;
    while (word.length > 1) {
      if (!node.keys.has(word[0])) {
        return false;
      } else {
        node = node.keys.get(word[0]);
        // Remove 1 character each loop
        word = word.substr(1);
      }
    }
    return node.keys.has(word) && node.keys.get(word).isEnd() ? true : false;
  }

  print() {
    let words = new Array();
    this.search(words, this.root, new String());
    return words.length > 0 ? words : [];
  }

  search(wordArray, node, string) {
    if (node.keys.size !== 0) {
      for (let letter of node.keys.keys()) {
        // Slide to next letter node. with new string
        this.search(wordArray, node.keys.get(letter), string.concat(letter));
      }
      if (node.isEnd()) {
        // If end of word. Push it to array
        wordArray.push(string);
      }
    } else {
      // ! If search in the root not any children. got undefined.
      string.length > 0 ? wordArray.push(string) : undefined;
      return;
    }
  }
}

myTrie = new Trie();
myTrie.add("ball");
myTrie.add("bat");
myTrie.add("doll");
myTrie.add("dork");
myTrie.add("do");
myTrie.add("dorm");
myTrie.add("send");
myTrie.add("sense");
console.log(myTrie.isContainWord("doll"));
console.log(myTrie.isContainWord("dor"));
console.log(myTrie.isContainWord("dorf"));
console.log(myTrie.print());
