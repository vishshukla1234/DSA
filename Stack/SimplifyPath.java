import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] res = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String c: res) {
            if(c.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if(!c.equals("") && !c.equals("..") && !c.equals(".")) {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String i: stack) {
            sb.append("/");
            sb.append(i);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));
    }

}
