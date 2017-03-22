package com.ajavac.sort.impl;

import com.ajavac.sort.BaseSortTest;
import com.ajavac.sort.Sort;
import org.junit.Test;

/**
 * 插入排序测试
 * Created by wyp0596 on 22/03/2017.
 */
public class InsertionSortTest extends BaseSortTest {

    private Sort sort = new InsertionSort();

    @Test
    public void sortByAsc() throws Exception {
        sort.sortByAsc(origin);
    }

    @Test
    public void sortByDesc() throws Exception {
        sort.sortByDesc(origin);
    }
}