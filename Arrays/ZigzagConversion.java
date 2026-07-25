public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int i = 0;
        while(i < s.length()) {
            for(int index = 0; index < numRows && i < s.length(); index++) {
                rows[index].append(s.charAt(i++));
            }
            for(int index = numRows-2; index > 0 && i < s.length(); index--) {
                rows[index].append(s.charAt(i++));
            }
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder row: rows) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}