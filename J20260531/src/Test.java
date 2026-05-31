/**
 * 测试泛型类的上界
 */
public class Test {
    public static void main1(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        //注意String类型不是Number的子类

        myArray.test();

    }

    public static void main(String[] args) {
        MaxFinder<Integer> maxFinder = new MaxFinder<>();
        System.out.println(maxFinder.findMax(13, 34));
    }
}

/**
 * T必须是Number及其子类
 * 可以以类为上界,也可以以接口为上界
 * 也可以设置多重上界,但只能以一个类为上界,可以有多个接口为上界
 * 既有类为上界也有接口为上界,类写在前面
 * 这里野测试一下以类为上界
 * @param <T>
 */
class MyArray<T extends Number>{

    public void test() {
        System.out.println("测试一下");
    }

}

//这里以接口为上界
class MaxFinder<T extends Comparable<T>>{
    public T findMax(T a,T b) {
        if(a.compareTo(b) > 0) {
            return a;
        }
        return b;
    }
}