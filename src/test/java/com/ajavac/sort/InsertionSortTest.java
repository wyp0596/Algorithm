package com.ajavac.sort;

import org.junit.Test;

/**
 * 插入排序测试
 * Created by wyp0596 on 22/03/2017.
 */
public class InsertionSortTest extends BaseSortTest {


    @Test
    public void sort() {
        InsertionSort.sort(origin);
    }


}