import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test {
    //介绍一下LinedList的构造方法
    public static void main1(String[] args) {
        List<String> list = new LinkedList<>();//无参构造
        list.add("JavaSE");
        list.add("数据结构");
        list.add("MySQL");

        //构造一个包含指定集合中所有元素的链表
        List<String> list2 = new LinkedList<>(list);
        System.out.println(list2);
    }
    //讲一下LinkedList的常用方法
    public static void main2(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("数据结构");
        list.add(1,"MySQL");

        List<String> list2 = new LinkedList<>();
        list2.addAll(list);
        System.out.println(list2);//[数据结构, MySQL]

        list2.remove(0);
        System.out.println(list2);//[MySQL]

        list2.remove("MySQL");
        System.out.println(list2);//[]

        list2.add("JavaSE");
        list2.add("数据结构");
        list2.add("MySQL");
        System.out.println(list2.get(0));//JavaSE

        System.out.println(list2.set(0, "入门语法"));//JavaSE

        list2.clear();
        System.out.println(list2);//[]

        list2.add("JavaSE");
        list2.add("数据结构");
        list2.add("MySQL");

        System.out.println(list2.contains("数据结构"));//true

        System.out.println(list2.indexOf("MySQL"));//2

        System.out.println(list2.lastIndexOf("MySQL"));//2

        List<String> temp = list2.subList(0,2);
        temp.remove("数据结构");

        System.out.println(list2);//[JavaSE, MySQL]
    }

    //在这里讲一下LinkedList的遍历方法
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //增强for循环
        for(Integer x : list){
            System.out.print(x + " ");
        }
        System.out.println();

        //迭代器遍历
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        //双向迭代器遍历
        ListIterator<Integer> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        while(listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}
