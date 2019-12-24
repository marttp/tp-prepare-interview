class NodeForSingly {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class NodeForDoubly {
  constructor(value) {
    this.value = value;
    this.next = null;
    this.previous = null;
  }
}

module.exports = {
  NodeForSingly,
  NodeForDoubly
};
