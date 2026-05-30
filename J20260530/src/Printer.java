/**
 * 在这个类讲一下泛型方法
 * 泛型方法的类型参数只对这个方法有效
 * 方法的类型参数必须要写到返回值前面
 */
public class Printer {
    public <T> void printArray(T[] array) {
        for(T val: array) {
            System.out.print(val + " ");
        }
    }
    public static void main(String[] args) {
        Printer printer = new Printer();
        Integer[] array = {1,2,3,4,5};
        String[] array2 = {"Java","泛型","好用"};

        printer.printArray(array);
        System.out.println();
        printer.printArray(array2);
    }
}
