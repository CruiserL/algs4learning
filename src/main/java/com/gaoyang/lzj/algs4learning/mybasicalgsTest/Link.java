package com.gaoyang.lzj.algs4learning.mybasicalgsTest;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * Desc: UF.txt的链接
 *
 * @author Cruiser_L
 * @date 2019/5/14
 */
public class Link implements Comparable<Link> {

    private int p;

    private int q;

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public int compareTo(Link link) {
        return this.p - link.p;
    }

    public Link(int x, int y) {
        this.p = x;
        this.q = y;
    }
//
//    public static void main(String[] args) {
//        Link[] linksArr = new Link[10];
//        for(int i = 0 ;i < 10;i++){
//            linksArr[i] = new Link(i,i);
//        }
//        Link[] tempArr = new Link[10];
//        System.arraycopy(linksArr, 0, tempArr, 0, 10);
//        tempArr[9] = null;
//        tempArr[8] = null;
//        tempArr[7].setQ(10000000);
//        System.out.println(JSON.toJSONString(linksArr));
//        System.out.println(JSON.toJSONString(tempArr));
//
//    }

    public static void main(String[] args) {
        Link link1 = new Link(1,1);
        Link link2 = link1;
        link2 = new Link(2,2);
        System.out.println(link1);
        System.out.println(link2);


    }


}
