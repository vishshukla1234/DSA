public class LengthOfLastWord {
    public static int lengthOfWord(String s) {
        int count = 0;
        String trimed = s.trim();
        for(int i = trimed.length()-1; i>=0; i--) {
            if(trimed.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "luffy is still joyboy";
        System.out.println(lengthOfWord(str));
    }
}
