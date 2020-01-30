/* Hash Table */

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

  lastIndex(array) {
    return array[array.length - 1];
  }

  add(key, value) {
    let index = this.hashFunction(key, this.storageLimit);
    if (this.storage[index] === undefined) {
      this.storage[index] = [value];
    } else {
      const valueList = this.storage[index]
      valueList.push(value)
    }
  }

  remove(key) {
    let index = this.hashFunction(key, this.storageLimit);
    if (this.storage[index]) {
      delete this.storage[index]
    }
  }

  lookup(key) {
    let index = this.hashFunction(key, this.storageLimit);
    return this.storage[index] === undefined ? undefined : this.storage[index];
  }
}

let hashTable = new HashTable();
hashTable.add('beau', 'person');
hashTable.add('fido', 'dog');
hashTable.add('rex', 'dinosour');
hashTable.add('tux', 'penguin');
console.log(hashTable.lookup('tux'))
hashTable.print();
