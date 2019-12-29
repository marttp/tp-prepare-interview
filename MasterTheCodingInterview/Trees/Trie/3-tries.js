const Trie = require('./Trie');
const TrieV2 = require('./TrieV2');

// Keys for create Trie
// const keys = ['the'];
const keys = ['the', 'a', 'there', 'answer', 'any', 'by', 'bye', 'their'];

const trie = new Trie();
const trieNewVersion = new TrieV2();

for (let i = 0; i < keys.length; i++) {
  if (typeof keys[i] !== 'string') {
    throw new Error('Not a string type');
  }
  const word = keys[i].toLowerCase();
  trie.insert(word);
  trieNewVersion.insert(word);
}

// const testInput = ['the'];
const testInput = ['the', 'these', 'their', 'thaw'];

console.time('trieProcess');
testInput.forEach(input => {
  if (typeof input !== 'string') {
    throw new Error('Not a string type');
  }
  const isExist = trie.search(input.toLowerCase());
  if (isExist) {
    console.log(`[${input}] is in trie.`);
  } else {
    console.log(`[${input}] isn't in trie.`);
  }
});
console.timeEnd('trieProcess');

console.log('\n\n');

console.time('trieV2Process');
testInput.forEach(input => {
  if (typeof input !== 'string') {
    throw new Error('Not a string type');
  }
  const isExist = trieNewVersion.search(input.toLowerCase());
  if (isExist) {
    console.log(`[${input}] is in trie.`);
  } else {
    console.log(`[${input}] isn't in trie.`);
  }
});
console.timeEnd('trieV2Process');
