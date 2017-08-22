package com.ajavac.util;

/**
 * 元素交换工具类
 * Created by wyp0596 on 22/08/2017.
 */
public final class SwapUtils {

    private SwapUtils() {
    }

    /**
     * 对整数数组中的两个元素进行交换
     * @param arrays 待交换数组
     * @param indexA 元素a下标
     * @param indexB 元素b下标
     */
    public static void swap(int[] arrays, int indexA, int indexB) {
        int temp = arrays[indexA];
        arrays[indexA] = arrays[indexB];
        arrays[indexB] = temp;
    }


}
