/**
 * 定义顺序表中所需要的方法
 */
public interface IList<T> {
    //新增元素,默认在数组最后新增
    boolean add(T data);
    //在pos位置新增元素
    void add(int pos,T data);
    //判定是否包含某个元素
    boolean contains(Object toFind);
    //查找某个元素对应的位置
    int IndexOf(Object toFind);
    //获取pos位置的元素
    T get(int pos);
    //给pos位置的元素设为value
    T set(int pos,T value);
    //删除第一次出现的关键字key
    boolean remove(Object toRemove);
    //获取顺序表的长度
    int size();
    //清空顺序表
    void clear();
    //打印顺序表,该方法不是顺序表中的方法
    void display();
}
