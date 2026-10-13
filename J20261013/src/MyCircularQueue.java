/**
 * 基于数组实现队列(牺牲一个空间)
 * @param <E>
 */
public class MyCircularQueue<E> {
    private Object[] elem;
    private int head;
    private int last;
    private final int capacity;

    /**
     * @param k 队列实际有效数量
     */
    public MyCircularQueue(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("队列容量必须大于0");
        }
        this.capacity = k + 1;
        elem = new Object[capacity];
    }

    /**
     * 入队
     * @param e
     * @return
     */
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        this.elem[last] = e;
        last = (last + 1) % capacity;
        return true;
    }

    private boolean isFull() {
        return (last + 1) % capacity == this.head;
    }

    /**
     * 出队
     * @return
     */
    @SuppressWarnings("unchecked")
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = (E)this.elem[head];
        this.elem[head] = null;
        head = (head + 1) % capacity;
        return oldVal;
    }

    private boolean isEmpty() {
        return this.head == this.last;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E)elem[head];
    }

    public int size() {
        if(this.head <= this.last) {
            return this.last - this.head;
        }else{
            return this.last + this.capacity - this.head;
        }
    }
}
