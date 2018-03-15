package com.dgd.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author DGD
 * @date 2018/3/15.
 * 在内存中准备一点数据
 */
public class TempDB {
    public static Map<String, Double> monthSaleMoney = new HashMap<>();
    static {
        monthSaleMoney.put("张三", 10000.0);
        monthSaleMoney.put("李四", 20000.0);
        monthSaleMoney.put("王五", 30000.0);
    }
}
