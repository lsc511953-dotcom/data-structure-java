
import java.util.Arrays;

public class MyStack<E> {
    private Object[] elem;//底层数组
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int initialCapacity) {
        if(initialCapacity <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        elem = new Object[initialCapacity];
    }

    /**
     * 入栈
     * @param e
     * @return
     */
    public E push(E e) {
        if(isFull()) {
            grow();
        }
        elem[size] = e;
        size++;
        return e;
    }

    /**
     * 判断是否需要扩容
     * @return
     */
    private boolean isFull() {
        return this.size == elem.length;
    }

    /**
     * 扩容方法
     */
    private void grow() {
        elem = Arrays.copyOf(elem,2 * elem.length);
    }

    /**
     * 出栈并返回栈顶元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空,无法出栈");
        }
        E val = (E)elem[size - 1];
        elem[size - 1] = null;
        size--;
        return val;
    }

    /**
     * 返回栈顶元素不移除
     * @return
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空,无法查看栈顶元素");
        }
         return (E)elem[size - 1];
    }

    /**
     * 获取栈内元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 检查栈内有没有元素
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
