import java.util.Arrays;

/**
 * 用顺序表模拟实现栈
 * @param <E>
 */
public class MyStack<E> {
    private Object[] elem;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack(){
        elem = new Object[DEFAULT_CAPACITY];
    }

    //返回栈内当前的元素个数
    public int size() {
        return size;
    }

    //将元素压入栈顶
    public E push(E e) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[size] = e;
        size++;
        return e;
    }

    private boolean isFull() {
        return elem.length == size;
    }

    //检查栈内是否没有元素
    public boolean isEmpty() {
        return size == 0;
    }

    //移除并返回栈顶元素
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈空异常");
        }
        E oldVal = (E) elem[size - 1];
        elem[size - 1] = null;
        size--;
        return oldVal;
    }

    //仅查看栈顶元素,不移除
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈空异常");
        }
        E val = (E) elem[size - 1];
        return val;
    }
}
