/**
 * 基于数组模拟实现队列(标志法)
 * @param <E>
 */
public class MyCircularQueue3<E> {
    private Object[] elem;
    private int head;
    private int last;
    private boolean isFull;
    private final int capacity;

    public MyCircularQueue3(int k) {
        if(k <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        capacity = k;
        elem = new Object[capacity];
    }

    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        elem[last] = e;
        this.last = (this.last + 1) % capacity;
        if(this.head == this.last) {
            isFull = true;
        }
        return true;
    }

    private boolean isFull() {
        return isFull;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = (E)elem[head];
        elem[this.head] = null;
        isFull = false;
        this.head = (this.head + 1) % capacity;
        return oldVal;
    }

    private boolean isEmpty() {
        return (this.head == this.last) && !isFull;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E)elem[head];
    }

    public int size() {
        if(isFull) {
            return this.capacity;
        }

        if(this.head <= this.last) {
            return this.last - this.head;
        }else{
            return this.last + this.capacity - this.head;
        }
    }
}
