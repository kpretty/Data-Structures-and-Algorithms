package linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author wjun
 * @date 2023/3/2 10:08
 * @email wjunjobs@outlook.com
 * @describe 为了简化代码，减少头节点为空判断等
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    // 头指针指向哨兵节点
    private final Node head = new Node(Integer.MIN_VALUE, null); // 头指针

    private int size = 0; // 维护链表个数

    public void addFirst(int value) {
        // 带哨兵，只需要将哨兵的next指向新节点即可
        head.next = new Node(value, head.next);
        size++;
    }

    public void addLast(int value) {
        // 对于带有哨兵，findLast 返回的节点一定不为 Node
        Node last = findLast();
        last.next = new Node(value, null);
        size++;
    }

    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index boundary is " + (size - 1));
        }
        int currentIndex = 0;
        Node pointer = head.next;
        while (currentIndex < index) {
            pointer = pointer.next;
            currentIndex++;
        }
        return pointer.value;
    }

    public void insert(int index, int value) {
        if (index > size) {
            throw new IndexOutOfBoundsException("legal insert index boundary is " + size);
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        // pointer 落后于 current 一位
        // 因为插入需要找到待插入位置的前一个节点
        int currentIndex = 1;
        Node pointer = head.next;
        while (currentIndex < index) {
            currentIndex++;
            pointer = pointer.next;
        }
        pointer.next = new Node(value, pointer.next);
    }

    public int removeFirst() {
        if (size == 0) {
            throw new IllegalArgumentException("linked is empty");
        }
        int value = head.next.value;
        head.next = head.next.next;
        size--;
        return value;
    }

    public int remove(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("legal insert index boundary is " + size);
        }
        if (index == 0) {
            return removeFirst();
        }
        // 找到待删除节点的前一个节点
        Node pointer = head.next;
        for (int i = 1; i < index; i++) {
            pointer = pointer.next;
        }
        int value = pointer.next.value;
        pointer.next = pointer.next.next;
        return value;
    }

    public int update(int index, int value) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("legal insert index boundary is " + size);
        }
        Node pointer = head.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        int oldValue = pointer.value;
        pointer.value = value;
        return oldValue;

    }

    public int size() {
        return size;
    }


    private Node findLast() {
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public void display() {
        loop1(integer -> System.out.print(integer + " -> "));
    }

    // 使用 while 循环遍历l
    public void loop1(Consumer<Integer> consumer) {
        Node pointer = head.next;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    // 使用 for 循环遍历
    @SuppressWarnings("unused")
    public void loop2(Consumer<Integer> consumer) {
        for (Node pointer = head.next; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);
        }
    }

    // 迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head.next;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }


    private static class Node {
        private int value; // 存储的数据
        private Node next; // 指向下一个节点的指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
