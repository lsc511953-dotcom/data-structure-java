/**
 * 在这个类讲一下实现类直接指定类型
 */
public class StringGenerator implements IGenerator<String> {

    @Override
    public String next() {
        return "Hello World";
    }
}

class TestStringGenerator{
    public static void main(String[] args) {
        StringGenerator stringGenerator = new StringGenerator();
        String s1 = stringGenerator.next();
        System.out.println(s1);
    }
}
