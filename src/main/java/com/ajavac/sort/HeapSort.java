package com.ajavac.sort;

import com.ajavac.util.SwapUtils;

/**
 * 堆排序
 * 堆节点的访问
 * 通常堆是通过一维数组来实现的。在数组起始位置为0的情形中：
 * 1. 父节点i的左子节点在位置(2*i+1);
 * 2. 父节点i的右子节点在位置(2*i+2);
 * 3. 子节点i的父节点在位置floor((i-1)/2);
 * <p>
 * 堆的操作
 * 在堆的数据结构中，堆中的最大值总是位于根节点(在优先队列中使用堆的话堆中的最小值位于根节点)。堆中定义以下几种操作：
 * 1. 最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 2. 创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
 * 3. 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 * <p>
 * 数据结构	数组
 * 最坏时间复杂度	О(n log(n))
 * 最优时间复杂度	О(n log(n))
 * 平均时间复杂度	О(n log(n))
 * 空间复杂度	    总共О(n),需要辅助空间 O(1)
 * <p>
 * Created by wyp0596 at 2017-08-22
 */
public class HeapSort {

    public static int[] sort(int[] arrays) {

        /*
         *  第一步：将数组堆化
         */
        // 最大索引值
        int maxIndex = arrays.length - 1;
        // maxIndex节点的父节点索引
        int beginIndex = (maxIndex - 1) >> 1;
        // 将整个数组堆化
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arrays, i, maxIndex);
        }

        /*
         * 对堆化数据排序
         */
        // 遍历数组
        for (int i = maxIndex; i > 0; i--) {
            // 交换堆顶(最大值)和无序区末尾的元素
            SwapUtils.swap(arrays, 0, i);
            // 将无序区堆化
            maxHeapify(arrays, 0, i - 1);
        }
        return arrays;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。(大顶堆)
     *
     * @param index    需要堆化处理的数据的索引
     * @param maxIndex 最大计算索引
     */
    private static void maxHeapify(int[] arr, int index, int maxIndex) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        // 左子节点索引超出计算范围，直接返回。
        if (li > maxIndex) {
            return;
        }

        // 判断右子节点是否存在,是否比左节点大
        if (ri <= maxIndex && arr[ri] > arr[li]) {
            cMax = ri;
        }
        // 判断子节点是否大于父节点
        if (arr[cMax] > arr[index]) {
            // 调换父节点和子节点,使其符合堆特性
            SwapUtils.swap(arr, cMax, index);
            // 需要继续判断换下后的节点是否符合堆的特性
            maxHeapify(arr, cMax, maxIndex);
        }
    }


}
