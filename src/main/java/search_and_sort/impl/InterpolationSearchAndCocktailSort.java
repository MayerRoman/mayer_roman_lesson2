package search_and_sort.impl;

import search_and_sort.SearchAndSort;

/**
 * Created by Mayer Roman on 04.05.2016.
 */
public class InterpolationSearchAndCocktailSort extends SearchAndSort {
    @Override
    public void sortArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Переданный массив не существует или пуст");
            return;
        }

        int left = 0;
        int right = array.length - 1;
        boolean swapped = true;
        int temp;

        while (left < right && swapped) {
            swapped = false;

            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            right--;

            if (swapped) {
                swapped = false;
                for (int i = right; i > left; i--) {
                    if (array[i] < array[i - 1]) {
                        temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                        swapped = true;
                    }
                }
                left++;
            }
        }
    }

    @Override
    public int searchInArray(int[] array, int elementToFind) {
        if (array == null || array.length == 0) {
            System.out.println("Переданный массив не существует или пуст");
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        int mid;

        while (array[left] < elementToFind && elementToFind < array[right]) {
            mid = left + ((right - left) * (elementToFind - array[left])) / (array[right] - array[left]);

            if (array[mid] < elementToFind) {
                left = mid + 1;
            } else if (elementToFind < array[mid]) {
                right = mid - 1;
            } else {
                while (mid > left && array[mid - 1] == elementToFind) {
                    mid--;
                }
                return mid;
            }
        }

        if (array[left] == elementToFind) {
            return left;
        } else if (array[right] == elementToFind) {
            while (right > left && array[right - 1] == elementToFind) {
                right--;
            }
            return right;
        } else {
            return -1;
        }
    }
}
