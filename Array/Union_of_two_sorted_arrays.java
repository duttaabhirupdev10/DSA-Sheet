✅ 1) Brute Force (using Set)

In Java, TreeSet automatically:
✔ keeps elements sorted
✔ stores unique values

import java.util.*;

class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        Set<Integer> st = new TreeSet<>();  // sorted + unique

        for (int i = 0; i < n1; i++) {
            st.add(a[i]);
        }

        for (int i = 0; i < n2; i++) {
            st.add(b[i]);
        }

        // move set elements to list
        List<Integer> temp = new ArrayList<>(st);
        return temp;
    }
}
Time Complexity: O((n1+n2) log(n1+n2))

✅ 2) Optimal – Two Pointer Approach

Same logic as your C++ code.

import java.util.*;

class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        int i = 0, j = 0;
        List<Integer> unionArr = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != a[i]) {
                    unionArr.add(a[i]);
                }
                i++;
            } else {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != b[j]) {
                    unionArr.add(b[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != a[i]) {
                unionArr.add(a[i]);
            }
            i++;
        }

        while (j < n2) {
            if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != b[j]) {
                unionArr.add(b[j]);
            }
            j++;
        }

        return unionArr;
    }
}


Time Complexity: O(n1 + n2)
👉 Best for interviews.
