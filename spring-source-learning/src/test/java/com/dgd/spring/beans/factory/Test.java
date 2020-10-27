package com.dgd.spring.beans.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : DaiGD
 * @createtime :  2020年10月20日 9:58
 * @description :
 */
public class Test
{
    public static void main(String[] args)
    {
        List<SortDemo> list = new ArrayList<>();
        list.add(new SortDemo("A"));
        list.add(new SortDemo("B"));
        list.add(new SortDemo("C"));

        for(int i = 0; i < 10; i++)
        {
            // 打乱顺序
            //Collections.shuffle(list);
            // 重新排序
            list.sort(Comparator.comparingInt(s -> s.sort));
            // 确认每次排序A是不是都是第一个
            if(!list.get(0).getName().equals("A") && !list.get(1).getName().equals("B"))
            {
                System.out.println("排序后：" + list);
            }
        }
    }

    static class SortDemo{
        private int sort = -1;
        private String name;

        public SortDemo(String name)
        {
            this.name = name;
        }

        public int getSort()
        {
            return sort;
        }

        public void setSort(int sort)
        {
            this.sort = sort;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        @Override public String toString()
        {
            return "[" + name + "]";
        }
    }
}
