import java.util.Arrays;

public class MyArrayList<T> implements IList<T>{
    private Object[] elem;//存储元素的底层数组
    private int size;//当前有效元素个数
    public static final int DEFAULT_CAPACITY = 10;//默认容量

    public MyArrayList() {
        this.elem = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }

        this.elem = new Object[initCapacity];
    }

    //尾插
    @Override
    public boolean add(T data) {
        //判满
        if(isFull()) {
            //扩容
            grow();
        }

        //尾插
        this.elem[size] = data;//注意下标

        //长度加一
        this.size++;

        //返回值
        return true;
    }

    //判满
    private boolean isFull(){
        return this.elem.length == this.size;
    }

    //扩容方法
    private void grow() {
        this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
    }

    @Override
    public void add(int pos, T data) {
        //检查下标合法性
        checkPos(pos);

        //判满
        if(isFull()) {
            //扩容
            grow();
        }

        //移动元素
        for (int i = size - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }

        //新增元素
        this.elem[pos] = data;

        //长度加一
        this.size++;
    }

    private void checkPos(int pos) {
        if(pos < 0 || pos > this.size) {
            throw new PosOutBoundException("添加元素位置不合法 " + pos);
        }
    }

    @Override
    public boolean contains(Object toFind) {
        //寻找元素
        for (int i = 0; i < this.size; i++) {
            if(this.elem[i].equals(toFind)) {
                return true;
            }
        }

        //找不到元素
        return false;
    }

    @Override
    public int indexOf(Object toFind) {
        //寻找元素下标
        for (int i = 0; i < this.size; i++) {
            if(this.elem[i].equals(toFind)) {
                return i;//返回下标
            }
        }

        //找不到下标
        return -1;
    }

    @Override
    public T get(int pos) {
        //判断下标是否合法
        checkPosByGetOrSet(pos);

        return (T) this.elem[pos];
    }

    //判断下标合法性
    private void checkPosByGetOrSet(int pos) {
        if(pos < 0 || pos >= size) {
            throw new PosOutBoundException("获取元素pos位置不合法");
        }
    }

    //判断顺序表是否为空
    private boolean isEmpty() {
        return this.size == 0;
    }



    @Override
    public T set(int pos, T value) {
        checkPosByGetOrSet(pos);
        T oldVal = (T)this.elem[pos];//旧值
        this.elem[pos] = value;//修改
        return oldVal;//返回旧值
    }

    @Override
    public boolean remove(Object toRemove) {
        //寻找要移除元素的下标
        int index = indexOf(toRemove);

        if(index == -1) {
            return false;
        }

        //覆盖元素
        for(int i = index; i < size - 1;i++) {
            this.elem[i] = this.elem[i + 1];
        }

        this.elem[size - 1] = null;//最后一个元素置为null;

        //长度减一
        this.size--;

        //返回值
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
       for(int i = 0; i < size; i++) {
           this.elem[i] = null;
       }
       this.size = 0;
    }

    @Override
    public void display() {
        for(int i = 0; i < this.size; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
