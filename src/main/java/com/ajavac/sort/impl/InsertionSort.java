package com.ajavac.sort.impl;

import com.ajavac.sort.Sort;

import java.util.List;

/**
 * 插入排序
 * Created by wyp0596 on 22/03/2017.
 */
public class InsertionSort implements Sort {

    @Override
    public <T extends Comparable<T>> List<T> sortByAsc(List<T> origin, int begin, int end) {
        for (int i = begin + 1; i < end + 1; i++) {
            for (int j = i; j > begin; j--) {
                T now = origin.get(j);
                T before = origin.get(j - 1);
                if (now.compareTo(before) < 0) {
                    origin.set(j, before);
                    origin.set(j - 1, now);
                } else {
                    break;
                }
            }
        }
        return origin;
    }

    @Override
    public <T extends Comparable<T>> List<T> sortByDesc(List<T> origin, int begin, int end) {
        for (int i = begin + 1; i < end + 1; i++) {
            for (int j = i; j > begin; j--) {
                T now = origin.get(j);
                T before = origin.get(j - 1);
                if (now.compareTo(before) > 0) {
                    origin.set(j, before);
                    origin.set(j - 1, now);
                } else {
                    break;
                }
            }
        }
        return origin;
    }
}
