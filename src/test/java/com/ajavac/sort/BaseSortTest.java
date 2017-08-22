package com.ajavac.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.Random;

/**
 * 抽象排序测试父类
 * Created by wyp0596 on 22/03/2017.
 */
public abstract class BaseSortTest {

    int[] origin;
    private int[] expect;
    private long begin;

    @Before
    public void before() {
        origin = new Random(2333L).ints(10000, 0, 10000).toArray();
        expect = Arrays.copyOf(origin, origin.length);
        long temp = System.nanoTime();
        Arrays.sort(expect);
        System.out.println("Arrays.sort() used time: " + (System.nanoTime() - temp) / 1e6 + " ms");
        begin = System.nanoTime();
    }

    @After
    public void after() {
        System.out.println("sort used time: " + (System.nanoTime() - begin) / 1e6 + " ms");
        Assert.assertArrayEquals(origin, expect);
    }

}