package search_and_sort.impl;

import search_and_sort.SearchAndSort;

/**
 * Created by Mayer Roman on 04.05.2016.
 */
public class BinarySearchAndQuickSort extends SearchAndSort {
    @Override
    public void sortArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Переданный массив не существует или пуст");
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int fromIndex, int toIndex) {

        int left = fromIndex;
        int right = toIndex;
        int splitter = array[toIndex];
        int temp;

        while (left <= right) {
            while (array[left] < splitter) {
                left++;
            }
            while (splitter < array[right]) {
                right--;
            }
            if (left <= right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        if (fromIndex < right) {
            quickSort(array, fromIndex, right);
        }
        if (left < toIndex) {
            quickSort(array, left, toIndex);
        }
    }


    @Override
    public int searchInArray(int[] array, int elementToFind) {
        if (array == null || array.length == 0) {
            System.out.println("Переданный массив не существует или пуст");
            return -1;
        }

        int left = 0;
        int right = array.length-1;
        int mid;

        while (left <= right) {
            mid = (right + left) / 2;

            if (array[mid] == elementToFind) {
                while (mid > 0 && array[mid - 1] == elementToFind) {
                    mid--;
                }
                return mid;

            } else if (array[mid] < elementToFind) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
