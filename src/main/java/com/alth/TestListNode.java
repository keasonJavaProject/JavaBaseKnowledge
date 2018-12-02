package com.alth;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/4 11:11
 */
public class TestListNode {
    public static void main(String[] args) {
        int i = 0;
        ListNode listNodeStart = new ListNode(0);
        ListNode current = null, temp = null;
        current = listNodeStart;
        while ( i < 100) {
            i++;
            temp = new ListNode(i);
            current.next  = temp;
            current = temp;
        }

        while (listNodeStart != null) {
            System.out.println(listNodeStart.val);
            listNodeStart = listNodeStart.next;
        }
    }
}
