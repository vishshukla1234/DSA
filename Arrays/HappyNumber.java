import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int num) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (num != 0) {
                sum += Math.pow(num % 10, 2.0);
                num = num / 10;
            }
            if(set.contains(sum))
                return false;

            set.add(sum);
            if (sum == 1)
                return true;
            num = sum;
        }
    }

    public static void main(String[] args) {
        int num = 2;
        System.out.println(isHappy(num));
    }
}
