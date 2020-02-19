package com.songhaozhi.linkedlist.leetcode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _206_反转链表 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        listNode5.next = listNode4;
        ListNode listNode3 = new ListNode(3);
        listNode4.next = listNode3;
        ListNode listNode2 = new ListNode(2);
        listNode3.next = listNode2;
        ListNode listNode1 = new ListNode(1);
        listNode2.next = listNode1;
        listNode1.next = null;
        ListNode listNode = reverseList2(listNode5);
        System.out.println(listNode);
    }

    /**
     * 递归方式
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代方式
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            //先弄一个临时变量指向heal的next
            ListNode temp = head.next;
            //让head的next指向newHead
            head.next = newHead;
            //让newHead指向head
            newHead = head;
            //让head指向temp
            head = temp;
        }
        return newHead;
    }
}
