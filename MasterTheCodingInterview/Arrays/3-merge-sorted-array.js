// Assume the all of arrays already sorted.
function mergeSortedArray(array1, array2) {
  if (!Array.isArray(array1) || !Array.isArray(array2)) {
    throw new Error('Some parameter is not an array');
  }

  if (!array1.length) {
    return array2;
  }

  if (!array2.length) {
    return array1;
  }

  const mergeArray = [];
  let pairIndex = [0, 0];
  let array1Item = array1[pairIndex[0]];
  let array2Item = array2[pairIndex[1]];

  while (array1Item || array2Item) {
    if (array1Item < array2Item || (array1Item && !array2Item)) {
      mergeArray.push(array1Item);
      pairIndex[0]++;
      array1Item = array1[pairIndex[0]];
    } else {
      mergeArray.push(array2Item);
      pairIndex[1]++;
      array2Item = array2[pairIndex[1]];
    }
  }

  if (!array2Item && pairIndex[0] < array1.length - 1) {
    const list = array1.slice(pairIndex[0], array1.length);
    mergeArray.push(...list);
  }

  if (!array1Item && pairIndex[1] < array2.length - 1) {
    const list = array2.slice(pairIndex[1], array2.length);
    mergeArray.push(...list);
  }

  return mergeArray;
}

const result = mergeSortedArray([0, 3, 4, 31], [4, 6, 30]);
// const result = mergeSortedArray([0, 3, 4, 31], [2, 6, 24]);
// const result = mergeSortedArray([0, 3, 4, 31], [2]);
// const result = mergeSortedArray([0, 3, 4], [2, 6, 24]);
console.log(result);
