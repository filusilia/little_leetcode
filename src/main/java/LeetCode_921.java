import java.util.Arrays;

/**
 * @author Alice on 2021/6/10
 * @version 1.0
 * @since 1.0
 * <p>
 * 921. 使括号有效的最少添加
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("((("));
    }

    /**
     * 拆分字符串,或者直接循环charAt()
     * 判断单个字符串,把'('作为起始
     * 添加总数count与临时计数temp
     * temp作为计算'('与')'的补偿
     * temp在遇到'('时++,遇到')'时--
     * 如果temp=0时,此时遇到')'的话,直接使用count++,相当于直接补偿一个'('
     * 最后循环结束时,temp>0,说明有'('未补偿')',所以直接使用count+temp;
     *
     * @param s
     * @return
     */
    public static int minAddToMakeValid(String s) {
        char[] c = s.toCharArray();
        int count = 0, temp = 0;
        for (char a : c) {
            if ('(' == a) {
                temp++;
            } else {
                if (temp <= 0) {
                    count++;
                } else {
                    temp--;
                }
            }
        }
        if (temp > 0) {
            count += temp;
        }
        return count;
    }
}
