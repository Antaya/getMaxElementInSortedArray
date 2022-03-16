/*
Дан массив неповторяющихся чисел, который был отсортирован, а затем циклически сдвинут на неизвестное число позиций.
Найти максимальное значение в массиве.
Бинарный поиск.

 */

public class Main {

    public static void main(String[] args) {

        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(getMaxElementInSortedArray(arr));

    }

    public static int getMaxElementInSortedArray(int[] sortedArray) {

        int left = 0;
        int right = sortedArray.length - 1;

        if (right == left) // в массиве только один элемент
            return sortedArray[left];

        while (left < right) {
            if (left == right - 1) { // два соседних элемента
                return Math.max(sortedArray[left], sortedArray[right]);
            }

            int middle = left + right / 2; // средний элемент

            if (sortedArray[middle] > sortedArray[left]) {  //если значения левой части идут по возрастанию к середине,
                // то переходим на правую часть

                left = middle;

            } else if (sortedArray[middle] < sortedArray[left]) { //если большее значение находится в левой части,
                // делим левую половину на левую и правую части
                right = middle - 1;
            }

        }
        return sortedArray[left];


    }
}

