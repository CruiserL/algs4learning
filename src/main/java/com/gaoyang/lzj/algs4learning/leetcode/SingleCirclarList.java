package com.gaoyang.lzj.algs4learning.leetcode;

import com.gaoyang.lzj.algs4learning.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc: 单向环形链表解决约瑟夫问题
 *
 * @author Cruiser_L
 * @date 2019/10/31
 */
public class SingleCirclarList {

    private static final Logger logger = LoggerFactory.getLogger(Constants.APPNAME);

    public ListNode first;
    public ListNode end;

    public SingleCirclarList(int num) {
        first = new ListNode(-1);
        for (int i = 1; i <= num; i++) {

            ListNode newNode = new ListNode(i);
            if(i==1){
                first = newNode;
                end = newNode;
            }else {
                end.next = newNode;
                newNode.next = first;
                end = newNode;
            }
        }
        ListNode cur = first;
        logger.info("cur={}", cur);
        while(cur.next!=first){
            cur = cur.next;
            logger.info("cur={}", cur);
        }


    }
    public void josephu(int k ,int m){
        ListNode cur = first;
        ListNode pre = end;
        int i = 0;
        while(i < k-1){
            i++;
            cur = cur.next;
            pre = pre.next;
        }

        while(pre!=cur){
            int j = 0;
            while(j<m-1){
                j++;
                cur = cur.next;
                pre = pre.next;
            }

            logger.info("cur={}", cur);
            pre.next = cur.next;
            cur = pre.next;
        }
        logger.info("cur={}", cur);


    }

    public static void main(String[] args) {
        SingleCirclarList singleCirclarList = new SingleCirclarList(5);
        singleCirclarList.josephu(1, 2);
    }


}
