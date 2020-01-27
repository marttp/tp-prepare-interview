function reverse(str) {
    if (!str || typeof str !== 'string' || str.length < 2 ) {
       return str;
    }
    
    const strSplit = str.split('');
    const data = [];

    for (let index = strSplit.length - 1; index >= 0; index--) {
        data.push(strSplit[index]);
    }

    return data.join('');
}

function reverseShort(str) {
    return str.split('').reverse().join('');
}
// const reverseShort = (str) => str.split('').reverse().join('');

function reverseShorter(str) {
    // Because string type is the "array of characters"
    return [...str].reverse().join('');
}
// const reverseShorter = (str) => [...str].reverse().join('');

let name = 'Thanaphoom Babparn';
const nameReverse = reverse(name);
console.log(nameReverse);