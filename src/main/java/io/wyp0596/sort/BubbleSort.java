package io.wyp0596.sort;

import io.wyp0596.util.SwapUtils;

/**
 * 冒泡排序
 * 冒泡排序算法的运作如下：
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3. 针对所有的元素重复以上的步骤，除了最后一个。
 * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 由于它的简洁，冒泡排序通常被用来对于程序设计入门的学生介绍算法的概念。
 * <p>
 * 数据结构	数组
 * 最坏时间复杂度	О(n²)
 * 最优时间复杂度	О(n)
 * 平均时间复杂度	О(n²)
 * 空间复杂度	    总共О(n),需要辅助空间 O(1)
 * <p>
 * Created by wyp0596 on 22/03/2017.
 */
public class BubbleSort {

    public static int[] sort(int[] arrays) {
        // 遍历数组
        for (int i = 0; i < arrays.length - 1; i++) {
            // 遍历无序区的数
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                // 若相邻的数,前面的比较大,则交换相邻的数
                if (arrays[j] > arrays[j + 1]) {
                    SwapUtils.swap(arrays, j, j + 1);
                }
            }
        }
        return arrays;
    }

}
