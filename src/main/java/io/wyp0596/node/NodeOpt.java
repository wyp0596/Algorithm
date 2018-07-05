package io.wyp0596.node;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangyupeng
 * @date 2018/7/4
 */
public class NodeOpt {

    /**
     * O(1)时间删除链表节点，从无头单链表中删除节点
     *
     * @param cur 待删除的节点
     * @param <T> 节点数据类型
     */
    public static <T> void deleteRandomNode(Node<T> cur) {
        if (cur == null || cur.getNext() == null) {
            throw new UnsupportedOperationException("节点为null或者为尾节点");
        }
        Node<T> next = cur.getNext();
        cur.setData(next.getData());
        cur.setNext(next.getNext());
    }

    /**
     * 单链表的转置,循环方法
     *
     * @param head 链表头节点
     * @param <T>  数据类型
     * @return 翻转后的链表头节点
     */
    public static <T> Node<T> reverseByLoop(Node<T> head) {
        Node<T> pre = null;
        Node<T> cur = head;
        while (cur != null) {
            Node<T> next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 单链表的转置,递归方法
     *
     * @param head 链表头节点
     * @param <T>  数据类型
     * @return 翻转后的链表头节点
     */
    public static <T> Node<T> reverseByRecursion(Node<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node<T> newHead = reverseByRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    /**
     * 倒数第k个节点
     *
     * @param head 链表头节点
     * @param k    倒数第0个节点为链表的尾节点
     * @param <T>  数据类型
     * @return 倒数第k个节点, 若不存在则返回null
     */
    public static <T> Node<T> theKthNode(Node<T> head, int k) {
        if (k < 0 || head == null) {
            return null;
        }
        Node<T> slow = head;
        Node<T> fast = head;
        for (int i = 0; i < k; i++) {
            Node<T> next = fast.getNext();
            // k大于链表长度
            if (next == null) {
                return null;
            }
            fast = next;
        }
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    /**
     * 求链表的中间节点
     *
     * @param head 链表头节点
     * @param <T>  数据类型
     * @return 求链表的中间节点，如果链表的长度为偶数，返回中间两个节点的任意一个，若为奇数，则返回中间节点
     */
    public static <T> Node<T> theMiddleNode(Node<T> head) {
        if (head == null) {
            return null;
        }
        Node<T> slow = head;
        Node<T> fast = head;
        // 如果链表的长度为偶数，返回中间两个节点的靠右一个, 如果要靠左一个可以用下面的条件
        // while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null)
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    /**
     * 判断单链表是否存在环
     *
     * @param head 链表头节点
     * @param <T>  数据类型
     * @return 是否存在环
     */
    public static <T> boolean hasCircle(Node<T> head) {
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到环的入口点
     *
     * @param head 链表头节点
     * @param <T>  数据类型
     * @return 环的入口, 不存在则为null
     */
    public static <T> Node<T> findLoopPort(Node<T> head) {
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            // 存在环
            if (fast == slow) {
                // 慢指针退回头部
                slow = head;
                // 慢快指针每次各走一步,直到相遇
                while (slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * 判断两个无环链表是否相交
     * 1. 无环链表和无环链表可能相交
     * 2. 有环链表和有环链表可能相交
     * 3. 无环链表和有环链表是不可能相交的
     *
     * @param h1  链表1头节点
     * @param h2  链表2头节点
     * @param <T> 数据类型
     * @return 是否相交
     */
    public static <T> boolean isIntersect(Node<T> h1, Node<T> h2) {
        if (h1 == null || h2 == null) {
            return false;
        }
        Node<T> loopPort1 = findLoopPort(h1);
        Node<T> loopPort2 = findLoopPort(h2);
        // 无环链表和无环链表可能相交
        if (loopPort1 == null && loopPort2 == null) {
            while (h1.getNext() != null) {
                h1 = h1.getNext();
            }
            while (h2.getNext() != null) {
                h2 = h2.getNext();
            }
            // 尾节点是否相同
            return h1 == h2;
        }
        // 有环链表和有环链表可能相交
        if (loopPort1 != null && loopPort2 != null) {
            Node<T> temp = loopPort1.getNext();
            while (temp != loopPort1) {
                if (temp == loopPort2) {
                    return true;
                }
                temp = temp.getNext();
            }
            return false;
        }
        // 无环链表和有环链表是不可能相交的
        return false;
    }

    /**
     * 求两链表相交的第一个公共节点
     *
     * @param h1  链表1头节点
     * @param h2  链表2头节点
     * @param <T> 数据类型
     * @return 两链表相交的第一个公共节点
     */
    public static <T> Node<T> findIntersectNode(Node<T> h1, Node<T> h2) {
        int len1 = listLength(h1);
        int len2 = listLength(h2);
        // 对齐链表
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                h1 = h1.getNext();
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                h2 = h2.getNext();
            }
        }
        while (h1 != null) {
            if (h1 == h2) {
                return h1;
            }
            h1 = h1.getNext();
            h2 = h2.getNext();
        }
        return null;
    }

    public static <T> int listLength(Node<T> head) {
        boolean hasCircle = hasCircle(head);
        if (hasCircle) {
            throw new UnsupportedOperationException();
        }
        int len = 0;
        while (head != null) {
            len++;
            head = head.getNext();
        }
        return len;
    }

    /**
     * 根据列表数据创建链表
     *
     * @param dataList 一组有序数据
     * @param <T>      数据类型
     * @return 链表表头节点
     */
    public static <T> Node<T> createNodeList(List<T> dataList) {
        // 保证至少有一个元素
        if (dataList == null || dataList.isEmpty()) {
            return null;
        }
        // 构建列表
        List<Node<T>> nodeList = dataList.stream().map(Node::new).collect(Collectors.toList());
        // 组成链表
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).setNext(nodeList.get(i + 1));
        }
        // 返回链表头节点
        return nodeList.get(0);
    }

    public static void main(String[] args) {
        Node<Integer> head = createNodeList(Arrays.asList(1, 2, 3, 4));
        System.out.println(head);

        Node<Integer> out = findLoopPort(head);
        System.out.println(out);
    }


}
