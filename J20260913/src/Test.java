import java.util.LinkedList;
import java.util.Queue;

public class Test {
    //使用队列的常用方法
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //添加
        queue.offer(12);
        queue.offer(13);
        queue.offer(34);
        queue.offer(23);
        queue.add(16);
        //获取
        System.out.println(queue.peek());//12
        System.out.println(queue.element());//12
        //删除
        System.out.println(queue.poll());//12
        System.out.println(queue.remove());//13

        //长度
        System.out.println(queue.size());//3

        //是否为空
        System.out.println(queue.isEmpty());//false

        //是否包含某个元素
        System.out.println(queue.contains("16"));//false
    }
}
