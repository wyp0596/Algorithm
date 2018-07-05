package io.wyp0596.sort;

import org.junit.Test;

/**
 * 堆排序测试
 * Created by wyp0596 at 2017-08-22
 */
public class HeapSortTest extends BaseSortTest {


    @Test
    public void sort() {
        HeapSort.sort(origin);
    }


}