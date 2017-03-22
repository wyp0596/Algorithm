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
     * @return 排序后的列表
     * @throws IndexOutOfBoundsException index越界
     */
    <T extends Comparable<T>> List<T> sortByAsc(List<T> origin, int begin, int end);

    /**
     * 降序排序(从大到小)
     *
     * @param origin 原列表
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
     * @return 排序后的列表
     * @throws IndexOutOfBoundsException index越界
     */
    <T extends Comparable<T>> List<T> sortByDesc(List<T> origin, int begin, int end);


}
