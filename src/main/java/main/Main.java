package main;

import array_of_random_numbers.ArrayOfRandomNumbers;
import search_and_sort.SearchAndSort;
import search_and_sort.impl.BinarySearchAndQuickSort;
import search_and_sort.impl.InterpolationSearchAndCocktailSort;

/**
 * Created by Mayer Roman on 04.05.2016.
 */
public class Main {

    private static void checkSearcher(SearchAndSort searcher, int[] array, int numberToFind) {
        int position = searcher.searchInArray(array, numberToFind);
        System.out.println("position in array: " + position);
    }

    private static void checkSorter(SearchAndSort sorter) {
        int[] array = ArrayOfRandomNumbers.getArray(15);
        checkSorter(sorter, array);
    }

    private static void checkSorter(SearchAndSort sorter, int[] array) {
        System.out.println("Array before sorting: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
            if (i == array.length - 1) {
                System.out.println();
            }
        }

        sorter.sortArray(array);
        System.out.println("Array after sorting: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
            if (i == array.length - 1) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        SearchAndSort interpolationSearchAndCocktailSort = new InterpolationSearchAndCocktailSort();
        SearchAndSort binarySearchAndQuickSort = new BinarySearchAndQuickSort();


        int[] arrayToTestSearching = {-100, -33, 0, 1, 15, 48, 57, 57, 57, 66, 93, 115};
        checkSearcher(interpolationSearchAndCocktailSort, arrayToTestSearching, 57);
        checkSearcher(binarySearchAndQuickSort, arrayToTestSearching, 57);


        checkSorter(interpolationSearchAndCocktailSort);
        checkSorter(binarySearchAndQuickSort);
    }
}
