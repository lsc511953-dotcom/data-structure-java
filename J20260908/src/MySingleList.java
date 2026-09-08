public class MySingleList<T> implements IList<T> {

    public static class ListNode<T>{
        T val;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }

    private ListNode<T> head;//链表的头引用,链表的入口

    @Override
    public void display() {
        ListNode<T> cur = this.head;//不要让head动
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
        ListNode<T> node = new ListNode<>(data);//实例化一个节点
        node.next = this.head;
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);
        //链表为空
        if(this.head == null) {
            this.head = node;
            return;//注意要返回,不然会执行后面的代码
        }
        //链表不为空,要找到最后一个节点
        ListNode<T> cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        //执行完上面的代码,已经找到最后一个节点了
        cur.next = node;//绑定后面
    }

    @Override
    public void add(int index, T data) {
        int len = size();
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置不合法");
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

        //任意位置插入
        ListNode<T> prev = findPrevByIndex(index);//找到前一个节点
        ListNode<T> node = new ListNode<>(data);//实例化一个节点
        node.next = prev.next;
        prev.next = node;
    }

    //查找前一个节点
    private ListNode<T> findPrevByIndex(int index) {
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
        if(this.head == null) {
            return false;
        }

        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            return true;
        }

        ListNode<T> prev = findPrevByValue(key);
        if(prev == null) {
            return false;
        }

        prev.next = prev.next.next;
        return true;
    }

    private ListNode<T> findPrevByValue(T key) {
        ListNode<T> prev = this.head;

        while(prev.next != null) {
            if(prev.next.val.equals(key)) {
                return prev;
            }
            prev = prev.next;
        }

        return null;
    }

    @Override
    public void removeAllKey(T key){
        //链表为空
        if(this.head == null) {
            return;
        }
        ListNode<T> prev = this.head;
        ListNode<T> cur = this.head.next;
        while(cur != null) {
            if(cur.val.equals(key)) {
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        //检查头节点
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
        }

    }

    @Override
    public void clear() {
        this.head = null;
    }
}
