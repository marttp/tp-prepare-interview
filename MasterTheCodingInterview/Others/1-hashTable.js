// /* Hash Table */

class HashTable {
  constructor() {
    this.storageLimit = 14;
    this.storage = [];
  }

  hashFunction(string, maxSlot) {
    let hash = 0;
    for (let i = 0; i < string.length; i++) {
      hash += string.charCodeAt(i);
    }
    return hash % maxSlot;
  };

  print() {
    console.log(this.storage);
  }

  add(key, value) {
    let index = this.hashFunction(key, this.storageLimit);
    if (this.storage[index] === undefined) {
      this.storage[index] = [[key, value]];
    } else {
      let isInserted = false;
      for (let i = 0; i < this.storage[index].length; i++) {
        if (this.storage[index][i][0] === key) {
          this.storage[index][i][1] = value;
          isInserted = true;
        }
      }
      if (isInserted === false) {
        this.storage[index].push([key, value]);
      }
    }
  }

  remove(key) {
    let index = this.hashFunction(key, this.storageLimit);
    if (this.storage.length === 1 && this.storage[index][0][0] === key) {
      delete this.storage[index];
    } else {
      for (let i = 0; i < this.storage[index].length; i++) {
        if (this.storage[index][i][0] === key) {
          delete this.storage[index][i];
        }
      }
    }
  }

  lookup(key) {
    let index = this.hashFunction(key, this.storageLimit);
    if (this.storage[index] === undefined) {
      return undefined;
    } else {
      for (let i = 0; i < this.storage[index].length; i++) {
        if (this.storage[index][i][0] === key) {
          return this.storage[index][i][1];
        }
      }
    }
  }
}

let hashTable = new HashTable();
hashTable.add('beau', 'person');
hashTable.add('fido', 'dog');
hashTable.add('rex', 'dinosour');
hashTable.add('tux', 'penguin');
console.log(hashTable.lookup('tux'))
hashTable.print();
