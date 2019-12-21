const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'a'];

// This is O(n^2) We will implement it.
function findContainCommonItem(arr1, arr2) {
  for (let i = 0; i < arr1.length; i++) {
    for (let j = 0; j < arr2.length; j++) {
      if (arr1[i] === arr2[j]) {
        return true;
      }
    }
  }
  return false;
}

// Take an O(n + n) => O(n)
function findContainCommonItemImplementMapConcept(arr1, arr2) {
    // (1)
    if (arr1 && arr2 && !Array.isArray(arr1) && !Array.isArray(arr2)) {
        return false;
      }
  let map = {};
  for (let i = 0; i < arr1.length; i++) {
    if (!map[arr1[i]]) {
      map[arr1[i]] = true;
    }
  }
  for (let j = 0; j < arr2.length; j++) {
    if (map[arr2[j]]) {
      return true;
    }
  }
  return false;
}

function findContainCommonItemAlternative(arr1, arr2) {
    // (1)
  if (arr1 && arr2 && !Array.isArray(arr1) && !Array.isArray(arr2)) {
    return false;
  }
  let map = new Map();
  arr1.forEach(data => {
    if (!map.get(data)) {
      map.set(data, true);
    }
  });
  arr2.forEach(data => {
    if (map.has(data)) {
      return true;
    }
  });
  return false;
}

// But the array cannot contain the same type in some langauge
// We can add checking to parameter (1)

// Alternative use some language function for programming language
function containCommonItemWithBuiltIn(arr1, arr2) {
    return arr1.some(item => arr2.includes(item));
}
