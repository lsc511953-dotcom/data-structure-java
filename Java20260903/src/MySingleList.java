public class MySingleList<T> implements IList<T>{

    public static class ListNode<T>{
        T val;//数据域
        ListNode<T> next;//引用域(下一个节点的引用)

        public ListNode(T val) {
            this.val = val;
        }
    }

    private ListNode<T> head;//链表的头引用,是访问链表的入口


    @Override
    public void display() {
        ListNode<T> cur = this.head;//不能让head动,防止找不到链表的入口
        //要遍历完,所以不能是cur.next != null
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public int size() {
        ListNode<T> cur = this.head;
        int count = 0;
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
           cur = cur.next;
       }
       return false;
    }

    @Override
    public void addFirst(T data) {
        ListNode<T> node = new ListNode<>(data);//实例化一个链表节点
        //修改指向
        node.next = this.head;//先绑定后面
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        //要找到最后一个节点
        ListNode<T> cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    @Override
    public void add(int index, T data) {
        int len = size();
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("下标越界异常");
        }
        //头插
        if(index ==  0) {
            addFirst(data);
            return;
        }
        //尾插
        if(index == len) {
            addLast(data);
            return;
        }
        //中间位置插
        ListNode<T> node = new ListNode<>(data);
        ListNode<T> prev = findPrevNodeByIndex(index);//找到前一个节点
        //修改指向
        node.next = prev.next;
        prev.next = node;
    }

    private ListNode<T> findPrevNodeByIndex(int index) {
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
        //链表为空
        if(this.head == null) {
            return false;
        }
        //删除头节点
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            return true;
        }
        //找到前一个节点
        ListNode<T> prev = findPrevNodeByValue(key);
        if(prev == null) {
            return false;
        }
        prev.next = prev.next.next;
        return true;
    }

    private ListNode<T> findPrevNodeByValue(T val) {
        ListNode<T> prev = this.head;
        while(prev.next != null) {
            if(prev.next.val.equals(val)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public boolean removeAllKey(T key) {
        if(this.head == null) {
            return false;
        }
        boolean removed = false;
        ListNode<T> prev = this.head;
        ListNode<T> cur = this.head.next;
        while(cur != null) {
            if(cur.val.equals(key)) {
                prev.next = cur.next;
                removed = true;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            removed = true;
        }
        return removed;
    }

    @Override
    public void clear() {
        this.head = null;
    }
}
