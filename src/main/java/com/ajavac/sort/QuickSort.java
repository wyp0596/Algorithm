package com.ajavac.sort;

import com.ajavac.util.SwapUtils;

/**
 * 快速排序
 * <p>
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 * 步骤为：
 * 1. 从数列中挑出一个元素，称为"基准"（pivot），
 * 2. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
 * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。
 * 这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 * <p>
 * 数据结构	数组
 * 最坏时间复杂度	О(n²)
 * 最优时间复杂度	О(n log(n))
 * 平均时间复杂度	О(n log(n))
 * 空间复杂度	    根据实现的方式不同而不同
 * <p>
 * Created by wyp0596 at 2017-08-23
 */
public class QuickSort {

    public static int[] sort(int[] arrays) {
        quick_sort_recursive(arrays, 0, arrays.length - 1);
        return arrays;
    }


    private static void quick_sort_recursive(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;

        while (left < right) {
            // 循环终止条件: left 所在元素大于end所在元素或者 left 为 right
            while (arr[left] <= mid && left < right) {
                left++;
            }
            // 循环终止条件: right 所在元素小于end所在元素或者 right 为 left
            while (arr[right] >= mid && left < right) {
                right--;
            }
            // 交换元素
            SwapUtils.swap(arr, left, right);
        }
        // left 所在元素大于等于end 所在元素
        if (arr[left] >= arr[end]) {
            SwapUtils.swap(arr, left, end);
        } else { // left刚好为 end -1
            left++;
        }
        quick_sort_recursive(arr, start, left - 1);
        quick_sort_recursive(arr, left + 1, end);
    }


}
