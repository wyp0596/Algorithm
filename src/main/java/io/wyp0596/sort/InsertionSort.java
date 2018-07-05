package io.wyp0596.sort;

import io.wyp0596.util.SwapUtils;

/**
 * 插入排序
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 1. 从第一个元素开始，该元素可以认为已经被排序
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5. 将新元素插入到该位置后
 * 6. 重复步骤2~5
 * 如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的数目。该算法可以认为是插入排序的一个变种，称为二分查找插入排序。
 * <p>
 * 数据结构	数组
 * 最坏时间复杂度	О(n²)
 * 最优时间复杂度	О(n)
 * 平均时间复杂度	О(n²)
 * 空间复杂度	    总共О(n),需要辅助空间 O(1)
 * <p>
 * Created by wyp0596 on 22/03/2017.
 */
public class InsertionSort {

    public static int[] sort(int[] arrays) {
        // 遍历数组
        for (int i = 1; i < arrays.length; i++) {
            // 遍历有序区的数
            for (int j = i; j > 0; j--) {
                // 若相邻元素前面的大于后面的,则交换,否则退出循环
                if (arrays[j] < arrays[j - 1]) {
                    SwapUtils.swap(arrays, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arrays;
    }

}
