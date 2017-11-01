package com.dgd.lambda;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author DaiGuodong
 * @create 2017-11-01-22:20
 * lambda示例
 */
public class LambdaDemo {
    public static void main(String[] args) {
        System.out.println("Hello lambda!");

        System.out.println("消费型接口示例:");

        donation(100,(money)-> System.out.println("小明给小花送了"+money+"块钱。"));

        System.out.println("供给型接口示例:");

        List<Integer> list = supply(3, () -> (int) (Math.random() * 100));

        list.forEach(System.out::println);

        System.out.println("函数型接口示例:");

        Integer value = convert("2", x -> Integer.valueOf(x));
        System.out.println(value);

        System.out.println("断言型接口:");

        List<String> fruits = Arrays.asList("苹果", "哈密瓜", "雪梨", "火龙果");
        List<String> result = filter(fruits, (f) -> f.length() == 2);
        System.out.println(result);

        filter(fruits,(f) -> f.length()==3).forEach(System.out::println);
    }
    //编写一个函数式接口
    @FunctionalInterface
    interface Predicate<T>{
        boolean test(T t);
    }

    /**
     * 执行Predicate判断
     * @param age 年龄
     * @param predicate
     * @return
     */
    public static boolean doPredicate(int age,Predicate<Integer> predicate) {
        return predicate.test(age);
    }


    //消费型接口示例
    public static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    //供给型接口示例
    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for(int x=0;x<num;x++) {
            list.add(supplier.get());
        }
        return list;
    }

    //函数型接口
    public static Integer convert(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    //断言型接口
    public static List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> reuslt = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                reuslt.add(s);
            }
        }
        return reuslt;
    }

}
