package tony.codewar.logic;

// Consider a sequence u where u is defined as follows:
//
// The number u(0) = 1 is the first one in u.
// For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
// There are no other numbers in u.
// Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]

// Example:
// dbl_linear(10) should return 22

import java.util.SortedSet;
import java.util.TreeSet;

public class DoubleLinear {

    public static int dblLinear (int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        int x2 = 0, x3 = 0;
        for (int i = 1; i <= n; i++){
            arr[i] = Math.min(2 * arr[x2] + 1, 3 * arr[x3] + 1);
            if(arr[i] == 2 * arr[x2] + 1) {
                x2++;
            }
            if(arr[i] == 3 * arr[x3] + 1) {
                x3++;
            }
        }
        return arr[n];
    }

    public static int dblLinear2(int n) {
        if (n == 0) {
            return 1;
        }
        SortedSet<Integer> u = new TreeSet<>();
        u.add(1);
        for(int i=0; i<n; i++) {
            int x = u.first();
            u.add(x*2+1);
            u.add(x*3+1);
            u.remove(x);
        }
        return u.first();
    }
}
