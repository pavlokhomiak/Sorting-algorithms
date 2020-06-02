package sortingalgorithms;

public class SortingAlgorithms {

    public int[] quickSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int temp = 0;

        int j = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[array.length - 1] > array[i]) {
                j++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        temp = array[array.length - 1];
        array[array.length - 1] = array[j + 1];
        array[j + 1] = temp;

        int[] left = new int[j + 1];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - (j + 2)];
        for (int i = 0; i < right.length; i++) {
            right[i] = array[left.length + i + 1];
        }

        int[] result = new int[array.length];
        for (int k = 0; k < quickSort(left).length; k++) {
            result[k] = quickSort(left)[k];
        }
        result[left.length] = array[j + 1];
        for (int k = 0; k < quickSort(right).length; k++) {
            result[left.length + k + 1] = quickSort(right)[k];
        }

        return result;
}
    
    public int[] selectionSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = min;
            array[minIndex] = temp;
        }
        
        return array;
    }

    public int[] insertionSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && array[j] < array[j - 1]) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
        return array;
    }

    public int[] bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public int[] mergeSort(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int index = 0;

        while (firstIndex != firstArray.length && secondIndex != secondArray.length) {
            if (firstIndex != firstArray.length) {
                if (firstArray[firstIndex] < secondArray[secondIndex]) {
                    result[index] = firstArray[firstIndex];
                    if (firstIndex != firstArray.length) {
                        index++;
                        firstIndex++;
                    } else {
                        index++;
                    }
                } else {
                    result[index] = secondArray[secondIndex];
                    if (secondIndex != secondArray.length) {
                        index++;
                        secondIndex++;
                    } else {
                        index++;
                    }
                }
            } else {
                result[index] = secondArray[secondIndex];
                if (secondIndex != secondArray.length) {
                    index++;
                    secondIndex++;
                } else {
                    index++;
                }
            }
        }
        return result;
    }

    public int[] splitArray(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] firstArray = new int[(int) Math.round((double) array.length/2)];
        int[] secondArray = new int[array.length/2];

        int j = 0;
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = array[i];
            //j++;
        }

        j = 0;
        int half = array.length/2;

        if (array.length % 2 == 0) {
            for (int i = array.length - 1; i >= half; i--) {
                secondArray[j] = array[i];
                j++;
            }
        } else {
            for (int i = array.length - 1; i > half; i--) {
                secondArray[j] = array[i];
                j++;
            }
        }
        return mergeSort(splitArray(firstArray), splitArray(secondArray));
    }
}
