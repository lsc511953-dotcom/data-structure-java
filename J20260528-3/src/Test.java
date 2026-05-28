/**
 * 消失的数字
 * 数组nums包含从0到n的所有整数,但其中缺了一个.请编写代码找出那个缺失的数字.
 * 你有办法时间内完成吗
 */
public class Test {
    /*public static int missingNumber(int[] nums){
        //方法一:求和法
        int n = nums.length;
        //求出理想总和
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        //开始求实际总和
        for(int x : nums) {
            actualSum += x;
        }

        int result = expectedSum - actualSum;

        return result;
    }*/

    public static int missingNumber(int[] nums) {
        //方法二:异或法
        int x = 0;

        for (int i = 0; i <= nums.length; i++) {
            x ^= i;
        }

        for (int n : nums) {
            x ^= n;
        }

        return x;
    }
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int result = missingNumber(nums);
        System.out.println(result);
    }
}
