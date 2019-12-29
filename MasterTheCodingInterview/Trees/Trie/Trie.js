const TrieNode = require('./TrieNode');

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  insert(word) {
    let index = 0;
    let pCrawl = this.root;

    for (let level = 0; level < word.length; level++) {
      // Minus 'a' is mean You take the alphabet and difference that charCode in ASCII
      index = word.charCodeAt(level) - 'a'.charCodeAt(0);
      if (pCrawl.children[index] === null) {
        pCrawl.children[index] = new TrieNode();
      }
      pCrawl = pCrawl.children[index];
    }
    // Marking last node as leaf / last character of word
    pCrawl.isEndOfWord = true;
  }

  search(word) {
    let index = 0;
    let pCrawl = this.root;
    for (let level = 0; level < word.length; level++) {
      index = word.charCodeAt(level) - 'a'.charCodeAt(0);
      if (pCrawl.children[index] === null) {
        return false;
      }
      pCrawl = pCrawl.children[index];
    }
    return pCrawl !== null && pCrawl.isEndOfWord;
  }
}

module.exports = Trie;
