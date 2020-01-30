class HashTable {
  constructor(size) {
    this.data = new Array(size);
  }

  // Implement hash function to get an address to store the value
  _hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash = (hash + key.charCodeAt(i) * i) % this.data.length;
    }
    return hash;
  }

  // Store value to array hash table
  set(key, value) {
    const address = this._hash(key);
    if (!this.data[address] || !this.data[address].length) {
      this.data[address] = [];
    }
    this.data[address].push([key, value]);
    return this.data;
  }

  get(key) {
    const address = this._hash(key);
    const bucket = this.data[address];
    if (bucket) {
      // For-of will make iterable on each value in bucket
      // Because hash map can collision and solve it with concat the array at the same address
      for (const bucketValue of bucket) {
        if (bucketValue[0] === key) {
          return bucketValue[1];
        }
      }
    }
    return undefined;
  }

  keys() {
    const keysArray = [];
    for (const bucket of this.data) {
      if (bucket) {
        keysArray.push(bucket[0][0]);
      }
    }
    return keysArray;
  }
}

const myHashTable = new HashTable(50);
myHashTable.set('grapes', 10000);
const firstData = myHashTable.get('grapes');
myHashTable.set('apples', 9);
const secondData = myHashTable.get('apples');
console.log(firstData, secondData);

const keyList = myHashTable.keys();
console.log(keyList);
