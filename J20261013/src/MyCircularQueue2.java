/**
 * 基于数组模拟实现队列(使用size属性)
 * @param <E>
 */
public class MyCircularQueue2<E> {
    private Object[] elem;
    private int size;
    private int head;
    private int last;
    private final int capacity;

    public MyCircularQueue2(int k) {
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
        this.size++;
        this.last = (this.last + 1) % capacity;
        return true;
    }

    private boolean isFull() {
        return this.size == this.capacity;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = (E)elem[head];
        elem[head] = null;
        size--;
        this.head = (this.head + 1) % capacity;
        return oldVal;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E)elem[head];
    }

    public int size() {
      return this.size;
    }
}
