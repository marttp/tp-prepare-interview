public class QuickSort {
    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        // หา Pivot
        int pivotIndex = (left + right) / 2;
        int pivot = array[pivotIndex];

        // แล้วหลังจากนั้น เข้าไปแบ่ง partition
        int partitionIndex = partition(array, left, right, pivot);

        // ดังนั้น key หลักของ quick sort จะประกอบไปด้วย 2 ส่วน recursive ใหญ่ กับ partition

        // ทำไปเรื่อย ๆ
        quicksort(array, left, partitionIndex - 1);
        quicksort(array, partitionIndex, right);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (left <= right) {
                int tmp = array[left];
                array[left++] = array[right];
                array[right--] = tmp;
            }
        }

        return left;
    }
}