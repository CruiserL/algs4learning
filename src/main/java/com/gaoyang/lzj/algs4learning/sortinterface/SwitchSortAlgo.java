package com.gaoyang.lzj.algs4learning.sortinterface;

/**
 * Desc: 基本排序算法的优化版，在子数组较小时切换排序算法
 *
 * @author Cruiser_L
 * @date 2019/6/13
 */
public interface SwitchSortAlgo {
    /**
     * 排序
     * @param arr 待排序数组
     * @param switchingPoint 切换点
     * @return 排序消耗的时间，单位ms
     */
    long sort(Comparable[] arr ,int switchingPoint);
}
