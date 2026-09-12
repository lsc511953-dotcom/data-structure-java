public class MyLinkedList<T> implements IList<T>{
    static class ListNode<T> {
        T val;//数据域
        ListNode<T> prev;//引用域(保存上一个节点的地址)
        ListNode<T> next;//引用域(保存下一个节点的地址)

        public ListNode(T data) {
            this.val = data;
        }
    }
    ListNode<T> head;
    ListNode<T> last;

    @Override
    public void display() {
        ListNode<T> cur = this.head;
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
    public void addFirst(T data) {
        ListNode<T> node = new ListNode<>(data);
        //链表为空
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        //链表不为空
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);
        //链表为空
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        //链表不为空
        last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    @Override
    public void add(int index, T data) {
        int len = size();

        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置异常");
        }
        //头插
        if(index == 0) {
            addFirst(data);
            return;
        }

        if(index == len) {
            addLast(data);
            return;
        }

        //在中间位置插
        ListNode<T> node = new ListNode<>(data);
        ListNode<T> cur = search(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    private ListNode<T> search(int index) {
        ListNode<T> cur = this.head;
        int count = 0;
        while(count < index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public boolean contains(T key) {
        ListNode<T> cur = this.head;
        while(cur != null) {
            if(cur.val.equals(key)) {
                return true;
            }
            cur= cur.next;
        }
        return false;
    }

    @Override
    public boolean remove(T key) {
        ListNode<T> cur = this.head;
        while(cur != null) {
            //要删除的是头节点
          if(cur.val.equals(key)) {
              if(cur == this.head) {
                  this.head  = this.head.next;
                  if(this.head == null) {
                      this.last = null;
                  }else {
                      this.head.prev = null;
                  }
              } else {
                  //要删除的是尾节点
                  if (cur == this.last) {
                      this.last = cur.prev;
                      this.last.next = null;
                  }else {
                      cur.prev.next = cur.next;
                      cur.next.prev = cur.prev;
                  }
              }
              return true;
          }
          cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean removeAllKey(T key) {
        ListNode<T> cur = this.head;
        boolean removed = false;

        while(cur != null) {
            if(cur.val.equals(key)) {
                // 删除头节点
                if(cur == this.head) {
                    this.head = this.head.next;

                    if(this.head == null) {
                        this.last = null;
                    } else {
                        this.head.prev = null;
                    }
                }
                // 删除尾节点
                else if(cur == this.last) {
                    this.last = cur.prev;
                    this.last.next = null;
                }
                // 删除中间节点
                else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                removed = true;
            }
            cur = cur.next;
        }
        return removed;
    }

    @Override
    public void clear() {
        ListNode<T> cur = this.head;
        while(cur != null) {
            ListNode<T> nextNode = cur.next;
            cur.val = null;
            cur.prev = null;
            cur.next = null;
            cur = nextNode;
        }
        this.head = null;
        this.last = null;
    }
}
