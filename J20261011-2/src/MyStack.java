import javax.swing.*;

public class MyStack<E> {
    public static class ListNode<E> {
        E val;//数据域
        ListNode<E> prev;//前驱引用
        ListNode<E> next;//后驱引用

        public ListNode(E val) {
            this.val = val;
        }
    }
    private ListNode<E> head;
    private ListNode<E> last;

    /**
     * 获取栈元素个数
     * @return
     */
    public int size() {
        ListNode<E> cur = this.head;
        int count = 0;
        while(cur!= null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
       return this.head == null;
    }

    /**
     * 入栈(尾插)
     * @param e
     * @return
     */
    public E push(E e) {
        ListNode<E> node = new ListNode<>(e);
        if(this.head == null) {
          this.head = node;
          this.last = node;
          return node.val;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
        return node.val;
    }

    /**
     * 出栈并返回栈顶元素
     * @return
     */
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空,无法出栈");
        }
        E val = this.last.val;
        this.last = this.last.prev;

        if(this.last == null) {
            this.head = null;
        }else{
            this.last.next = null;
        }
        return val;
    }

    /**
     * 获取栈顶元素,不移除元素
     * @return
     */
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空,无法出栈");
        }
        return this.last.val;
    }
}
