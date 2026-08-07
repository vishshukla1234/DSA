public class RemoveTrailingZerosFromAString {
    public static String helepr(String num) {
        int i = num.length()-1;
        while(num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i+1);
    }

    public static void main(String[] args) {
        String num = "512305000";
        System.out.println(helepr(num));
    }
}
