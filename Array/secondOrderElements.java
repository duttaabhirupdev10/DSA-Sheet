//Second Largest element in array
class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = arr[0];
        int slargest = -1;   // depends on constraints

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                slargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > slargest) {
                slargest = arr[i];
            }
        }

        return slargest;
    }
}

//Smallest and Second smallest in array
import java.util.*;

class Solution {
    public static List<Integer> minAnd2ndMin(int[] arr) {
        int smallest = arr[0];
        int ssmallest = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                ssmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < ssmallest) {
                ssmallest = arr[i];
            }
        }

        if (ssmallest == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        return Arrays.asList(smallest, ssmallest);
    }
}




