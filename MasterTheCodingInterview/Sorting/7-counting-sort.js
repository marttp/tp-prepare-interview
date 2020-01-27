const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function countingSort(array) {
  let min = 0;
  // Find max value in list
  let max = array.sort((a,b) => b - a)[0];
  let countArray = new Array(max - min + 1).fill(0);

  for (const value of array) {
    countArray[value]++;
  }

  let countAll = 0;
  for (let i = min; i <= max; i++) {
    let count = countArray[i];
    while (count > 0) {
      array[countAll++] = i;
      count--;
    }
  }
}

countingSort(numbers);
console.log(numbers);
