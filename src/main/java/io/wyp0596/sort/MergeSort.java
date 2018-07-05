package io.wyp0596.sort;

/**
 * 归并排序
 * <p>
 * 迭代法
 * 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4. 重复步骤3直到某一指针到达序列尾
 * 5. 将另一序列剩下的所有元素直接复制到合并序列尾
 * <p>
 * 递归法
 * 原理如下（假设序列共有n个元素）：
 * 1. 将序列每相邻两个数字进行归并操作，形成 floor(n/2) 个序列，排序后每个序列包含两个元素
 * 2. 将上述序列再次归并，形成 floor(n/4) 个序列，每个序列包含四个元素
 * 3. 重复步骤2，直到所有元素排序完毕
 * <p>
 * 数据结构	数组
 * 最坏时间复杂度	О(n log(n))
 * 最优时间复杂度	О(n)
 * 平均时间复杂度	О(n log(n))
 * 空间复杂度	    О(n)
 * <p>
 * Created by wyp0596 at 2017-08-23
 */
public class MergeSort {

    public static int[] sort(int[] arrays) {
        // merge_sort_iterative(arrays);
        merge_sort_recursive(arrays);
        return arrays;
    }

    // 迭代法
    private static void merge_sort_iterative(int[] arr) {

        int len = arr.length;
        // 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
        int[] mergedArr = new int[len];

        //  block为块的大小, 1,2,4,8 ... , 当循环次数为奇数时,最后一遍循环目的是将mergedArr的数据拷贝入arr
        for (int block = 1; block < len * 2; block *= 2) {
            for (int start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    mergedArr[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    mergedArr[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    mergedArr[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = mergedArr;
            mergedArr = temp;
        }
    }


    // 递归法
    private static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    private static void merge_sort_recursive(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

}
