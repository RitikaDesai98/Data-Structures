import java.lang.reflect.Array;

public class Radix {
    public static void main(String[] args) {
        int[] a = { 85, 3, 19, 43, 20, 55, 42, 21, 91, 85, 73, 29 };

        // Print unsorted array.
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        double start = System.nanoTime();
        // Sort the array.
        radixSort(a);
        double elapsed = (System.nanoTime() - start) / 1000000000;

        // Print sorted array.
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n" + elapsed);
    } // End Main

    public static void radixSort(int[] a) {
        // initialise max as the first element of the array i.e. 85 to beign with
        int max = a[0];

        // Get maximum element by iterating through the entire array and for every
        // element of the array if the
        // element is greater than max, replace max with that element..
        // So at the end of the loop we have max = 91
        for (int i = 1; i < a.length; i++) {
            if (max < a[i])
                max = a[i];
        }

        // Apply counting sort to sort elements based on place value. Max = 91, s starts
        // with 1 for the first loop and 10 for the second loop.
        // It won't iterate for the third time because max = 91 and s = 100 and max/s = 0.91 ~ 0
        // For each iteration it calls countingsortforradix on the array and s
        for (int s = 1; max / s > 0; s *= 10) {
            countingSortForRadix(a, s);
        }
    } // End radixSort

    static void countingSortForRadix(int[] arr, int s) {
        // Create a new array with the same lenght as unsorted array
        int[] countingArray = new int[arr.length];

        // Calculate count of elements or frequency of digits
        for (int i = 0; i < arr.length; i++) {
            countingArray[(arr[i] / s) % 10]++;
        }

        // Calculate cumulative count by changing countingarray to contain actual 
        // position of the digits in output
        for (int i = 1; i < countingArray.length; i++)
            countingArray[i] += countingArray[i - 1];

        // Place the elements in sorted order
        int[] outputArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            outputArray[--countingArray[(arr[i] / s) % 10]] = arr[i];

        for (int i = 0; i < arr.length; i++)
            arr[i] = outputArray[i];
    }
} // End Class