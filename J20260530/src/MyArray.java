/**
 * 在没有泛型之前，如果我们想实现一个可以存放任意类型数据的数组，可以使用 Object。
 * 因为在 Java 中，Object 是所有类的父类，所以任何引用类型对象都可以向上转型为 Object。
 * 使用Object数组有两个问题,一是类型不明确,而是取值时必须强制类型转换
 * 所以我们要引入泛型
 * 在这个泛型类中,T是一个类型参数,表示不确定的类型,同时也是一个占位符,真正的类型在创建对象时才确定下来
 */
public class MyArray<T> {
    private Object[] array = new Object[5];

    public void set(int pos,T val) {
        array[pos] = val;
    }

    public T get(int pos) {
        return (T) array[pos];
    }
}

class TestMyArray{
    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.set(0,1);//这里指定是Integer,所以只能存Integer类型的数据,其他类型不行,编译器会在编译阶段进行检查,防止出错
        myArray.set(1,2);

        int result = myArray.get(0);//不用强制类型转换,因为编译器会在必要的地方插入强制类型转换
        System.out.println(result);
    }
}
