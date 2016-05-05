package array_of_random_numbers;

/**
 * Created by Mayer Roman on 04.05.2016.
 */
public class ArrayOfRandomNumbers {
    public static int[] getArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
