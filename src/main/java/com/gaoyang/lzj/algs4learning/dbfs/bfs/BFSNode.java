package com.gaoyang.lzj.algs4learning.dbfs.bfs;

import com.alibaba.fastjson.JSON;

/**
 * Desc: 广度优先遍历解决
 *
 * @author Cruiser_L
 * @date 2019/9/25
 */
public class BFSNode {
    /**
     * 坐标
     */
    private int x;
    private int y;
    /**
     * 父节点坐标
     */
    private int parent;
    /**
     * 当前已走过的步数
     */
    private int stepLength;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getStepLength() {
        return stepLength;
    }

    public void setStepLength(int stepLength) {
        this.stepLength = stepLength;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
