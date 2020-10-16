import org.junit.Test;
import tony.util.ListNode;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Testor {

    @Test
    public void testUniqueRandom() {
        int max = 10, min = 0, n = 5;
        int len = max - min + 1;

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 待选数组0到(len-1)随机一个下标，然后len自减
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放入结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            // 如果随机到的下标是len-1，则等于没动，如果不是(小于)len-1，则替换。
            // 保证下一轮0到len-1都是没出现的数
            source[index] = source[len];
        }
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testPriorityQueue(){
        // 默认是小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(9);
        queue.add(8);
        queue.add(7);
        queue.add(10);
        queue.add(11);
        queue.add(1);

        // 从小到大打印
        while (queue.peek() != null){
            System.out.println(queue.poll());
        }
    }

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

    @Test
    public void testIterRemove(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        Integer next = iterator.next();
        System.out.println("Get : "+next);
        iterator.remove();

        System.out.println(set.toString());
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
    public void testInfinity(){
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
        String to = ":8::3:";
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
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();

        // 利用迭代器间隔删除List中的内容
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
    public void testEqual2() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); // true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b)); // false
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

    @Test
    public void testNegativeZero(){
        int i = 0;
        int j = -0;
        System.out.println(i+" : "+ 3*i);
        System.out.println(j+" : "+ 3*j);
    }


    @Test
    public void testBit(){
        System.out.println(Integer.numberOfTrailingZeros(2));
    }

    @Test
    public void testBitOperation(){
        int a = 1 << 3;
        int b = 1 << 4;
        int All = 0xFFFF;
        System.out.println("a:  \t"+Integer.toBinaryString(a));
        System.out.println("~a:  \t"+Integer.toBinaryString(~a));
        System.out.println("All:\t"+Integer.toBinaryString(All));
        System.out.println("All^a:\t"+Integer.toBinaryString(All^a));
        System.out.println("All^a^b:\t"+Integer.toBinaryString(All^a^b));
        System.out.println("All&~a:\t"+Integer.toBinaryString(All&~a));
        System.out.println("All&~a&~b:\t"+Integer.toBinaryString(All&~a&~b));
    }

    @Test
    public void testLetter(){
        System.out.println(Character.isLetter('汉')); // true
        System.out.println(Character.isAlphabetic('汉')); // true
        System.out.println(Character.isAlphabetic('a')); // true
        System.out.println(Character.isLowerCase('汉')); // false
        System.out.println(Character.isUpperCase('汉')); // false
        System.out.println(Character.getType('汉')); // 5 OTHER_LETTER
        System.out.println(Character.getType('!')); // 24 OTHER_PUNCTUATION
        System.out.println(Character.getType('?')); // 24 OTHER_PUNCTUATION
        System.out.println(Character.getType('[')); // 21 START_PUNCTUATION
    }

    @Test
    public void testMethodHandle() throws Throwable {
        // 字节码层次的方法调用
        ListNode node = new ListNode(10);
        node.next = new ListNode(9);
        MethodType methodType = MethodType.methodType(String.class);
        MethodHandle handle = MethodHandles.lookup().findVirtual(ListNode.class, "toString", methodType);
        // MethodHandle不可变
        handle = handle.bindTo(node);
        String str = (String) handle.invokeExact();
        System.out.println(str);
    }

    @Test
    public void testRound(){
        System.out.println("Round of 1.5:"+Math.round(1.5)); // 2
        System.out.println("Round of -1.5:"+ Math.round(-1.5)); // -1
    }

    @Test
    public void testRuntime(){
        // 能够从操作系统获取的最大内存
        System.out.println("Max mem: "+Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0 + "mb");
        // 已经从操作系统获取的最大内存
        System.out.println("Total mem: "+ Runtime.getRuntime().totalMemory() / 1024.0 / 1024.0 + "mb");
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void testIntern() {
        String s1 = new StringBuilder("计算机").append("语言").toString();
        System.out.println(s1 == s1.intern());

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2 == s2.intern());
    }

}
