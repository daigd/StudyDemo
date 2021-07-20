package com.dgd.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author DaiGD
 * @description: TODO
 * @date 2021/6/29 20:12
 */
public class StreamWordCount {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> ds = env.readTextFile("src\\main\\resources\\hello.txt");
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = ds.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] arr = s.split(" ");
                for (String s1 : arr) {
                    collector.collect(new Tuple2<>(s1, 1));
                }
            }
        }).keyBy(i -> i.f0).sum(1);

        sum.print();

        env.execute();

    }
}
