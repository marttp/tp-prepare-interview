// Naive
function hasPairWithSum(arr, sum) {
  var len = arr.length;
  // It's take O(n^2)
  for (var i = 0; i < len - 1; i++) {
    for (var j = i + 1; j < len; j++) {
      if (arr[i] + arr[j] === sum) return true;
    }
  }
  return false;
}

// Better
function hasPairWithSum2(arr, sum) {
    // Create set for store unique value
  const mySet = new Set();
  // Make iterable : looping over the array
  for (const value of arr) {
      // If has any value will break the loop and return result
    if (mySet.has(value)) {
      return true;
    }
    // Calculate on the different value because the first try lower than the sum result
    // because of that. Just find the difference of sum and element
    // store the diffValue and find the next index
    const diffValue = sum - value;
    mySet.add(diffValue);
  }
  return false;
}

hasPairWithSum2([6, 4, 3, 2, 1, 7], 9);
