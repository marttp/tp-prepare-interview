//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined

// Naive
function firstRecurringCharacter(input) {
  for (let i = 0; i < input.length; i++) {
    for (let j = 0; j < input.length; j++) {
        if (input[i] === input[j]) {
            return input[i];
        }
    }
  }
  return undefined;
}

/**
 * Andre code
 */

// function firstRecurringCharacter2(input) {
//   let map = {};
//   for (let i = 0; i < input.length; i++) {
//     if (map[input[i]] !== undefined) {
//       return input[i];
//     } else {
//       map[input[i]] = i;
//     }
//   }
//   return undefined;
// }
  

// Own Resolutions
function firstRecurringCharacterNumberTwo(input) {
    let obj = {};
    for (let i = 0; i < input.length; i++) {
        if (obj[input[i]]) {
            return input[i];
        }
        obj[input[i]] = true;
    }
    return undefined;
}

//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2

// My Solutions
function solveBonus(arr) {
  const mySet = new Set();
  for (const element of arr) {
    if (mySet.has(element)) {
      return element;
    }
    mySet.add(element);
  }
  return undefined;
}

const result = solveBonus([2,5,5,2,3,5,1,2,4])
console.log(result);