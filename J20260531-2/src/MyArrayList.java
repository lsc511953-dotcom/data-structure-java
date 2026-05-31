import java.util.Arrays;

/**
 * 模拟实现顺序表
 */
public class MyArrayList<T>implements IList<T> {

    public Object[] elem;

    public int size;
    public static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int initCapacity) {
        elem = new Object[initCapacity];
    }

    public MyArrayList() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    //新增元素,默认在数组最后新增
    @Override
    public boolean add(T data) {
        //判断是否满了,满了要扩容
        if(isFull()) {
            grow();
        }

        elem[size] = data;
        size++;
        return true;
    }

    public boolean isFull() {
        return size == elem.length;
    }

    //扩容方法
    public void grow() {
        elem = Arrays.copyOf(elem,2 * elem.length);
    }


    @Override
    public void add(int pos, T data) {
        checkPos(pos);//检查下标是否越界
        //在pos位置添加元素一样要判满
        if(isFull()) {
            grow();
        }

        //移动元素
        for (int i = size - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = data;
        size++;
    }

    //检查下标是否合理
    private void checkPos(int pos) {
        if(pos < 0 || pos >= size ) {
            throw new PosOutBoundsException("添加元素pos位置不合法：" + pos);
        }
    }


    @Override
    public boolean contains(Object toFind) {
        for(int i = 0;i < size;i++) {
            if(elem[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int IndexOf(Object toFind) {
        for (int i = 0; i < size; i++) {
            if(elem[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int pos) {
        //检查下标是否合理
        checkPosByGetOrSet(pos);
        //检查是否为空
        if(isEmpty()) {
            throw new ListEmptyException("获取元素时,顺序表为空");
        }

        return (T)elem[pos];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T set(int pos, T value) {
        //检查下标是否合理
        checkPosByGetOrSet(pos);
        T oldValue = (T)elem[pos];
        this.elem[pos] = value;
        return oldValue;
    }

    public void checkPosByGetOrSet(int pos) {
        if(pos < 0 || pos >= size) {
            throw new PosOutBoundsException("获取元素pos位置不合法");
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elem[i] = null;
        }

        this.size = 0;
    }

    @Override
    public boolean remove(Object toRemove) {
        //删除元素之前先找到元素的下标
        int index = IndexOf(toRemove);

        //找不到返回false
        if(index == -1) {
            return false;
        }

        //从index位置开始,从后往前开始覆盖
        //注意是size - 1,因为size - 1 是为了保证 elem[i + 1] 永远能取到合法的最后一个有效元素。
        for (int i = index; i < size - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }

        //覆盖完成后把最后一个元素置为null
        this.elem[size - 1] = null;
        //让size--
        this.size--;
        return true;
    }
}
