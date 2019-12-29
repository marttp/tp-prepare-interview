const Trie = require('./Trie');

// Keys for create Trie
const keys = ['the', 'a', 'there', 'answer', 'any', 'by', 'bye', 'their'];
// const keys = ['the'];

const trie = new Trie();

for (let i = 0; i < keys.length; i++) {
  const word = keys[i];
  trie.insert(word.toLowerCase());
}

const testInput = ['the', 'these', 'their', 'thaw'];
// const testInput = ['the'];

testInput.forEach(input => {
  const isExist = trie.search(input.toLowerCase());
  if (isExist) {
    console.log(`[${input}] is in trie.`);
  } else {
    console.log(`[${input}] isn't in trie.`);
  }
});
