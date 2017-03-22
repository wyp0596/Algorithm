package com.ajavac.sort;

import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抽象排序测试父类
 * Created by wyp0596 on 22/03/2017.
 */
public abstract class BaseSortTest {

    protected List<Integer> origin = new ArrayList<>();
    private long begin;

    @Before
    public void before() {
        new Random(2333L).ints(100, 0, 10000).forEach(a -> origin.add(a));
        // origin = Arrays.asList(2, 1, 3, 42, 3, 4, 5, 67, 8, 9, 3, 2, 0, 222, 323, 242, 52, 123, 2, 1);
        System.out.println("原序列: " + origin);
        begin = System.nanoTime();
    }

    @After
    public void after() {
        System.out.println("排序耗时: " + (System.nanoTime() - begin));
        System.out.println("排序后序列: " + origin);
    }

}