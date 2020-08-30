function converseFromBase(number, base) {
  if (base < 2 || (base > 10 && base != 16)) return -1;
  let value = 0;
  for (let i = number.length - 1; i >= 0; i--) {
    const digit = digitToValue(number[i]);
    if (isNaN(digit)|| digit < 0 || digit >= base) {
      return -1;
    }
    const exponential = number.length - 1 - i;
    value += digit * Math.pow(base, exponential);
  }
  return value;
}

function digitToValue(c) {
  switch (c.toUpperCase()) {
    case 'A':
      return 10;
    case 'B':
      return 11;
    case 'C':
      return 12;
    case 'D':
      return 13;
    case 'E':
      return 14;
    case 'F':
      return 15;
    default:
      return parseInt(c);
  }
}


console.log(converseFromBase('1001', 5));