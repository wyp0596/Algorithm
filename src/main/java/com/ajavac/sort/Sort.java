package com.ajavac.sort;

import java.util.List;

/**
 * 排序算法接口
 * Created by wyp0596 on 21/03/2017.
 */
public interface Sort {

    /**
     * 增序排序(从小到大)
     *
     * @param origin 原列表
     * @param <T>    可比较的类
     * @return 排序后的列表
     */
    default <T extends Comparable<T>> List<T> sortByAsc(List<T> origin) {
        int size = origin.size();
        if (size < 2) {
            return origin;
        }
        return sortByAsc(origin, 0, size - 1);
    }

    /**
     * 增序排序(从小到大)
     *
     * @param origin 原列表
     * @param begin  开始位置(大于等于0)
     * @param end    结束位置(小于等于origin的大小-1)
     * @param <T>    可比较的类
     * @return 排序后的列表
     * @throws IndexOutOfBoundsException index越界
     */
    <T extends Comparable<T>> List<T> sortByAsc(List<T> origin, int begin, int end);

    /**
     * 降序排序(从大到小)
     *
     * @param origin 原列表
     * @param <T>    可比较的类
     * @return 排序后的列表
     */
    default <T extends Comparable<T>> List<T> sortByDesc(List<T> origin) {
        int size = origin.size();
        if (size < 2) {
            return origin;
        }
        return sortByDesc(origin, 0, size - 1);
    }

    /**
     * 降序排序(从大到小)
     *
     * @param origin 原列表
     * @param begin  开始位置(大于等于0)
     * @param end    结束位置(小于等于origin的大小-1)
     * @param <T>    可比较的类
     * @return 排序后的列表
     * @throws IndexOutOfBoundsException index越界
     */
    <T extends Comparable<T>> List<T> sortByDesc(List<T> origin, int begin, int end);

    /**
     * 交换位置i和位置j上的元素
     *
     * @param origin 原列表
     * @param i      位置i
     * @param j      位置j
     * @param <T>    可比较的类
     * @throws IndexOutOfBoundsException index越界
     */
    default <T extends Comparable<T>> void swap(List<T> origin, int i, int j) {
        T temp = origin.get(i);
        origin.set(i, origin.get(j));
        origin.set(j, temp);
    }

    /**
     * 比较位置i和位置j上的元素
     *
     * @param origin 原列表
     * @param i      位置i
     * @param j      位置j
     * @param <T>    可比较的类
     * @return 位置i和位置j上的元素的比较结果,
     * 若位置i上的元素大于位置j上的元素则返回正数,
     * 若位置i上的元素等于位置j上的元素则返回0,
     * 若位置i上的元素小于位置j上的元素则返回负数
     */
    default <T extends Comparable<T>> int compare(List<T> origin, int i, int j) {
        return origin.get(i).compareTo(origin.get(j));
    }

}
