package ru.misa.algorithms.main;

import java.util.Stack;
// Реализуйте функцию, проверяющую, является ли связный список палиндромом
public class Main {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.appendToTail(1);
        head.appendToTail(2);
        head.appendToTail(1);
        head.appendToTail(0);
        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head; // 2x
        LinkedListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
         /* Элементы первой половины связного списка помещаются в стек. Когда
            быстрый указатель (со скоростью 2x) достигает конца связного списка,
            медленный находится в середине */
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        /* Нечетное количество элементов, средний элемент пропускается */
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = stack.pop(); //.intValue();
            /* Если значения не совпадают, это не палиндром */
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
