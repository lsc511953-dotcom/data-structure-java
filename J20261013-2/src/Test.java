import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class Test {
    /**
     * 使用队列方法(FIFO)
     * @param args
     */
    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(12);
        queue.offer(13);
        queue.offer(14);
        queue.offer(15);
        queue.offer(16);
        queue.offer(17);

        System.out.println(queue.size());//6

        System.out.println(queue.contains(15));//true

        System.out.println(queue.isEmpty());//false

        System.out.println(queue.peek());//12

        System.out.println(queue.poll());//12

        System.out.println(queue.peek());//13
    }

    /**
     *   使用双端队列
     */
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(12);
        deque.offerFirst(11);
        deque.offerFirst(10);
        deque.offerFirst(9);
        deque.offerFirst(8);
        deque.offerFirst(7);
        System.out.println(deque.peekFirst());

        System.out.println(deque.pollFirst());//7

        System.out.println(deque.peekLast());//12
    }

}
