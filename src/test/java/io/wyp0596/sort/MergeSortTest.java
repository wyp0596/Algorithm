package io.wyp0596.sort;

import org.junit.Test;

/**
 * 归并排序测试
 * Created by wyp0596 at 2017-08-23
 */
public class MergeSortTest extends BaseSortTest {


    @Test
    public void sort() {
        MergeSort.sort(origin);
    }


}