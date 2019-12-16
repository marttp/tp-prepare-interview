// Log all pairs of array
const boxes = ['😊', '😢', '🤔', '😜', '😄'];

function logAllPairsOfArray(array) {
  console.time('logAllPairsOfArray');
  for (let i = 0; i < array.length; i++) { // n
    for (let j = 0; j < array.length; i++) { // n^2
      console.log(array[i], array[j]); // n^2
    }
  }
  console.timeEnd('logAllPairsOfArray');
}

// O(2n^2 + n)
logAllPairsOfArray(boxes);
