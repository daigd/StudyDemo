package com.dgd.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple0;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import java.util.Arrays;

/**
 * @author DaiGD
 * @description: TODO
 * @date 2021/6/29 19:56
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> ds = env.readTextFile("src\\main\\resources\\hello.txt");
        AggregateOperator<Tuple2<String, Integer>> sum = ds.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] arr = s.split(" ");
                for (String s1 : arr) {
                    Tuple2<String, Integer> t = new Tuple2<>(s, 1);
                    collector.collect(t);
                }
            }
        }).groupBy(0).sum(1);
        sum.print();

        env.execute();
    }


}
