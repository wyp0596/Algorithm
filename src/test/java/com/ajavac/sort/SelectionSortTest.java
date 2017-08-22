package com.ajavac.sort;

import org.junit.Test;

/**
 * 选择排序测试
 * Created by wyp0596 on 22/08/2017.
 */
public class SelectionSortTest extends BaseSortTest {

    @Test
    public void sort() {
        SelectionSort.sort(origin);
    }

}