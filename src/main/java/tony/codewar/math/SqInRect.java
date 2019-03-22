package tony.codewar.math;

import java.util.ArrayList;
import java.util.List;

// The drawing below gives an idea of how to cut a given "true" rectangle into squares
// ("true" rectangle meaning that the two dimensions are different).

// Can you translate this drawing into an algorithm?
// You will be given two dimensions
// a positive integer length (parameter named lng)
// a positive integer width (parameter named wdth)

// When the initial parameters are so that lng == wdth,
// the solution [lng] would be the most obvious but not in the spirit of this kata so,
// in that case, return None/nil/null/Nothing

public class SqInRect {

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int min = Math.min(lng, wdth);
        int max = Math.max(lng, wdth);
        while (min != max){
            result.add(min);
            int g1 = max - min, g2 = min;
            min = Math.min(g1, g2);
            max = Math.max(g1, g2);
        }
        result.add(min);

        return result;
    }

}
