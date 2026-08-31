import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {
    //在这里复习一下ArrayList的构造方式
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();//创建空顺序表,第一次添加元素分配容量
        List<String> list2 = new ArrayList<>(12);//创建制定初始容量的顺序表
        List<String> oldList = List.of("MySQL","数据结构","Redis");
        List<String> list3 = new ArrayList<>(oldList);//使用已有集合创建新的ArrayList
    }

    //在这里复习一下顺序表中的常用方法
    public static void main2(String[] args) {
        List<String> list1 = new ArrayList<>();//在这里创建一个空的顺序表,第一次添加元素时分配容量

        list1.add("MySQL");//尾插

        list1.add(1,"JavaEE");//在指定位置添加元素

        String ret = list1.get(1);//获取元素
        System.out.println(ret);//查看下标为1的元素

        list1.set(0,"数据结构");//修改数据

        list1.remove(1);//按下标删除元素
        System.out.println(list1);

        list1.remove("数据结构");//按对象删除元素
        System.out.println(list1);//[]

        System.out.println(list1.contains("数据结构"));//false

        list1.add("JavaSE");
        list1.add("数据结构");
        list1.add("MySQL");
        //查找元素下标
        int index = list1.indexOf("数据结构");
        System.out.println(index);//1

        //截取子顺序表
        List<String> ret2 = list1.subList(0,2);//实际截取[0,2);
        System.out.println(ret2);
        ret2.remove("数据结构");
        System.out.println(list1);//修改subList得到的结果会影响原顺序表

        //清空元素
        list1.clear();
        System.out.println(list1);
    }

    //在这里复习一下顺序表的遍历
    public static void main3(String[] args) {
        //先传建一个顺序表
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        //普通for循环
        for (int i = 0; i < list1.size();i++) {
            System.out.print(list1.get(i) + " ");
        }

        System.out.println();

        //增强for循环
        for(Integer x : list1) {
            System.out.print(x + " ");
        }

        System.out.println();

        //迭代器遍历
        Iterator<Integer> iterator = list1.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        //双向迭代器遍历
        ListIterator<Integer> listIterator = list1.listIterator(2);

        while(listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }

    //补充:复习一下双向迭代器的其他方法
    public static void main(String[] args) {
        //创建一个顺序表
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ListIterator<Integer> listIterator = list1.listIterator();

        System.out.println(listIterator.nextIndex());//返回下一个元素的下标
        System.out.println(listIterator.previousIndex());//返回上一个元素的下标

        listIterator.next();
        listIterator.next();

        listIterator.add(22);
        System.out.println(list1);//[1, 2, 22, 3]

        //修改最近访问过的元素
        listIterator.next();
        listIterator.set(4);
        System.out.println(list1);

        //删除最近访问过的元素
        listIterator.previous();
        listIterator.remove();
        System.out.println(list1);
    }
}
