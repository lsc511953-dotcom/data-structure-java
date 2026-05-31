
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {
    //在这里讲一下ArrayList的构造方法
    public static void main1(String[] args) {
        List<String> list1 = new ArrayList<>();//创建空顺序表
        List<String> list2 = new ArrayList<>(20);//创建指定容量的顺序表
        List<String> oldList = List.of("Java", "MySQL", "Redis");//静态方法
        List<String> list3 = new ArrayList<>(oldList);//使用已有集合创建顺序表
    }

    public static void main2(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("JavaSE");//添加元素
        list.get(0);//获取元素
        list.set(0,"Java基础语法");//修改元素
        list.remove(0);//删除0下标的元素
        list.add("JavaSE");
        list.remove("JavaSE");//按对象删除
        list.add("JavaSE");
        list.add("数据结构");
        list.add("JavaWeb");
        list.contains("数据结构");//判断对象是否存在
        list.indexOf("数据结构");//查找元素的下标,从前往后找这个对象第一次出现的位置,找不到2返回-1
        list.lastIndexOf("数据结构");//查找元素的下标,从后往前找这个对象第一次出现的位置,找不到返回-1
        List<String> ret = list.subList(0,2);//前闭后开,视图
        System.out.println(ret);
        ret.remove(1);
        list.clear();
    }

    //在这里讲一下ArrayList的遍历方式
    public static void main3(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //方式一
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();

        //方式二:增强for循环
        for(Integer x : list) {
            System.out.print(x + " ");
        }

        System.out.println();

        //方式三:迭代器遍历
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();

        //方式四:双向迭代器遍历
        ListIterator<Integer> listIterator = list.listIterator(list.size());

        while(listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }

    //补讲双向迭代器中的常用方法
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator<Integer> listIterator = list.listIterator();
        listIterator.next();
        System.out.println(listIterator.nextIndex());//返回上一个元素的下标
        System.out.println(listIterator.previousIndex());//返回上一个元素的下标

        listIterator.add(1);//在当前位置添加元素

        listIterator.next();
        listIterator.set(2);//修改最近一次访问过的元素

        listIterator.previous();
        listIterator.remove();//删除最近一次访问的元素
    }
}
