package com.benyq.day5;

import com.benyq.ListNode;

public class q02_07 {

    public static void main(String[] args) {

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fa = headA;
        ListNode fb = headB;
        int sizeA = 0;
        int sizeB = 0;
        while (fa != null) {
            sizeA++;
            fa = fa.next;
        }
        while (fb != null) {
            sizeB++;
            fb = fb.next;
        }
        int diff = Math.abs(sizeA-sizeB);
        fa = headA;
        fb = headB;
        if (sizeA > sizeB) {
            while (diff > 0) {
                fa = fa.next;
                diff--;
            }
        }else if (sizeA < sizeB) {
            while (diff > 0) {
                fb = fb.next;
                diff--;
            }
        }
        while (fa != null) {
            if (fa == fb) return fa;
            fa = fa.next;
            fb = fb.next;
        }
        return null;
    }
}
