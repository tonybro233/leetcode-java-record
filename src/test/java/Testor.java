import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Testor {

    @Test
    public void demo(){
        int i = 1;
        i <<= 1;
        System.out.println(i);
        if ((i & 1) != 0){

        }
    }

    @Test
    public void testSearch(){
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        int i = Collections.binarySearch(list, 1);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if (set.contains(i))
                set.remove(i);
            else
                set.add(i);
        }
        return set.iterator().next();
    }

    public int compareVersion(String version1, String version2) {
        String[] sp1 = version1.split("\\.");
        String[] sp2 = version2.split("\\.");
        int i = 0;
        for (; i < sp1.length; i++){
            if (i == sp2.length)
                break;
            if (Integer.valueOf(sp1[i]) > Integer.valueOf(sp2[i])){
                return 1;
            }
            else if (Integer.valueOf(sp1[i]) < Integer.valueOf(sp2[i])){
                return -1;
            }
        }
        if (sp1.length == sp2.length)
            return 0;
        else if (sp1.length > sp2.length){
            for (;i < sp1.length;i++){
                if (Integer.valueOf(sp1[i]) != 0)
                    return 1;
            }
            return 0;
        }
        else{
            for (;i < sp2.length;i++){
                if (Integer.valueOf(sp2[i]) != 0)
                    return -1;
            }
            return 0;
        }

    }

    @Test
    public void testPow(){
        double pow = Math.pow(2, 0);
        System.out.println(pow);
    }

    @Test
    public void testTime(){
        Instant begin = Instant.now();
        List<Integer> list = new ArrayList<>(4999999);
        for (int i = 0; i < 4999999;i++){
            list.add(i);
        }
        Instant end = Instant.now();

        System.out.println("use:"+ Duration.between(begin,end));
        System.out.println("size:"+list.size());
    }

    @Test
    public void BitCalc(){
        // int num = 3;
        // int t = 0;
        // int init = 1 << 30;
        // while (((init >> 1) & num) == 0){
        //     t++;
        // }
        // return (Integer.MAX_VALUE >>> t) ^ num;
        System.out.println(Integer.numberOfLeadingZeros(5));
    }

    @Test
    public void testInfiniy(){
        double d1 = Float.POSITIVE_INFINITY;
        double d2 = Float.NEGATIVE_INFINITY;
        System.out.println(d1 == d2);
        System.out.println(Math.abs(d1) == Math.abs(d2));
        System.out.println(Float.POSITIVE_INFINITY * 0);  // NaN
        System.out.println(Float.POSITIVE_INFINITY);  // Infinity
    }

    @Test
    public void testParseInt(){
        // 此方法可以不考虑字母大小写，可以在最前面加0
        int i = Integer.parseInt("85g3", 16);
        System.out.println("-------------result:"+i);
    }

    @Test
    public void testSplit(){
        // 开头的分隔符会分隔，末尾的不会
        String to = ":8::3";
        String[] split = to.split(":");
        // String collect = Arrays.stream(split).collect(Collectors.joining(","));
        // System.out.println(collect);
        for (String ea : split){
            if ("".equals(ea)){
                System.out.println("ye");
            } else {
                System.out.println(ea);
            }
        }

        String ip = "2001:db8:85a3:0::8a2E:0370:7334";
        String[] split1 = ip.split(":");
        System.out.println("size:"+split1.length);

    }


    private static final Pattern pattern = Pattern.compile("^(-*\\d+)([\\+-]\\d+)i$");

    @Test
    public void testRegex(){
        Matcher matchera = pattern.matcher("1+1i");
        System.out.println(matchera.matches());
        System.out.println(matchera.groupCount());
        System.out.println(matchera.group(0));
        int a1 = Integer.parseInt(matchera.group(1));
        int a2 = Integer.parseInt(matchera.group(2));
        System.out.println(a1+"+"+a2+"i");


    }

    @Test
    public void testBinarySearch(){
        int[] nums = new int[]{1,2,3,6,8,10};
        int i = Arrays.binarySearch(nums, 1,3,4);
        System.out.println(i);
        System.out.println(-i-1); // 大于等于key的第一个位置
    }

    @Test
    public void testIterator(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        System.out.println(iterator.next());
        iterator.remove();

        System.out.println(set.iterator().next());
    }

    @Test
    public void testIterator2(){
        Deque<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            if (!iterator.hasNext()){
                break;
            } else {
                iterator.next();
            }
        }
        System.out.println(list);
    }

    @Test
    public void testEqual(){
        String s1 = "1234";
        String s2 = "1234";
        System.out.println(s1 == s2);
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
    }

    @Test
    public void testContinueOut(){
        int i = 0, j = 0;
        out : for (i =0; i < 10;i++){
            for (j = 0; j < 10; j++){
                if (j+i == 2){
                    break out;
                }
            }
        }
        System.out.println("i:"+i+" j:"+j);
    }
}
