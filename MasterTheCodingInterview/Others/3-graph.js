/* Graphs: Breadth-first search */

const bfs = (graph, root) => {
  let nodesLen = {};

  for (let i = 0; i < graph.length; i++) {
    nodesLen[i] = Infinity;
  }
  nodesLen[root] = 0;

  let queue = [root];
  let current;

  while (queue.length != 0) {
    current = queue.shift();

    let curConnected = graph[current];
    let neighborIdx = [];
    let idx = curConnected.indexOf(1);
    while (idx != -1) {
      neighborIdx.push(idx);
      idx = curConnected.indexOf(1, idx + 1);
    }

    for (let j = 0; j < neighborIdx.length; j++) {
      if (nodesLen[neighborIdx[j]] == Infinity) {
        nodesLen[neighborIdx[j]] = nodesLen[current] + 1;
        queue.push(neighborIdx[j]);
      }
    }
  }
  return nodesLen;
}

const exBFSGraph = [
  [0, 1, 1, 1, 0], // A
  [0, 0, 1, 0, 0], // B
  [1, 1, 0, 0, 0], // C
  [0, 0, 0, 1, 0], // D
  [0, 1, 0, 0, 0] // E
];
console.log(bfs(exBFSGraph, 1));
