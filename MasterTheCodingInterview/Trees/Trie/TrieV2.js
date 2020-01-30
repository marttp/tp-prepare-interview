const TrieNodeV2 = require('./TrieNodeV2');

class TrieV2 {
  constructor() {
    this.root = new TrieNodeV2();
  }

  insert(word) {
    let pCrawl = this.root;
    for (let level = 0; level < word.length; level++) {
        const character = word[level];
        if (!pCrawl.children[character]) {
            pCrawl.children[character] = new TrieNodeV2();
        }
        pCrawl = pCrawl.children[character];
    }
    pCrawl.isEndOfWord = true;
  }

  search(word) {
    let pCrawl = this.root;
    for (let level = 0; level < word.length; level++) {
        const character = word[level];
      if (!pCrawl.children[character]) {
        return false;
      }
      pCrawl = pCrawl.children[character];
    }
    return pCrawl && pCrawl.isEndOfWord;
  }
}

module.exports = TrieV2;
