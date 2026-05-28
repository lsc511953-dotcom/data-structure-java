import java.util.Arrays;

/**
 * 给定一个数组nums,将数组中的元素想右轮转k个位置,其中k是非负数
 * 示例:
 * nums = [1,2,3,4,5,6,7],k = 3;
 * [5,6,7,1,2,3,4]
 */
public class Solution {
    public static void rotate(int[] nums,int k) {
        int n = nums.length;
        k %= n;

        //翻转全部数组
        reverse(nums,0,n - 1);
        //翻转前k个元素
        reverse(nums,0,k - 1);
        //翻转剩余的元素
        reverse(nums,k,n - 1);
    }

    //辅助函数
    public static void reverse(int[] nums,int start,int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println("轮转前数组: " + Arrays.toString(nums));
        rotate(nums,3);
        System.out.println("轮转后数组: " + Arrays.toString(nums));
    }
}
