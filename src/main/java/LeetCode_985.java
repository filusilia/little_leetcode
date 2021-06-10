import java.util.Arrays;

/**
 * @author Alice on 2021/6/10
 * @version 1.0
 * @since 1.0
 * <p>
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_985 {
    public static void main(String[] args) {
        int[] s = sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
        System.out.println(Arrays.toString(s));
    }

    /**
     * 直接优化算法,先计算当前数组中偶数的和sum,因为返回的是最后和的数组
     * 循环条件数组queries
     * 可以减少计算次数,那么需要判断nums[queries[i][1]]是不是偶数,
     * 假如是偶数,那么判断当前条件数组相加的数queries[i][0]如果是偶数的话,直接给sum加上当前数即可.(因为第一步循环的时候已经相加了当前数组中的偶数)
     * 假如是偶数,那么判断当前条件数组相加的数queries[i][0]如果是奇数的话,直接给sum减去当前数即可.(因为第一步循环的时候已经相加了当前数组中的偶数)
     * 假如是奇数,那么判断当前条件数组相加的数queries[i][0]如果是偶数的话,直接弃用,因为偶数+奇数=奇数.
     * 假如是奇数,那么判断当前条件数组相加的数queries[i][0]如果是奇数的话,给sum加上nums[queries[i][1]]+queries[i][0].
     *
     * @param nums
     * @param queries
     * @return
     */
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] after = new int[queries.length];
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (nums[queries[i][1]] % 2 == 0) {
                if (queries[i][0] % 2 == 0) {
                    sum += queries[i][0];
                } else {
                    sum -= nums[queries[i][1]];
                }
            } else {
                int temp = nums[queries[i][1]] + queries[i][0];
                if (temp % 2 == 0) {
                    sum += temp;
                }
            }
            after[i] = sum;
            nums[queries[i][1]] += queries[i][0];
        }
        return after;
    }
}
