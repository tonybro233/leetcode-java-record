package tony.leetcode.level.simple;

import java.util.ArrayList;
import java.util.List;

// 412. Fizz Buzz
// 写一个程序，输出从 1 到 n 数字的字符串表示。
//
// 1. 如果 n 是3的倍数，输出“Fizz”；
// 2. 如果 n 是5的倍数，输出“Buzz”；
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

// 示例：
// n = 15,
// 返回:
// [
//     "1",
//     "2",
//     "Fizz",
//     "4",
//     "Buzz",
//     "Fizz",
//     "7",
//     "8",
//     "Fizz",
//     "Buzz",
//     "11",
//     "Fizz",
//     "13",
//     "14",
//     "FizzBuzz"
// ]

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";
        int count3 = 1;
        int count5 = 1;
        for (int i = 1; i <= n;i++, count3++, count5++){
            if (count3 == 3 && count5 == 5){
                result.add(fizzBuzz);
                count3 = 0; count5 = 0;
            } else if (count3 == 3){
                result.add(fizz);
                count3 = 0;
            } else if (count5 == 5){
                result.add(buzz);
                count5 = 0;
            } else {
                result.add(i+"");
            }
        }

        return result;
    }
}
