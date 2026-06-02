/**
 * 在接口中定义链表需要的方法
 * @param <T>
 */
public interface IList<T> {
    // 头插法：在链表头部插入数据
    void addFirst(T data) ;

    // 尾插法：在链表尾部插入数据
    void addLast(T data) ;

    // 任意位置插入：第一个节点为0号下标
    void addIndex(int index, T data) ;

    // 查找：判断关键字key是否存在
    boolean contains(T key) ;

    // 删除：移除第一次出现的key节点
    boolean remove(T key);

    // 删除：移除所有值为key的节点
    void removeAllKey(T key) ;

    // 统计：获取链表长度
    int size() ;

    // 清空：释放链表所有节点
    void clear() ;

    // 遍历：打印链表所有元素
    void display() ;
}
