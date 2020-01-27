const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

let digit = 0;
const max = numbers.sort((a, b) => b - a)[0];

function findMaxDigit(number) {
  if (number === 0) {
    return number;
  }
  return 1 + findMaxDigit(parseInt(number / 10));
}

function radixSort(array, radix, digit) {
  for (let i = 0; i < digit; i++) {
    radixSingleSort(array, i, radix);
  }
}

function radixSingleSort(array, position, radix) {
  let numItems = array.length;
  let countArray = new Array(radix).fill(0);

  array.forEach(value => {
    countArray[getDigit(position, value, radix)]++;
  });

  console.log(countArray);

  // Count all of it
  for (let j = 1; j < radix; j++) {
    countArray[j] += countArray[j - 1];
  }

  let tmp = new Array(numItems).fill(0);
  for (let tmpIndex = numItems - 1; tmpIndex >= 0; tmpIndex--) {
    let digit = getDigit(position, array[tmpIndex], radix);
    let index = --countArray[digit];
    tmp[index] = array[tmpIndex];
  }

  for (let tmpIndex = 0; tmpIndex < numItems; tmpIndex++) {
    array[tmpIndex] = tmp[tmpIndex];
  }
}

function getDigit(position, value, radix) {
  return parseInt(value / Math.pow(radix, position) % radix);
}

radixSort(numbers, 10, findMaxDigit(max));
console.log(numbers);
