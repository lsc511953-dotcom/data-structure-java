/**
 * 在这里讲一下装箱和拆箱
 * 有自动装箱和手动装箱
 * 有自动拆箱和手动拆箱
 */
public class Test {
    public static void main1(String[] args) {
        int a = 10;
        Integer i = a;//自动装箱,手动装箱是Integer i = Integer.valueOf(a);
        System.out.println(a);
    }

    public static void main2(String[] args) {
        Integer i = 10;
        int a = i;//自动拆箱,手动拆箱是int a = i.intValue();
        System.out.println(a);
    }

    //包装类的注意点
    //在-128~127范围内直接使用缓存对象
    //超过这个范围,会直接创建新对象
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;

        Integer c = 150;
        Integer d = 150;

        System.out.println(a == b);//true
        System.out.println(c == d);//false
    }
}
