public interface IList <T>{
    //遍历顺序表
    void display();
    //获取顺序表长度
    int size();
    //判断顺序表中是否包含某个元素
    boolean contains(Object toFind);
    //查找某个元素的下标
    int indexOf(Object toFind);
    //尾插
    boolean add(T data);
    //任意位置插
    void add(int index,T data);
    //获取当前下标的元素
    T get(int index);
    //修改当前下标的元素
    T set(int index,T data);
    //删除:删除第一个出现key的元素
    boolean remove(T key);
    //清空顺序表
    void clear();
}
