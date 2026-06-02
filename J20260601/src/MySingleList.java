/**
 * 模拟实现链表
 */
public class MySingleList<T> implements IList<T> {
    static class ListNode<T>{
        T val;//数据域
        ListNode<T> next;//引用域

        public ListNode(T val) {
            this.val = val;
        }
    }

    public ListNode<T> head;//链表的头引用,是访问链表的入口

    @Override
    public void display() {
        ListNode<T> cur = this.head;//不要让head动(防止找不到链表的入口)

        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

        System.out.println();
    }

    @Override
    public int size() {
        int count = 0;

        ListNode<T> cur = this.head;

        while(cur != null) {
            count++;
            cur = cur.next;
        }

        return count;
    }

    @Override
    public boolean contains(T key) {
      ListNode<T> cur = this.head;

      while(cur != null) {
          if(cur.val.equals(key)) {
              return true;
          }
      }

      return false;
    }


    @Override
    public void addFirst(T data) {
        ListNode<T> node = new ListNode<>(data);//实例化一个节点

        node.next = this.head;//绑定后面
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);

        // 链表为空
        if (this.head == null) {
            this.head = node;
            return;
        }

        // 找到最后一个节点
        ListNode<T> cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;
    }

    // 任意位置插入，第一个数据节点为 0 号下标
    @Override
    public void addIndex(int index, T data) {
        int len = size();//获取链表长度

        //如果下标不合理会抛出异常
        if(index < 0 || index > len) {
            throw new IllegalIndexException("下标越界异常");
        }

        //头插
        if(index == 0) {
            addFirst(data);
            return;
        }

        //尾插
        if(index == len) {
            addLast(data);
            return;
        }

        //中间位置
        ListNode<T> prev = findPrevNodeByIndex(index);
        ListNode<T> node = new ListNode<>(data);
        node.next = prev.next;
        prev.next = node;
    }

    public ListNode<T> findPrevNodeByIndex(int index) {
        ListNode<T> cur = this.head;
        int count = 0;
        while(count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }



    @Override
    public boolean remove(T key) {
        if (head == null) {
            return false;
        }

        // 删除头节点
        if (key.equals(head.val)) {
            this.head = this.head.next;
            return true;
        }

        // 找前驱
        ListNode<T> prev = findPrevByValue(key);
        if (prev == null) {
            return false;
        }

        // 删除
        ListNode<T> del = prev.next;
        prev.next = del.next;
        del.next = null;

        return true;
    }

    /**
     * 找到 key 的前一个节点
     */
    private ListNode<T> findPrevByValue(T key) {
        ListNode<T> prev = this.head;
        while (prev.next != null) {
            if (key.equals(prev.next.val)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(T key) {
        //链表为空
        if(this.head == null){
            return;
        }

        ListNode<T> prev = this.head;//要删除的节点的前驱节点
        ListNode<T> cur = this.head.next;//要删除的节点
        while(cur != null){
            if(cur.val.equals(key)){
                prev.next = cur.next;
            }else{
                prev = cur;//prev = prev.next;等价
            }
            cur = cur.next;
        }

        //处理头节点(在前面处理比较复杂)
        if(this.head.val.equals(key)){
            this.head = this.head.next;
        }

    }


    @Override
    public void clear() {
        this.head = null;
    }

}
