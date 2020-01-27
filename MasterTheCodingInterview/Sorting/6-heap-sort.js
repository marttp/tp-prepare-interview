const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function heapify(array, heapSize, index) {
  // Initialize largest as root
  let largest = index;
  let left = 2 * index + 1;
  let right = 2 * index + 2;

  if (left < heapSize && array[left] > array[largest]) {
    largest = left;
  }

  if (right < heapSize && array[right] > array[largest]) {
    largest = right;
  }

  if (largest !== index) {
    let tmp = array[index];
    array[index] = array[largest];
    array[largest] = tmp;

    heapify(array, heapSize, largest);
  }
}

function heapSort(array) {
  let heapSize = array.length;

  // Build Heap
  for (let i = heapSize - 1; i >= 0; i--) {
    heapify(array, heapSize, i);
  }

  for (let i = heapSize - 1; i >= 0; i--) {
    // Move current root to end
    let tmp = array[0];
    array[0] = array[i];
    array[i] = tmp;
    // rearrange heap
    heapify(array, i, 0);
  }
}

heapSort(numbers);
console.log(numbers);
