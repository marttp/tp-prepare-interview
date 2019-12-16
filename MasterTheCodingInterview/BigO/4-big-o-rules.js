function printFirstItemThenFirstHalfThenSayHi100Times(items) {
    console.log(items[0]); // 1

    // amount of items / 2
    var middleIndex = Math.floor(items.length / 2);
    var index = 0;

    // O(n/2) -> First half
    while (index < middleIndex) {
        console.log(items[index]);
        index++;
    }

    // O(100) Because not upon variable
    for (var i = 0; i < 100; i++) {
        console.log('hi');
    }
}



