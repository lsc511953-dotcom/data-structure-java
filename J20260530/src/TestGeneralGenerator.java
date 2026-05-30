
/**
 * 在这个类讲一下泛型接口
 * 泛型接口有两种实现方式
 * 一是实现类保持泛型
 * 二是实现类直接指定类型
 */

//在这个类讲一下实现类保持泛型
class GeneralGenerator<T> implements IGenerator<T>{
    private T data;

    public GeneralGenerator(T data) {
        this.data = data;
    }

    @Override
    public T next() {
        return data;
    }
}

public class TestGeneralGenerator {
    public static void main(String[] args) {
        GeneralGenerator<Integer> generalGenerator = new GeneralGenerator<>(10);
        Integer result = generalGenerator.next();
        System.out.println(result);
    }
}