package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author wjun
 * @date 2023/3/2 10:28
 * @email wjunjobs@outlook.com
 * @describe
 */
public class SinglyLinkedListSentinelTest {
    @Test
    public void singlyLinkedListTest01() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.display();
    }

    @Test
    public void singlyLinkedListTest02() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.display();
    }

    @Test
    public void singlyLinkedListTest03() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        Assertions.assertEquals(1, linkedList.get(0));
        Assertions.assertEquals(2, linkedList.get(1));
        Assertions.assertEquals(3, linkedList.get(2));
        Assertions.assertEquals(4, linkedList.get(3));
    }

    @Test
    public void singlyLinkedListTest04() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.insert(0, 0);
        linkedList.insert(1, 1);
        linkedList.insert(2, 2);
        linkedList.insert(3, 3);
        linkedList.insert(4, 4);
        linkedList.display();
    }

    @Test
    public void singlyLinkedListTest05() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        Assertions.assertThrows(IllegalArgumentException.class, linkedList::removeFirst);

    }

    @Test
    public void singlyLinkedListTest06() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.display();
        System.out.println();
        Assertions.assertEquals(3, linkedList.remove(2));
        linkedList.display();
    }

    @Test
    public void singlyLinkedListTest07() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.display();
        System.out.println();
        Assertions.assertEquals(3, linkedList.update(2, 33));
        linkedList.display();
    }

    @Test
    public void singlyLinkedListTest08() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.insert(2, 3);
        linkedList.insert(3, 4);
        linkedList.removeFirst();
        linkedList.remove(2);
        linkedList.display();
    }

    @Test
    public void singlyLinkedListTest09() {
        SinglyLinkedListSentinel linkedList = new SinglyLinkedListSentinel();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
    }
}
