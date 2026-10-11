public class MyQueue<E> {
    private static class ListNode<E>{
        E val;
        ListNode<E> prev;
        ListNode<E> next;

        public ListNode(E val) {
            this.val = val;
        }
    }
    private ListNode<E> head;
    private ListNode<E> last;

    /**
     * 入队(尾插)
     * @param e
     * @return
     */
    public boolean offer(E e) {
        ListNode<E> node = new ListNode<E>(e);

        if(this.head == null) {
            this.head = node;
            this.last = node;
            return true;
        }

        this.last.next = node;
        node.prev = this.last;
        this.last = node;

        return true;
    }

    /**
     * 出队(头删)
     * @return
     */
    public E poll() {
        if(this.head == null) {
            return null;
        }
        E val = this.head.val;
        this.head = this.head.next;
        if(this.head == null) {
            this.last = null;
        }else{
            this.head.prev = null;
        }
        return val;
    }

    /**
     * 查看但不移除队列头部元素
     * @return
     */
    public E peek() {
        if(this.head == null) {
            return null;
        }
        return this.head.val;
    }
}
